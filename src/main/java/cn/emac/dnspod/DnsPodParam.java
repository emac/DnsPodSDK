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
    String ID = "id";
    String TYPE = "type";
    String VALUE = "value";

    // domain
    String DOMAIN = "domain";

    // record
    String RECORD_ID = "record_id";
    String DOMAIN_ID = "domain_id";
    String SUB_DOMAIN = "sub_domain";
    String RECORD_TYPE = "record_type";
    String RECORD_LINE = "record_line";
    String MX = "mx";
    String TTL = "ttl";
}
