package cn.emac.dnspod.services;

import junit.framework.Assert;
import org.junit.Test;

public class DomainServiceTest extends BaseTest {

    @Test
    public void testGetDomainId() throws Exception {
        Assert.assertEquals("19501764", DomainService.getDomainId("zixiker.com"));
    }
}