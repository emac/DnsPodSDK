package cn.emac.dnspod;

import java.util.Properties;

import static cn.emac.dnspod.DnsPodParam.*;

/**
 * @author Emac
 */
public class DnsPodConfig {

    private static boolean initialized;
    private static String login_email;
    private static String login_password;
    private static String format;
    private static String lang;
    private static String error_on_empty;
    private static int domain_id;

    /**
     * @param props
     */
    public static synchronized void init(Properties props) {
        if (initialized) {
            throw new RuntimeException("Config is already initialized!");
        }

        if (props == null || props.getProperty(LOGIN_EMAIL) == null || props.getProperty(LOGIN_PASSWORD) == null) {
            throw new IllegalArgumentException("Invalid initialization properties!");
        }

        login_email = props.getProperty(LOGIN_EMAIL);
        login_password = props.getProperty(LOGIN_PASSWORD);
        format = props.getProperty(FORMAT) != null ? props.getProperty(FORMAT) : "json";
        lang = props.getProperty(LANG) != null ? props.getProperty(LANG) : "cn";
        error_on_empty = props.getProperty(ERROR_ON_EMPTY) != null ? props.getProperty(ERROR_ON_EMPTY) : "no";

        initialized = true;
    }

    public static String getLogin_email() {
        return login_email;
    }

    public static String getLogin_password() {
        return login_password;
    }

    public static String getFormat() {
        return format;
    }

    public static String getLang() {
        return lang;
    }

    public static String getError_on_empty() {
        return error_on_empty;
    }

    public static int getDomain_id() {
        return domain_id;
    }

    public static void setDomain_id(int domain_id) {
        DnsPodConfig.domain_id = domain_id;
    }

}
