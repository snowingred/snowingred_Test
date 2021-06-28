package BioNioAio.NettyImlRPC.Client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

public class RpcConsumerHandler extends ChannelInboundHandlerAdapter {

    private Object content;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
       this.content=msg;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("客户端异常");
    }


    public Object getContent() {
        return this.content;
    }
}
