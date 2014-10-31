package cn.emac.dnspod.utils;

import cn.emac.dnspod.DnsPodConfig;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;

import static cn.emac.dnspod.DnsPodUrls.*;
import static cn.emac.dnspod.DnsPodParam.*;

/**
 * @author Emac
 */
public class HttpUtils {

    private static final CloseableHttpClient client = HttpClients.createDefault();

    public static Form createBaseForm() {
        return Form.form().add(LOGIN_EMAIL, DnsPodConfig.getLogin_email()).add(LOGIN_PASSWORD,
                DnsPodConfig.getLogin_password()).add(FORMAT, DnsPodConfig.getFormat()).add(LANG,
                DnsPodConfig.getLang()).add(ERROR_ON_EMPTY, DnsPodConfig.getError_on_empty());
    }

    public static Request createPostRequest(String url, Form form) {
        return Request.Post(BASE_URL + url).bodyForm(form.build());
    }

}
