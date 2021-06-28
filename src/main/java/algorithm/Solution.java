package algorithm;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ints = new int[2];
//        能遍历出来返回ints
        for (int i=0;i<nums.length;i++){
              for (int j=i+1;j<nums.length;j++){
                  if (nums[i]+nums[j]==target){
                      ints[0]=i;
                      ints[1]=j;
                      return ints;
              }
          }
        }
//      没有符合的数据返回null
        return null;
    }


        public int[] twoSum2(int[] nums, int target){
            int volume = 2<<10; //2048   100000000000
            int bitNum = volume-1; //11111111111
            int[] res = new int[volume];
            for(int i=0;i<nums.length;i++){
                int c = (target-nums[i])&bitNum;
                if(res[c]!=0){
                    return new int[]{res[c]-1,i};
                }
                res[nums[i]&bitNum] = i+1;
            }
            throw new IllegalArgumentException("No two sum solution");
        }


    class Solution3 {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> hashtable = new HashMap<Integer,Integer>();
            for(int i=0;i<nums.length;i++){
                if(hashtable.containsKey(target-nums[i])){
                    return new int[]{hashtable.get(target-nums[i]),i};
                }
                hashtable.put(nums[i],i);
            }
            return new int[0];
        }
    }

    public static void main(String[] args) {
        int[] nums= {-1,-2,-3,-4,-5};
        int target = -8;
        Solution solution = new Solution();
        int[] ints = solution.twoSum2(nums, target);
        int volume = 2<<10;
        System.out.println(volume);
        System.out.println(Arrays.toString(ints));
    }
}
