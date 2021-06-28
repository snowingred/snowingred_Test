package BioNioAio.NettyImlRPC.Server;

public interface IOperationService {
    /**
     * 加
     */
    int add(int a, int b);

    /**
     * 减
     */
    int minus(int a, int b);


    /**
     * 乘
     */
    int mul(int a, int b);


    /**
     * 除
     */
    int div(int a, int b);

}
