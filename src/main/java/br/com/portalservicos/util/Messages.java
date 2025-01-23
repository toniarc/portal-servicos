package br.com.portalservicos.util;

public enum Messages {
    USER_HAVE_NO_GROUP_ERROR("O usuário não está em um grupo");

    private String message;

    Messages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message.toString();
    }
}
