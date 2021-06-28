package leetCode;

import scala.Char;

import java.util.LinkedList;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LeeCodeNum3Solution2 {

    public static void main(String[] args) {
       String s ="BBB";
        int x = 0;
        int y = 1;
        int maxLength=0;
        int currentLength;
        char[] chars = s.toCharArray();
        while(x<=s.length()-1){
            if (s.length()==1){
                maxLength=1;
                break;
            }
            //    y大于等于最大长度
            if (y==s.length()-1){
                char yChar = chars[y];
                if (s.substring(x,y).indexOf(yChar)!=-1){
                    //相同记录当前相同长度
                    currentLength=y-x;
                    //如果當前长度大于最大长度 替换
                    if (maxLength<currentLength){
                        maxLength=currentLength;
                    }
                }else {
                    //相同记录当前相同长度
                    currentLength=y-x+1;
                    //如果當前长度大于最大长度 替换
                    if (maxLength<currentLength){
                        maxLength=currentLength;
                    }
                }
                break;
            }
            char yChar = chars[y];
            if (s.substring(x,y).indexOf(yChar)!=-1){
                //相同记录当前相同长度
                currentLength=y-x;
                //如果當前长度大于最大长度 替换
                if (maxLength<currentLength){
                    maxLength=currentLength;
                }
                x=s.substring(x,y).indexOf(yChar)+x+1;
                y=x+1;
            }else {
                //相同记录当前相同长度
                currentLength=y-x;
                //如果當前长度大于最大长度 替换
                if (maxLength<currentLength){
                    maxLength=currentLength;
                }
                y++;

            }
        }
        System.out.println(maxLength); ;
    }}