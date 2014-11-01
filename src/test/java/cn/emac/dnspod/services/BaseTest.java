package cn.emac.dnspod.services;

import cn.emac.dnspod.DnsPodConfig;
import cn.emac.dnspod.DnsPodParam;
import org.junit.BeforeClass;

import java.util.Properties;

/**
 * @author Emac
 */
public class BaseTest {

    @BeforeClass
    public static void beforeClass() {
        Properties props = new Properties();
        props.setProperty(DnsPodParam.LOGIN_EMAIL, "shen.b@vcooline.com");
        props.setProperty(DnsPodParam.LOGIN_PASSWORD, "vcl123vcl");
        DnsPodConfig.init(props);

        DnsPodConfig.setDomain_id("19501764");
    }
}
