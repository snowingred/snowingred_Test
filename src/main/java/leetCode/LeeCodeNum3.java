package leetCode;

import java.time.Year;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeeCodeNum3 {

/*    public static void main(String[] args) {
        String s=" ";
        char[] chars = s.toCharArray();
   *//*     char[] chars = new char[s.length()];
        s.getChars(0,s.length(),chars,0);
        System.out.println(chars);*//*
//      記錄数组下标位置
        int x = 0;
//      记录最大值
        int y = 1;
        while (x<chars.length){
            char xChar = chars[x];
            for (int i = x+1; i < chars.length; i++) {
                if (xChar==chars[i]){
                    if (y<i-x){
                    y=i-x;
                    }
                    break;
                }
            }
            x++;
        }
        HashMap<String, String> map = new HashMap<>();
        map.put("111","111");
        map.put("222","222");
        System.out.println(y);
    }*/

    public static void main(String[] args) {
          int X=0;
          int max=0;
          String string ="asfsafasfas";
            char[] chars = string.toCharArray();
            LinkedList<Character> strings = new LinkedList<>();
          while(X<chars.length){
              int length=0;
              int Y=X;
              for (int i = X; i <string.length() ; i++) {
                  if (chars[Y]==chars[X]){
                      int first = strings.indexOf(chars[i]);
                      length=i-first;
                      X=first+1;
                      Y++;
                  }else {
                      Y++;
                      strings.add(chars[i]);
                      length=strings.size();
                  }
                  max=Math.max(length,max);
              }
              X=X++;
          }
        System.out.println(max);

    }
}