package BioNioAio.NettyImlRPC;
import BioNioAio.NettyImlRPC.Client.RpcConsumerProxy;
import BioNioAio.NettyImlRPC.Server.IOperationService;
import BioNioAio.NettyImlRPC.Server.IStudentSevice;

public class RpcConsumer {
    public static void main(String[] args) {
        RpcConsumerProxy proxy = new RpcConsumerProxy(8080);
        IStudentSevice studentSevice =  proxy.createInstance(IStudentSevice.class);
        System.out.println("获取学生名字: " + studentSevice.getStudentName(1));
        IOperationService operationService = proxy.createInstance(IOperationService.class);
        System.out.println("a + b = " + operationService.add(8,2));
        System.out.println("a - b = " + operationService.minus(8,2));
        System.out.println("a * b = " + operationService.mul(8,2));
        System.out.println("a / b = " + operationService.div(8,2));
    }

}
