package patterns.structural_pattern.proxy_cachingproxy;

import patterns.structural_pattern.proxy_cachingproxy.retrievers.CachingProxyRetriever;
import patterns.structural_pattern.proxy_cachingproxy.retrievers.OriginalRetriever;
import patterns.structural_pattern.proxy_cachingproxy.retrievers.Retriever;
import patterns.structural_pattern.proxy_cachingproxy.storage.RemoteStorage;
import patterns.structural_pattern.proxy_cachingproxy.storage.Storage;

/**
 * Caching proxy
 *
 * Реализация паттерна Proxy предоставляет объект, который контролирует доступ к другому объекту.
 *
 * CachingProxyRetriever в пакете retrievers обеспечиваtт ту же функциональность
 * что и класс OriginalRetriever, но с одним важным дополнением.
 * Необходимо всегда пробовать сначала получить объект из кеша,
 * и только если его там нет - выполнять дорогостоящую операцию загрузки из storage.
 * После получения необходимого объекта из хранилища storage он кешируется с помощью объекта типа LRUCache.
 *
 * Для клиента (см. класс Program) использование CachingProxyRetriever
 * ничем не отличается от использования класса OriginalRetriever.
 */
public class Program {
    private static final int n = 10;

    public static void main(String[] args) {
        Storage storage = new RemoteStorage();

        fillStorage(storage);

        System.out.println("Testing OriginalRetriever: ");
        testRetriever(new OriginalRetriever(storage));

        System.out.println("\n\n\n\n\n\n\n\n\n\nTesting CachingProxyRetriever: ");
        testRetriever(new CachingProxyRetriever(storage));
    }

    private static void fillStorage(Storage storage) {
        for (int i = 0; i < n; i++) {
            storage.add("Resource #" + i);
        }
    }

    private static void testRetriever(Retriever retriever) {
        for (int i = 0; i < n * 4; i++) {
            System.out.println("Loaded value : " + retriever.retrieve((long) (Math.random() * n)));
        }
    }
}
