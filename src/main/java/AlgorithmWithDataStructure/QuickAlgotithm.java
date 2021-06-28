package AlgorithmWithDataStructure;

import org.omg.PortableInterceptor.INACTIVE;

/*
* 快速排序
* */
public class QuickAlgotithm {

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
        int start=0;
        int end = comparables.length-1;
        sort(comparables,start,end);
        return comparables;
    }

    //   进行分拆數組
    public static void sort(Comparable[] comparables,int start,int  end){
        //安全性校验
        if (end<=start){
            return;
        }
        //先对数组进行排序 找出parttion 分界点的下标位置
        int parttion = parttion(comparables, start, end);
        //排序前半部分
        sort(comparables,start,parttion-1);
        //排序后半部分
        sort(comparables,parttion+1,end);
    }

    //  进行归并
    public static int parttion(Comparable[] comparables,int start,int  end){
        Comparable key=comparables[start];
        //定义指针
        int p1=start;
        int p2=end+1;
        while(true){
            //寻找p2 中 比起始位置小的值
            while(compare(key,comparables[--p2])){
                if (p2==start){
                break;
                }
            }
            //寻找p1 中 比起始位置大的值
            while(compare(comparables[++p1],key)){
                if (p1==end){
                    break;
                }
            }
            if (p1>=p2){
                break;
            }else {
                exchange(comparables,p1,p2);
            }

        }
        exchange(comparables,start,p2);
        return p2;

    }

    public static void main(String[] args) {
        //数组的三种生成方式
        //int[] maoPaoArr=  new int[10];
        //int maoPaoArr=arr[10]
        //int[] maoPaoArr= {1,5,8,7,9,7,8,5,2,4,3};
        Student z1 = new Student(10, "周");
        Student z2 = new Student(12, "周");
        Student z7 = new Student(16, "周");
        Student z3 = new Student(18, "周");
        Student z4 = new Student(14, "周");
        Student z5 = new Student(15, "周");
        Student z6 = new Student(13, "周");

        Comparable[] comparables ={z1,z6,z3,z4,z5,z2,z7};
        QuickAlgotithm.sort(comparables);
        for (int i = 0; i < comparables.length; i++) {
            System.out.println(comparables[i ].toString());
        }
//        System.out.println(comparables);
    }

}
