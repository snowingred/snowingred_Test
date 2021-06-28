package AlgorithmWithDataStructure;
//希尔排序
/*
1.选定一个增长量h，按照增长量h作为数组分组依据,对数据进行分组
2.对分好的每一组数据完成查询排序
3.减小增长量,最小缩减为1,重复第二步
* */
public class HillAlgotithm {
    //  交换数组位置
    public static void exchange(Comparable[] comparables,int i,int j){
        Comparable exchange;
        exchange=comparables[i];
        comparables[i]=comparables[j];
        comparables[j]=exchange;
    }
    //  比较大小
    public static Boolean compare(Comparable c1,Comparable c2){
        if (c1.compareTo(c2)>0){
            return true;
        }
        return false;
    }

    public static Comparable[] sort(Comparable[] comparables){
        //选定增长量h
        int N=comparables.length;
        int h=1;
        while (h<N/2){
          h=2*h+1;
        }
        while(h>=1){
        for (int i = 0; i < comparables.length-h; i++) {
            if (compare(comparables[i],comparables[i+h])){
                exchange(comparables,i,i+h);
            }
        }
            h=h>>1;
    }
        return comparables;
    }


    public static void main(String[] args) {
        //数组的三种生成方式
        //int[] maoPaoArr=  new int[10];
        //int maoPaoArr=arr[10]
        //int[] maoPaoArr= {1,5,8,7,9,7,8,5,2,4,3};
        Student z1 = new Student(10, "周");
        Student z2 = new Student(12, "周");
        Student z3 = new Student(18, "周");
        Student z12= new Student(10, "周");
        Student z7 = new Student(175, "周");
        Student z8 = new Student(19, "周");
        Student z9 = new Student(4, "周");
        Student z11 = new Student(57, "周");
        Student z10 = new Student(26, "周");
        Student z4 = new Student(14, "周");
        Student z5 = new Student(15, "周");
        Student z6 = new Student(16, "周");
        Comparable[] comparables ={z1,z2,z3,z4,z5,z6,z8,z7,z11,z12,z9,z10};
        Comparable[] sort = HillAlgotithm.sort(comparables);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i].toString());
        }
        int h=5;
        int j = h;

            System.out.println(j-=h);

//        System.out.println(comparables);
    }
}
