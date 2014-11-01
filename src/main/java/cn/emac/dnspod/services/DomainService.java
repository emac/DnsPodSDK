package cn.emac.dnspod.services;

import cn.emac.dnspod.utils.HttpUtils;
import com.jayway.jsonpath.JsonPath;
import org.apache.http.client.fluent.Form;

import java.io.IOException;
import java.net.URISyntaxException;

import static cn.emac.dnspod.DnsPodParam.DOMAIN;
import static cn.emac.dnspod.DnsPodUrls.DOMAIN_INFO;

/**
 * @author Emac
 */
public class DomainService {

    /**
     * Returns ID of the given domain.
     *
     * @param domain
     * @return
     */
    public static String getDomainId(String domain) throws URISyntaxException, IOException {
        Form form = HttpUtils.createBaseForm();
        String json = HttpUtils.createPostRequest(DOMAIN_INFO, form.add(DOMAIN, domain)).execute().returnContent()
                .asString();
        return JsonPath.read(json, "$.domain.id");
    }

}
