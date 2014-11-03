package p2pchat;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.util.ReferenceCountUtil;
import base.ServerHandler;


/**
 * Handles a server-side channel.
 */
public class P2PServerHandler extends ServerHandler {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
    	 ByteBuf in = (ByteBuf) msg;
    	    try {
    	        while (in.isReadable()) {
    	            System.out.print((char) in.readByte());
    	            System.out.flush();
    	        }
    	    } finally {
    	        ReferenceCountUtil.release(msg);
    	    }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        // Close the connection when an exception is raised.
        cause.printStackTrace();
        ctx.close();
    }

	@Override
	public void channelActive(ChannelHandlerContext ctx) {
		// TODO Auto-generated method stub
		
	}
}