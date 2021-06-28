package design23Demo.ChainResponsibility;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.util.ArrayList;
import java.util.List;

public class ChainRes {
    public static void main(String[] args) {
//        Msg msg = new Msg();
        Request request = new Request();
        request.setRequest("大家好：),<script>,欢迎访问mashibing.com,大家都是996");
////   处理msg
        Reponse reponse = new Reponse();
        reponse.setReponse("----------返回了什么");

        FilterChain filterChain = new FilterChain();
        HTMLFilter htmlFilter = new HTMLFilter();
        SensitiveFilter sensitiveFilter = new SensitiveFilter();
//      add 返回值变成了filterChain的返回
        filterChain.add(htmlFilter).add(sensitiveFilter);

//多加一个Filter 为了的是测试 FilterChain的加载前一个FilterChain上
        FilterChain filterChain2 = new FilterChain();
        filterChain2.add(new FaceFilter());
        filterChain.add(filterChain2);

        filterChain.doFilter(request,reponse,filterChain);

        System.out.println(request);
        System.out.println(reponse);
    }
}
class Msg{
    String name;
    String msg;

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
class Request{
    String request;

    @Override
    public String toString() {
        return "Request{" +
                "request='" + request + '\'' +
                '}';
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public String getRequest() {
        return request;
    }
}
class Reponse{
    String reponse;

    public String getReponse() {
        return reponse;
    }

    public void setReponse(String reponse) {
        this.reponse = reponse;
    }

    @Override
    public String toString() {
        return "Reponse{" +
                "reponse='" + reponse + '\'' +
                '}';
    }
}

interface  Filter{
    Boolean doFilter(Request request,Reponse reponse,FilterChain chain);
}

class HTMLFilter implements  Filter{

    @Override
    public Boolean doFilter(Request request,Reponse reponse,FilterChain chain) {
        String r = request.getRequest();
        r = r.replace("<", "[");
        r = r.replace(">","]");
        request.setRequest(r);
        chain.doFilter(request,reponse, chain);
        String rs = reponse.getReponse();
        rs = rs.replaceAll("返回了","HTMLFilter！");
        reponse.setReponse(rs);
        return true;
    }
}
class SensitiveFilter implements  Filter{

    @Override
    public Boolean doFilter(Request request,Reponse reponse,FilterChain chain) {
        String r = request.getRequest();
        r=r.replaceAll("996","955");
        request.setRequest(r);
        chain.doFilter(request,reponse, chain);
        String rs = reponse.getReponse();
        rs = rs.replaceAll("什么","SensitiveFilter！");
        reponse.setReponse(rs);
        return true;
    }
}
class FaceFilter implements  Filter{

    @Override
    public Boolean doFilter(Request request,Reponse reponse,FilterChain chain) {
        String r = request.getRequest();
        r = r.replace("：)","0.0");
        request.setRequest(r);
        chain.doFilter(request,reponse, chain);
        String rs = reponse.getReponse();
        rs =rs.replaceAll("-","|");
        reponse.setReponse(rs);
        return true;
    }
}
//FilterChain也作为Filter的话 ，就可以被添加到List<Filter>中去读取
class FilterChain implements Filter{
    List<Filter> filters = new ArrayList<>();
    int index=0;
    public  FilterChain add(Filter filter){
        filters.add(filter);
        
        return this;
    }
    public Boolean  doFilter(Request request,Reponse reponse,FilterChain chain){
//        for (Filter filter: filters ) {
//           if (!filter.doFilter(msg))
//               return false;
//        }
//        return true;
    if (index==filters.size()){
        return false;
    }
        Filter f = filters.get(index);
        index++;
        return f.doFilter(request,reponse,chain);
    }
}