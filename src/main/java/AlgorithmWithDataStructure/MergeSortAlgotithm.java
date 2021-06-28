package AlgorithmWithDataStructure;
/*
归并排序
* */
public class MergeSortAlgotithm {
    static  Comparable[] temporary;


    //  比较大小
    public static Boolean compare(Comparable c1,Comparable c2){
        if (c1.compareTo(c2)>0){
            return true;
        }
        return false;
    }
//
    public static Comparable[] sort(Comparable[] comparables){
        temporary = new Comparable[comparables.length];
        int start=0;
        int end = temporary.length-1;
        sort(comparables,start,end);
        return comparables;
    }
//   进行分拆數組
    public static void sort(Comparable[] comparables,int start,int  end){
        //安全性校验  0 1 2 3
        if (end<=start){
            return;
        }
        //获取中级值   int類型的值会自动取整  如果算出来是0.5取0，是1.5取1.是复制-1.5 取整数部分为-1
        int mid= start+(end-start)/2;
        //排序前半部分
        sort(comparables,start,mid);
        //排序后半部分
        sort(comparables,mid+1,end);
        //进行归并
        mergePart(comparables,start,mid,end);
    }

//  进行归并
    public static void mergePart(Comparable[] comparables,int start,int mid,int  end){
//        定义三个指针 i指针给临时数组使用
        int i=start;
//        p1记录前半部分数组的起始位置
        int p1=start;
//        p1记录后半部分数组的起始位置
        int p2=mid+1;
//      移动指针，
        while(p1<=mid&&p2<=end){
            if (compare(comparables[p1],comparables[p2])){
                temporary[i++]=comparables[p2++];
            }else {
                temporary[i++]=comparables[p1++];
            }
        }
//        如果前半部分指针未移动完，进行移动 将前半数组的值放入临时数组
        while(p1<=mid){
            temporary[i++]=comparables[p1++];
        }
//        如果后半部分指针未移动完，进行移动 将后半数组的值放入临时数组
        while(p2<=end){
            temporary[i++]=comparables[p2++];
        }
//        將临时数组的值,复制给需要进行排序的数组
        for (int index = 0; index <=end; index++) {
            comparables[index]=temporary[index];
        }
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
        MergeSortAlgotithm.sort(comparables);
        for (int i = 0; i < comparables.length; i++) {
            System.out.println(comparables[i ].toString());
        }
//        System.out.println(comparables);
    }
}