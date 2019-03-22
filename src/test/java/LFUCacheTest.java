import Utilities.LFUCache;
import org.junit.Assert;
import org.junit.Test;

public class LFUCacheTest {

    @Test
    public void CacheNullaryConstructorTest(){
        LFUCache cache = new LFUCache();
        Integer maxSize = 100;
        Integer startSize = 0;
        Assert.assertEquals(maxSize, cache.getMaxSize());
        Assert.assertEquals(startSize, cache.getSize());
    }

    @Test
    public void CacheConstructorTest(){
        LFUCache cache = new LFUCache(10);
        Integer maxSize = 10;
        Integer startSize = 0;
        Assert.assertEquals(maxSize, cache.getMaxSize());
        Assert.assertEquals(startSize, cache.getSize());
    }

    @Test
    public void addTest1(){
        LFUCache cache = new LFUCache();
        for (Integer i = 0; i < 10; i++) {
            cache.add(i);
        }
        Integer size = 10;
        Assert.assertEquals(size, cache.getSize());
        Assert.assertTrue(cache.contains(0));
    }
}
