package design23Demo.ChainResponsibility.LxhChainOfResponsibility;

import java.util.List;

public class DeleteChain implements ContentDelete {

    List<ContentDelete> deleteList;

    public DeleteChain add(ContentDelete contentDelete){
        this.deleteList.add(contentDelete);
        return this;
    }

    @Override
    public Boolean contentDelete(Content content) {
        for (ContentDelete  deleteMethod:
             this.deleteList) {
            if (!deleteMethod.contentDelete(content)){
                return false;
            };
        };
        return true;
    }
}
