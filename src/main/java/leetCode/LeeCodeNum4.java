package leetCode;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LeeCodeNum4 {
    public static void main(String[] args) {
        int[] nums1={1,2};
        int[] nums2= {4,3};
        int[] Arr=new int[nums1.length+ nums2.length];
        System.arraycopy(nums1,0,Arr,0,nums1.length);
        System.out.println(Arrays.toString(Arr));
        System.arraycopy(nums2,0,Arr,nums1.length,nums2.length);
        System.out.println(Arrays.toString(Arr));
        int[] pointArr = Arrays.stream(Arr).sorted().toArray();
        System.out.println(Arrays.toString(pointArr));
        if (pointArr.length==0){

        }else if (pointArr.length%2==1){
            int i = pointArr.length / 2 + 1;
            double lastNum = pointArr[i];
            System.out.println(lastNum);
        }else {
            int i = pointArr.length / 2;
            int j = pointArr.length / 2 -1;
            double lastNum= ((double)pointArr[i]+(double)pointArr[j])/2;
            System.out.println(lastNum);

        }
    }
}
