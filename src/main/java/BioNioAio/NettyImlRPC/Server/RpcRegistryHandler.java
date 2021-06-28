package BioNioAio.NettyImlRPC.Server;
import BioNioAio.NettyImlRPC.RpcInvocationProtocol;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class RpcRegistryHandler extends ChannelInboundHandlerAdapter   {

   private List<String> classNameList= new ArrayList();
   private ConcurrentHashMap<String,Object> BeanProxyMap=new ConcurrentHashMap();

    public RpcRegistryHandler() {
        //扫描文件
        scannerFile("BioNioAio.NettyImlRPC.Server");
        //注册
        doRegister();
    }

    private void doRegister() {
        if(classNameList.isEmpty()){
            return;
        }
            try {
                for (String className:classNameList){
                    Class<?> classzz = Class.forName(className);
                    Class<?>[] anInterface = classzz.getInterfaces();
                if (anInterface.length!=0){
                    String name = classzz.getInterfaces()[0].getName();
                    BeanProxyMap.put(name,classzz.newInstance());}
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }

    }
//  扫描当前包下面的所有文件,放入classNameList
    private void scannerFile(String packageName) {
        if(packageName.isEmpty()){
            return;
        }
        URL resource = this.getClass().getClassLoader().getResource(packageName.replaceAll("\\.", "/"));
        for (File childfile:(new File(resource.getFile()).listFiles())){
             if (childfile.isFile()){
                 classNameList.add(packageName+"."+childfile.getName().replace(".class",""));
             }else {
                 scannerFile(packageName+"."+childfile.getName());
             }
        }
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcInvocationProtocol protocol  = (RpcInvocationProtocol) msg;
        Object result = null;
        if (BeanProxyMap.containsKey(protocol.getClassName())){
            Object service = BeanProxyMap.get(protocol.getClassName());
            Method method = service.getClass().getMethod(protocol.getMethodName(), protocol.getTypes());
            result = method.invoke(service,protocol.getValues());
        }
        ctx.writeAndFlush(result);
        ctx.close();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        System.out.println("异常错误");
    }

}
