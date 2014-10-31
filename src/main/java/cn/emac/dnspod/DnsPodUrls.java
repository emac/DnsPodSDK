package cn.emac.dnspod;

/**
 * @author Emac
 */
public interface DnsPodUrls {

    String BASE_URL = "https://dnsapi.cn";

    // domain
    String DOMAIN_LIST = "/Domain.List";

    // record
    String RECORD_LIST = "/Record.List";
    String RECORD_CREATE = "/Record.Create";
    String RECORD_REMARK = "/Record.Remark";
    String RECORD_STATUS = "/Record.Status";

}
