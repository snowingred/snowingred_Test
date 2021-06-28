package BioNioAio.Netty.TimeServer;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.Date;

/**
 处理服务器端通道
 ChannelInboundHandlerAdapter
 Inbound--入站
**/
public class EchoServerHandler extends ChannelInboundHandlerAdapter {

/*    *//**
     4        * 建立连接时，发送一条庆祝消息
     5        *//*
        @Override
       public void channelActive(ChannelHandlerContext ctx) throws Exception {
            // 为新连接发送庆祝
              ctx.write("Welcome to " + InetAddress.getLocalHost().getHostName() + "!\r\n");
                 ctx.write("It is " + new Date() + " now.\r\n");
               ctx.flush();
             }*/

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//       Discard the reveived data silently
//        ((ByteBuf)msg).release();
     /*    ByteBuf in = (ByteBuf) msg;
        ctx.write(msg); // (1)*/


   /*     try {



        } finally {
//            处理完必须释放掉资源
            ReferenceCountUtil.release(msg);
        }*/

        ByteBuf m = (ByteBuf) msg; // (1)
        try {
            long currentTimeMillis = (m.readUnsignedInt() - 2208988800L) * 1000L;
            System.out.println(new Date(currentTimeMillis));
            ctx.close();
        } finally {
            m.release();
        }

    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush(); // (2)
    }

    /*
写回数据给客户端
Fri Mar 12 12:52:04 CST 2021
* */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ByteBuf time = ctx.alloc().buffer(4);
        time.writeInt((int)(System.currentTimeMillis()/1000L +2208988800L));
//      Netty writeAndFlush();方式是异步执行的,这时候iO操作并为发生,需要在完成之后关闭,
        ChannelFuture f = ctx.writeAndFlush(time);
//        所以需要加油一个ChannelFutureListener,去监听IO操作是否完成
        f.addListener(new ChannelFutureListener() {
            @Override
            public void operationComplete(ChannelFuture future) throws Exception {
                assert f == future;
                ctx.close();
            }
        });
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
