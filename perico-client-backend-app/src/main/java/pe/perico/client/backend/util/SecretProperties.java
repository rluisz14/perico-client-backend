package pe.perico.client.backend.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rluisz14  on 3/12/2020
 */
public class SecretProperties{
    public static final Map<String, String> properties = new HashMap<>();

    private SecretProperties(){ }

    private static void setProperties(){
        properties.put("db-xpay-url", "mdp.xpay.manager.db.url");
        properties.put("db-xpay-username", "mdp.xpay.manager.db.username");
        properties.put("db-xpay-password", "mdp.xpay.manager.db.password");
        properties.put("redis-host", "mdp.xpay.manager.cache.host");
        properties.put("redis-port", "mdp.xpay.manager.cache.port");
        properties.put("redis-auth", "mdp.xpay.manager.cache.password");
        properties.put("rest-username", "mdp.xpay.manager.external.rest.authentication.basicUser");
        properties.put("rest-password", "mdp.xpay.manager.external.rest.authentication.basicPassword");
        properties.put("pubsub-azure-connection", "mdp.xpay.manager.events.connection");
        properties.put("apim-subscription-xpay-external-value", "mdp.xpay.manager.external.rest.authentication.subscriptionAPIExternalValue");
        properties.put("apim-subscription-xpay-internal-value", "mdp.xpay.manager.external.rest.authentication.subscriptionAPIInternalValue");
        properties.put("rest-api-client", "mdp.xpay.manager.external.rest.authentication.subscriptionValue");
        properties.put("aes-key", "mdp.xpay.manager.keyvault.aesKey");
        properties.put("aes-initvector", "mdp.xpay.manager.keyvault.aesInitVector");
    }

    public static Map<String, String> getProperties(){
        setProperties();
        return properties;
    }
}
