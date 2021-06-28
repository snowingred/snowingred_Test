package design23Demo.ChainResponsibility.LxhChainOfResponsibility;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LxhMain {
    public static void main(String[] args) {
        List<Integer> integers = new LinkedList<>();
        integers.add(1);
        integers.add(2);
        Content content = new Content("00",integers);
        DeleteChain deleteChain = new DeleteChain();
        deleteChain.add(new CommonCommentDelete()).add(new ContentTableDelete()).add(new LikeCollectionCommentRedisDelete());
        deleteChain.contentDelete(content);
    }


}

