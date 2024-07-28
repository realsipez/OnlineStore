package ir.anisa.client.common;

public interface Constants {
    String API_PROTOCOL = "http";
    String COLON_SLASH = "://";
    String API_PREFIX = "/api/v1";
    String DISCOUNT_GET_API_URL = API_PREFIX + "/discount/get/{code}";
    String NOTIFICATION_SEND_API_URL = API_PREFIX + "/notification/send";
}
