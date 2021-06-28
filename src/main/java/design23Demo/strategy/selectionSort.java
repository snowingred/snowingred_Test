package design23Demo.strategy;

public class selectionSort {
    public static <T> T[] selectionSort(T[] array,Comparator<T> comparable) {
        if (array.length == 0)
            return (T[])array;
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i; j < array.length; j++) {

                if (comparable.compare(array[j],array[minIndex])==-1) //找到最小的数
                    minIndex = j; //将最小数的索引保存
            }
            T temp = (T)array[minIndex];
            array[minIndex] = array[i];
            array[i] = temp;
        }
        return (T [])array;
    }
}
