package br.com.portalservicos.config;

import br.com.portalservicos.exception.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@RestControllerAdvice
@RequiredArgsConstructor
public class ExceptionHandlerConfig {

    private final MessageSource messageSource;

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ExceptionResponse handleValidationExceptions(MethodArgumentNotValidException ex, HttpServletRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .message(messageSource.getMessage("validation.MethodArgumentNotValidException", null, Locale.getDefault()))
                .build();

        List<AttributeError> errors = new ArrayList<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            exceptionResponse.addError(((FieldError) error).getField(), error.getDefaultMessage());
        });

        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BusinessException.class)
    public ExceptionResponse handleValidationExceptions(BusinessException ex, HttpServletRequest request) {

        ExceptionResponse exceptionResponse = ExceptionResponse.builder()
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build();

        if(ex.getAttributeErrors() != null && !ex.getAttributeErrors().isEmpty()) {
            List<AttributeError> errors = new ArrayList<>();
            ex.getAttributeErrors().forEach((error) -> {
                exceptionResponse.addError(error.getName(), error.getErrors());
            });
        }

        return exceptionResponse;
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ExceptionResponse handleValidationExceptions(MaxUploadSizeExceededException ex, HttpServletRequest request) {

        return ExceptionResponse.builder()
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .message(messageSource.getMessage("validation.MaxUploadSizeExceededException", null, Locale.getDefault()))
                .build();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ExceptionResponse handleValidationExceptions(MissingServletRequestParameterException ex, HttpServletRequest request) {

        return ExceptionResponse.builder()
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public ExceptionResponse handleValidationExceptions(NotFoundException ex, HttpServletRequest request) {

        return ExceptionResponse.builder()
                .path(request.getServletPath())
                .timestamp(LocalDateTime.now())
                .message(ex.getMessage())
                .build();
    }
}
