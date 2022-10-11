package com.miw.upm.injection.e1e2e4;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * Almacena mensajes en un Mapa
 * La convertimos en un Bean manejado por Spring, con la siguiente anotación:
 */
@Service
public class MessageService {
    private Map<String, String> messageMap;

    public MessageService() {
        messageMap = new HashMap<>();
    }

    public void add(String key, String message) {
        messageMap.put(key, message);
    }

    public String message(String key) {
        return messageMap.get(key);
    }

    public String key(String message) {
        for (String key : messageMap.keySet()) {
            if (messageMap.get(key).equals(message)) {
                return key;
            }
        }
        return null;
    }
}
