package cn.emac.dnspod;

/**
 * @author Emac
 */
public interface DnsPodUrls {

    String BASE = "https://dnsapi.cn";

    // domain
    String DOMAIN_INFO = "/Domain.Info";

    // record
    String RECORD_LIST = "/Record.List";
    String RECORD_CREATE = "/Record.Create";
    String RECORD_REMARK = "/Record.Remark";
    String RECORD_STATUS = "/Record.Status";

}
