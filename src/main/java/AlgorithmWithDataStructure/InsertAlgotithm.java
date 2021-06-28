package AlgorithmWithDataStructure;
//插入排序
public class InsertAlgotithm {
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

//      遍历
        for (int i = 1; i <comparables.length ; i++) {
//          对数组进行复制和比较
            for (int j = i; j >0; j--) {
//                j位置的数据与j-1的位置为比较,j大戝交换位置,j-1大则退出循环
                if(compare(comparables[j],comparables[j-1])){
                    exchange(comparables,j,j-1);
                }else{
                    break;
                }
            }
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
        Student z4 = new Student(14, "周");
        Student z5 = new Student(15, "周");
        Student z6 = new Student(16, "周");
        Comparable[] comparables ={z1,z2,z3,z4,z5,z6};
        Comparable[] sort = ChoiceAlgotithm.sort(comparables);
        for (int i = 0; i < sort.length; i++) {
            System.out.println(sort[i].toString());
        }
//        System.out.println(comparables);
    }
}
