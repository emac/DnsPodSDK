package cn.emac.dnspod.utils;

import cn.emac.dnspod.DnsPodConfig;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;

import java.nio.charset.Charset;

import static cn.emac.dnspod.DnsPodParam.*;
import static cn.emac.dnspod.DnsPodUrls.BASE;

/**
 * @author Emac
 */
public class HttpUtils {

    /**
     * @return
     */
    public static Form createBaseForm() {
        return Form.form().add(LOGIN_EMAIL, DnsPodConfig.getLogin_email()).add(LOGIN_PASSWORD,
                DnsPodConfig.getLogin_password()).add(FORMAT, DnsPodConfig.getFormat()).add(LANG,
                DnsPodConfig.getLang()).add(ERROR_ON_EMPTY, DnsPodConfig.getError_on_empty());
    }

    /**
     * @param url
     * @param form
     * @return
     */
    public static Request createPostRequest(String url, Form form) {
        return Request.Post(BASE + url).bodyForm(form.build(), Charset.forName("UTF-8"));
    }

}
