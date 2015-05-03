package cn.emac.dnspod.services;

import cn.emac.dnspod.DnsPodParam;
import cn.emac.dnspod.DnsPodUrls;
import cn.emac.dnspod.model.Record;
import cn.emac.dnspod.model.Status;
import cn.emac.dnspod.utils.HttpUtils;
import com.jayway.jsonpath.JsonPath;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import net.minidev.json.JSONValue;
import org.apache.http.client.fluent.Form;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;


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

    /**
     * Lists all records under the given domain and sub-domain.
     *
     * @param domainId
     * @param subDomain
     * @return
     * @throws IOException
     */
    public static List<Record> list(String domainId, String subDomain) throws IOException {
        Form form = HttpUtils.createBaseForm();
        form.add(DnsPodParam.DOMAIN_ID, domainId).add(DnsPodParam.SUB_DOMAIN, subDomain);
        String json = HttpUtils.createPostRequest(DnsPodUrls.RECORD_LIST, form).execute().returnContent().asString();
        JSONArray records = JsonPath.read(json, "$.records");
        if (records == null) {
            return Collections.EMPTY_LIST;
        }

        ArrayList<Record> result = new ArrayList<>();
        for (Object obj : records) {
            Map map = (Map) obj;
            Record record = new Record();
            record.setId(map.get(DnsPodParam.ID).toString());
            record.setDomain_id(domainId);
            record.setSub_domain(subDomain);
            record.setRecord_type(map.get(DnsPodParam.TYPE).toString());
            record.setValue(map.get(DnsPodParam.VALUE).toString());
            result.add(record);
        }
        return result;
    }

    /**
     * Tries to remove an existing record from the given model.
     *
     * @param record
     * @return
     * @throws IOException
     */
    public static Status remove(Record record) throws IOException {
        if (record == null) {
            return null;
        }

        Form form = HttpUtils.createBaseForm();
        form.add(DnsPodParam.DOMAIN_ID, record.getDomain_id()).add(DnsPodParam.RECORD_ID, record.getId());
        String json = HttpUtils.createPostRequest(DnsPodUrls.RECORD_REMOVE, form).execute().returnContent().asString();
        JSONObject obj = JSONValue.parse(json, JSONObject.class);
        return JSONValue.parse(obj.getAsString("status"), Status.class);
    }
}
