package design23Demo.state;

public class Mm2 {

    MmState mmState;

    public void  Mm2(){

    }

    public  Mm2(MmState state){
        this.mmState=state;
    }

    public void smile(){
        mmState.smile();
    }

    public void cry(){
        mmState.cry();
    }

    public void say(){
        mmState.say();
    }
}
