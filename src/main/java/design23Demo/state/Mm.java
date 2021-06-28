package design23Demo.state;

public class Mm {


    //    public static Object MmState;
     String name;
     public enum MmState {Happy,sad};
     MmState state;

    public Mm() {
         this.state = MmState.sad;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MmState getState() {
        return state;
    }

    public void setState(MmState state) {
        this.state = state;
    }

    public void smile(){
//         swicth case
        switch (this.state){
            case sad:
                System.out.println("yingyingying");
                break;
            case Happy:
                System.out.println("hahahaha");
        }
     }

    public void cry(){
//         swicth case
    }

    public void say(){
//         swicth case
    }
}
