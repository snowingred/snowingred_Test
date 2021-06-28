package BioNioAio.Netty;

import io.netty.buffer.ByteBuf;
import io.netty.util.CharsetUtil;
import org.apache.flink.shaded.netty4.io.netty.channel.ChannelHandlerContext;
import org.apache.flink.shaded.netty4.io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * 自定义创建一个Handler  需要继承netty 规定好的某个 HandlerAdapter
 */
public class NettyServerHandle extends ChannelInboundHandlerAdapter {


    /**
     * 读取数据实际
     * @param ctx  上下对象,含有管道pipeline  通道channel
     * @param msg
     * @throws Exception
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("serverCtx="+ctx);
//        将msg转为ByteBuf
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("客户端输出信息为"+buf.toString(CharsetUtil.UTF_8));
        System.out.println("客戶端地址"+ctx.channel().remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        super.channelReadComplete(ctx);
    }
}
