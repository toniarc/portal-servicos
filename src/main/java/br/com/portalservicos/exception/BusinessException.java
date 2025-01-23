package br.com.portalservicos.exception;

import java.util.List;

public class BusinessException extends RuntimeException {

    private List<AttributeError> attributeErrors;

    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, List<AttributeError> attributeErrors) {
        super(message);
        this.attributeErrors = attributeErrors;
    }

    public List<AttributeError> getAttributeErrors() {
        return attributeErrors;
    }
}
