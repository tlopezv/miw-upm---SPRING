package com.miw.upm.injection.e1e2e4;

/**
 * Creamos un Mock, que simulará el comportamiento de la clase "MessageService".
 * Heredo de la clase "MessageService" para que mi Mock sea compatible en el
 * funcionamiento.
 * Y sobreescribo los métodos necesarios para simplificarlos.
 */
public class MessageServiceMock extends MessageService {

    private String key;

    private String message;

    @Override
    public void add(String key, String message) {
        this.key = key;
        this.message = message;
    }

    @Override
    public String message(String key) {
        return message;
    }

    @Override
    public String key(String message) {
        return key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
