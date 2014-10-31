package cn.emac.dnspod.services;

import cn.emac.dnspod.DnsPodConfig;
import cn.emac.dnspod.DnsPodParam;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Properties;

public class DomainServiceTest {

    @Test
    public void testGetDomainId() throws Exception {
        Properties props = new Properties();
        props.setProperty(DnsPodParam.LOGIN_EMAIL, "shen.b@vcooline.com");
        props.setProperty(DnsPodParam.LOGIN_PASSWORD, "vcl123vcl");
        DnsPodConfig.init(props);

        Assert.assertEquals(19501764, DomainService.getDomainId("zixiker.com"));
    }
}