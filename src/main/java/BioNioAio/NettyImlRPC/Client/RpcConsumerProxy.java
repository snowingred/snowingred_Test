package BioNioAio.NettyImlRPC.Client;

import BioNioAio.NettyImlRPC.RpcInvocationProtocol;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class RpcConsumerProxy implements InvocationHandler {
    private int port;
    private Class clazz;

    public RpcConsumerProxy(int port ){
        this.port = port;
    }

    public <T> T createInstance(Class<T> clazz){
        this.clazz=clazz;
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{clazz},this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //组装对象
        RpcInvocationProtocol protocol = new RpcInvocationProtocol();
        protocol.setClassName(clazz.getName());
        protocol.setMethodName(method.getName());
        protocol.setTypes(method.getParameterTypes());
        protocol.setValues(args);

        final RpcConsumerHandler consumerHandler = new RpcConsumerHandler();
        //远程传输
        NioEventLoopGroup workGroup  = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();

        try {
        bootstrap.group(workGroup).channel(NioSocketChannel.class)
//           启动TCP_NODELAY，就意味着禁用了Nagle算法，允许小包的发送。对于延时敏感型，同时数据传输量比较小的应用，
//           开启TCP_NODELAY选项无疑是一个正确的选择。比如，对于SSH会话，用户在远程敲击键盘发出指令的速度相对于网络带宽能力来说，
//           绝对不是在一个量级上的，所以数据传输非常少；而又要求用户的输入能够及时获得返回，有较低的延时。
                .option(ChannelOption.TCP_NODELAY,true)
                .handler((new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
                        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0,
                                4, 0, 4))
                                .addLast(new LengthFieldPrepender(4))
                                .addLast("encoder", new ObjectEncoder())
                                .addLast("decoder", new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)))
                                .addLast(consumerHandler);
                    }
                })).option(ChannelOption.SO_KEEPALIVE, true) ;//长连接;
        ChannelFuture future = bootstrap.connect("localhost", port).sync();
        future.channel().writeAndFlush(protocol).sync();
        future.channel().closeFuture().sync();
    }catch (Exception e){
        e.printStackTrace();
    }finally {
        workGroup.shutdownGracefully();
    }
        return consumerHandler.getContent();
    }
}
