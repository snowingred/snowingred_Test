package design23Demo.strategy;

import java.util.Arrays;

public class TestSortMain {
    public static void main(String[] args) {
//        int[] a={1,5,2,6,8,4};
//       问题1： 如果不是int数组了呢 是double类型了 
//        回答：可以selectionSort方法的传递值改成double
//        int[] ints = selectionSort.selectionSort(a);
//
        //       问题2： 如果不是int数组了呢 是cat类型了 
//        回答：//       问题1： 如果不是int数组了呢 是double类型了 
////        回答：可以selectionSort方法的传递值改成Cat
//        Cat cat = new Cat(3,5);
//        Cat cat1 = new Cat(2,6);
//        Cat cat2 = new Cat(1,4);
//        Cat[] catarray={cat,cat1,cat2 };
//        Cat[] cats = selectionSort.selectionSort(catarray);
//        System.out.println(Arrays.toString(cats));


        Dog dog = new Dog(3);
        Dog dog1 = new Dog(4);
        Dog dog2 = new Dog(1);
        Dog[] dogarray={dog,dog1,dog2 };
        Dog[] dogs = selectionSort.selectionSort(dogarray, new Comparator<Dog>() {
            @Override
            public int compare(Dog o1, Dog o2) {
                if (o1.Food>o2.Food){
                    return 1;
                }else if(o1.Food<o2.Food){
                    return -1;
                }
                return 0;
            }
            }
        );
        System.out.println(Arrays.toString(dogs));
    }

}
