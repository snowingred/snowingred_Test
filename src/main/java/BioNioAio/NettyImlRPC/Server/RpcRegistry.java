package BioNioAio.NettyImlRPC.Server;

import com.sun.org.apache.bcel.internal.generic.NEW;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;

public class RpcRegistry {
    int port;

    public RpcRegistry(int port) {
        this.port = port;
    }

    public void start(){
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try{
        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup,workerGroup).channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                        ChannelPipeline pipeline = ch.pipeline();
//                   LengthFieldBasedFrameDecoder解码器自定义长度解决TCP粘包黏包问题。所以LengthFieldBasedFrameDecoder又称为: 自定义长度解码器
                        pipeline.addLast(new LengthFieldBasedFrameDecoder(Integer.MAX_VALUE, 0,
                                4, 0, 4))
                                .addLast(new LengthFieldPrepender(4))
                                .addLast("encoder",new ObjectEncoder())
                                .addLast("decoder",new ObjectDecoder(Integer.MAX_VALUE, ClassResolvers.cacheDisabled(null)))
                                .addLast(new RpcRegistryHandler());
                    }
                }).option(ChannelOption.SO_BACKLOG,128)
        .childOption(ChannelOption.SO_KEEPALIVE,true);
        ChannelFuture future = serverBootstrap.bind(this.port).sync();//异步io操作
        System.out.println("NIO Server Channel,绑定的端口:" + this.port);
        future.channel().closeFuture().sync();
    }catch (Exception e){
        bossGroup.shutdownGracefully();
        workerGroup.shutdownGracefully();
    }
    }

    public static void main(String[] args) {
        new RpcRegistry(8080).start();
    }

}
