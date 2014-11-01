package cn.emac.dnspod.services;

import cn.emac.dnspod.DnsPodConfig;
import cn.emac.dnspod.DnsPodParam;
import cn.emac.dnspod.DnsPodUrls;
import cn.emac.dnspod.model.Record;
import cn.emac.dnspod.model.Status;
import cn.emac.dnspod.utils.HttpUtils;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.apache.http.client.fluent.Form;

import java.io.IOException;
import java.util.HashMap;


/**
 * @author Emac
 */
public class RecordService {

    /**
     * Returns {@code true} iff the given sub-domain exists.
     *
     * @param domainId
     * @param subDomain
     * @return
     * @throws IOException
     */
    public static boolean exists(String domainId, String subDomain) throws IOException {
        Form form = HttpUtils.createBaseForm();
        form.add(DnsPodParam.DOMAIN_ID, domainId).add(DnsPodParam.SUB_DOMAIN, subDomain);
        String json = HttpUtils.createPostRequest(DnsPodUrls.RECORD_LIST, form).execute().returnContent().asString();
        int size = Integer.parseInt(JsonPath.read(json, "$.info.record_total").toString());
        return size > 0;
    }

    /**
     * Tries to create a new record from the given model.
     *
     * @param record
     * @return
     * @throws IOException
     */
    public static Status create(Record record) throws IOException {
        if (record == null) {
            return null;
        }

        Form form = HttpUtils.createBaseForm();
        form.add(DnsPodParam.DOMAIN_ID, record.getDomain_id()).add(DnsPodParam.SUB_DOMAIN,
                record.getSub_domain()).add(DnsPodParam.RECORD_TYPE, record.getRecord_type()).add(DnsPodParam
                .RECORD_LINE, record.getRecord_line()).add(DnsPodParam.VALUE, record.getValue()).add(DnsPodParam.MX,
                record.getMx()).add(DnsPodParam.TTL, record.getTtl());
        String json = HttpUtils.createPostRequest(DnsPodUrls.RECORD_CREATE, form).execute().returnContent().asString();
        JSONObject obj = JSONValue.parse(json, JSONObject.class);
        return JSONValue.parse(obj.getAsString("status"), Status.class);
    }
}
