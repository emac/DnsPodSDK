package cn.emac.dnspod.model;

/**
 * @author Emac
 */
public class Record {

    private String id; // alias: record_id
    private String domain_id;
    private String sub_domain; // alias: name
    private String record_type; // alias: type
    private String record_line;
    private String value;
    private String mx;
    private String ttl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDomain_id() {
        return domain_id;
    }

    public void setDomain_id(String domain_id) {
        this.domain_id = domain_id;
    }

    public String getSub_domain() {
        return sub_domain;
    }

    public void setSub_domain(String sub_domain) {
        this.sub_domain = sub_domain;
    }

    public String getRecord_type() {
        return record_type;
    }

    public void setRecord_type(String record_type) {
        this.record_type = record_type;
    }

    public String getRecord_line() {
        return record_line;
    }

    public void setRecord_line(String record_line) {
        this.record_line = record_line;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getMx() {
        return mx;
    }

    public void setMx(String mx) {
        this.mx = mx;
    }

    public String getTtl() {
        return ttl;
    }

    public void setTtl(String ttl) {
        this.ttl = ttl;
    }
}
