package design23Demo.state;

public class MmStateMain {
    public static void main(String[] args) {
//      枚举方式 实现Mm在不同状态的笑 哭和 说
        Mm mm = new Mm();
//      mm.setState(Mm.MmState.sad);
        mm.state= Mm.MmState.Happy;
        mm.smile();
//      状态模式 MmHappyState状态 传入 Mm2对象
        MmState mmHappyState = new MmHappyState();
        Mm2 mm2 = new Mm2(mmHappyState);
        mm2.smile();
    }


}
