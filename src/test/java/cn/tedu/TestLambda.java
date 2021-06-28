package cn.tedu;

import java.util.Vector;

public class TestLambda {
    public static void main(String[] args) {
        MathOperation mathOperation=(int x,int y)->{
            x=x*y;
            return x;
        };
    }
    interface MathOperation{
      int  MathOperation(int x,int y);
    }
}
