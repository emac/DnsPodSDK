package cn.emac.dnspod.services;

import cn.emac.dnspod.DnsPodConfig;
import cn.emac.dnspod.DnsPodParam;
import junit.framework.Assert;
import org.junit.Test;

import java.util.Properties;

public class RecordServiceTest {

    @Test
    public void testExists() throws Exception {
        Properties props = new Properties();
        props.setProperty(DnsPodParam.LOGIN_EMAIL, "shen.b@vcooline.com");
        props.setProperty(DnsPodParam.LOGIN_PASSWORD, "vcl123vcl");
        DnsPodConfig.init(props);
        DnsPodConfig.setDomain_id(19501764);

        Assert.assertTrue(RecordService.exists("www"));
        Assert.assertFalse(RecordService.exists("mmm"));
    }
}