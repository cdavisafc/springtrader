package org.cloudfoundry.samples.springtrader.cloud;

import org.springframework.cloud.cloudfoundry.CloudFoundryServiceInfoCreator;
import org.springframework.cloud.service.common.RabbitServiceInfo;

import java.util.Map;

public class UserProvidedRabbitMQServiceInfoCreator extends CloudFoundryServiceInfoCreator<RabbitServiceInfo> {
    public UserProvidedRabbitMQServiceInfoCreator() {
        super("user-provided");
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean accept(Map<String, Object> serviceData) {
        String label = (String) serviceData.get("label");

        if (label.equals(getTag())) {
            Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");
            String uri = (String) credentials.get("uri");

            if (uri != null && uri.startsWith("amqp:")) {
                return true;
            }
        }

        return false;
    }

    @Override
    @SuppressWarnings("unchecked")
    public RabbitServiceInfo createServiceInfo(Map<String, Object> serviceData) {
//        String id = (String) serviceData.get("name");
        String id = "connectionFactory";
        Map<String, Object> credentials = (Map<String, Object>) serviceData.get("credentials");
        String uri = credentials.get("uri").toString();
        return new RabbitServiceInfo(id, uri);
    }
}