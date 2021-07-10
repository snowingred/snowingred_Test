package TestMemcache;

import org.junit.Assert;
import org.junit.Test;

/**
 * 跑不起来
 */
public class MemcachedUtilTest {
    @Test
    public void testMemcached() {
        MemcachedUtil.put("hello", "world", 60);
        String hello = (String) MemcachedUtil.get("hello");
        Assert.assertEquals("world", hello);

        for(int i = 0; i < 10000; ++i) {
            User user = new User("Jason" + i, "123456-" + i);
            MemcachedUtil.put("user" + i, user, 60);
            Object obj = MemcachedUtil.get("user" + i);
            Assert.assertEquals(user, obj);
        }
    }
}