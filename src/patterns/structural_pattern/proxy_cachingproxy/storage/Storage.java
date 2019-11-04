package patterns.structural_pattern.proxy_cachingproxy.storage;

public interface Storage {
    void add(Object storedObject);
    Object get(long id);
}
