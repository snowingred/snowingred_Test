package BioNioAio.Netty;


import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

/**
 * 创建Netty测试
 */
public class NettySimple {
    public static void main(String[] args) throws InterruptedException {
//      Boss Group. WorkGroup 无限循环组
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workGroup = new NioEventLoopGroup();
//      服务器启动助手
        ServerBootstrap serverBootstrap = new ServerBootstrap();
//      链式设置配置,设置俩个线程组。
        serverBootstrap.group(bossGroup,workGroup)
                .channel(NioServerSocketChannel.class) //bossGroup使用
                .option(ChannelOption.SO_BACKLOG,128)  //设置线程队列取到的连接个数
                .childOption(ChannelOption.SO_KEEPALIVE,true)
                .childHandler(new ChannelInitializer<SocketChannel>() { //SocketChannel 是给workGroup使用
                    @Override
                    protected void initChannel(SocketChannel socketChannel) throws Exception {
                        socketChannel.pipeline().addLast();
                    }//创建一个通道初始化对象
                    //向workGroup的pipeLine设置处理器
                });
        System.out.println("服务器已经准备好了---");
//      启动并且绑定端口
        ChannelFuture cf = serverBootstrap.bind(9999).sync();
//        对关闭通道进行监听
        cf.channel().closeFuture().sync();



    }
}
