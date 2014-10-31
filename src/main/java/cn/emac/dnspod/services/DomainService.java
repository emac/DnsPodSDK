package cn.emac.dnspod.services;

import cn.emac.dnspod.utils.HttpUtils;
import com.jayway.jsonpath.JsonPath;
import org.apache.http.client.fluent.Form;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static cn.emac.dnspod.DnsPodParam.KEYWORD;
import static cn.emac.dnspod.DnsPodParam.TYPE;
import static cn.emac.dnspod.DnsPodUrls.DOMAIN_LIST;

/**
 * @author Emac
 */
public class DomainService {

    /**
     * @param domain
     * @return
     */
    public static int getDomainId(String domain) throws URISyntaxException, IOException {
        Form form = HttpUtils.createBaseForm();
        String json = HttpUtils.createPostRequest(DOMAIN_LIST, form.add(TYPE, "mine").add(KEYWORD,
                domain)).execute().returnContent().asString();
        int size = JsonPath.read(json, "$.info.domain_total");
        if (size > 0) {
            return JsonPath.read(json, "$.domains[0].id");
        }
        return -1;
    }

}
