package br.com.portalservicos.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String path;
    private LocalDateTime timestamp;
    private String message;
    private List<AttributeError> attributeErrors;

    public void addError(String name, String message){
        if(attributeErrors == null) {
            attributeErrors = new ArrayList<>();
        }

        Optional<AttributeError> attributeError = attributeErrors.stream().filter(a -> a.getName().equals(name)).findFirst();
        if(attributeError.isPresent()){
            attributeError.get().getErrors().add(message);
        } else {
            attributeErrors.add(new AttributeError(name, message));
        }

    }

    public void addError(String name, List<String> errors) {
        for(String error : errors){
            addError(name, error);
        }
    }
}
