package BioNioAio.Netty.NettyGettingStarted;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

/**
 处理服务器端通道
 ChannelInboundHandlerAdapter
 Inbound--入站
**/
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
//       Discard the reveived data silently
//        ((ByteBuf)msg).release();
        ByteBuf in = (ByteBuf) msg;
        try {
            // Do something with msg
            while (in.isReadable()){
                System.out.print((char) in.readByte());
                System.out.flush();
            }

        } finally {
//            处理完必须释放掉资源
            ReferenceCountUtil.release(msg);
        }

    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }
}
