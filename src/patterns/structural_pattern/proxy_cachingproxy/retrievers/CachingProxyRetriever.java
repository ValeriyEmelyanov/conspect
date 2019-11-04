package patterns.structural_pattern.proxy_cachingproxy.retrievers;

import patterns.structural_pattern.proxy_cachingproxy.cache.LRUCache;
import patterns.structural_pattern.proxy_cachingproxy.storage.Storage;

public class CachingProxyRetriever implements Retriever {
    private static final int CASHE_CAPACITY = 16;
    private OriginalRetriever retriever;
    private LRUCache<Long, Object> cache = new LRUCache<>(CASHE_CAPACITY);

    public CachingProxyRetriever(Storage storage) {
        retriever = new OriginalRetriever(storage);
    }

    @Override
    public Object retrieve(long id) {
        Object returnValue = cache.find(id);
        if (returnValue == null) {
            returnValue = retriever.retrieve(id);
            cache.set(id, returnValue);
        }
        return returnValue;
    }
}
