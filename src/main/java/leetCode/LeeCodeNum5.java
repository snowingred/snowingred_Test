package leetCode;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * 回文串：正着读和反着读都一样的字符串
 */
public class LeeCodeNum5 {
    public static void main(String[] args) {
        String s="aacabdkacaa";
        //找出每个回文子串,比较回文子串长度,相同保留当前回文子串
        char[] chars = s.toCharArray();
        int max=0;
        String maxString = s.substring(0,1);
        for (int first = 0; first < s.length()-1; first++) {

        }
        //1.当前下标,和下一个内容是否一致。
        //2.当前下标的 前一个后一个的内容是否一致
        System.out.println(maxString);

    }

}


    /*      回文串：正着读和反着读都一样的字符串  理解为重复字符了
            int index =first;  //2
            if (s.length()-1>=index++){  //abdkacaa
                String substring = s.substring(index++);
                if (substring.indexOf(chars[first])!=-1){ //
                    int last = substring.indexOf(chars[first]); //6
                    int length = last+1;
                    if (max<length){
                        max=last;
                        maxString=s.substring(first,last+first+2);
                    }
                };
            }*/

         /*  没考虑到字符串重复问题
            int last = s.lastIndexOf(chars[first]);
            int length=last-first+1;
            if (max<length){
                max=length;
                maxString=s.substring(first,last+1);
            }*/