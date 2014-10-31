package cn.emac.dnspod.services;

import cn.emac.dnspod.DnsPodConfig;
import cn.emac.dnspod.utils.HttpUtils;
import com.jayway.jsonpath.JsonPath;
import org.apache.http.client.fluent.Form;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import static cn.emac.dnspod.DnsPodParam.DOMAIN_ID;
import static cn.emac.dnspod.DnsPodParam.KEYWORD;
import static cn.emac.dnspod.DnsPodParam.TYPE;
import static cn.emac.dnspod.DnsPodUrls.RECORD_LIST;

/**
 * @author Emac
 */
public class RecordService {

    /**
     * @param subDomain
     * @return
     * @throws URISyntaxException
     * @throws IOException
     */
    public static boolean exists(String subDomain) throws URISyntaxException, IOException {
        Form form = HttpUtils.createBaseForm();
        String json = HttpUtils.createPostRequest(RECORD_LIST, form.add(DOMAIN_ID,
                String.valueOf(DnsPodConfig.getDomain_id())).add(KEYWORD, subDomain)).execute().returnContent()
                .asString();
        int size = JsonPath.read(json, "$.info.record_total");
        return size > 0;
    }
}
