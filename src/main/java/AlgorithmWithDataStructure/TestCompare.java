package AlgorithmWithDataStructure;

public class TestCompare {
    public static Comparable getMax(Comparable c1,Comparable c2){
       if (c1.compareTo(c2)>0){
       return c1;
       }
       return  c2;
    }
    public static void main(String[] args) {
        Student z1 = new Student(10, "周");
        Student z2 = new Student(13, "周");
        Comparable max = TestCompare.getMax(z1, z2);
        System.out.println(max.toString());
    }
}
