package cn.emac.dnspod;

/**
 * @author Emac
 */
public interface DnsPodParam {

    // config
    String LOGIN_EMAIL = "login_email";
    String LOGIN_PASSWORD = "login_password";
    String FORMAT = "format";
    String LANG = "lang";
    String ERROR_ON_EMPTY = "error_on_empty";

    // common
    String OFFSET = "offset";
    String LENGTH = "length";
    String KEYWORD = "keyword";
    String REMARK = "remark";
    String STATUS = "status";

    // domain
    String TYPE = "type";

    // record
    String DOMAIN_ID = "domain_id";
    String SUB_DOMAIN = "sub_domain";
    String RECORD_TYPE = "record_type";
    String RECORD_LINE = "record_line";
    String VALUE = "value";
    String MX = "mx";
    String TTL = "ttl";
    String RECORD_ID = "record_id";

}
