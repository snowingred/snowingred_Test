package design23Demo.Decorator;

public class Decorator {
    public static void main(String[] args) {
        people people = new people();
        people.say();
        Amplifer amplifer = new Amplifer(people);
        amplifer.say();
    }
}
interface  Say{
    void say();
}
class people implements Say{
    private int voice=10;

    @Override
    public String toString() {
        return "people{" +
                "voice=" + voice +
                '}';
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }

    public int getVoice() {
        return voice;
    }

    @Override
    public void say() {
        System.out.println("人的声音"+this.getVoice());
    }
}
class Amplifer implements Say{
    private people p;

    Amplifer(people p){
        this.p =p;
    }

    @Override
    public void say() {

        System.out.println(p.getVoice()*100);
    }
}