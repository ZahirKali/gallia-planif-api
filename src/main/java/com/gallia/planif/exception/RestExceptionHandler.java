package com.gallia.planif.exception;

import com.gallia.planif.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);
    private final MessageService messageService;

    private static final Map<String, String> CONSTRAINS_I18N_MAP =
            Map.of("pro_card_number", "PRO_CARD_NUMBER_ALREADY_EXISTS");

    public RestExceptionHandler(MessageService messageService) {
        this.messageService = messageService;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public void handleDataIntegrityViolationException(DataIntegrityViolationException e,
                                                      HttpServletResponse response,
                                                      Locale locale) throws IOException {

        if (e != null && e.getRootCause() != null && e.getRootCause().getMessage() != null) {
            for (Map.Entry<String, String> entry : CONSTRAINS_I18N_MAP.entrySet()) {
                if (e.getRootCause().getMessage().toLowerCase().contains(entry.getKey())) {
                    String error = messageService.getErrorMessage(entry.getValue(),
                            new String[]{}, locale);
                    LOGGER.error(error, e);
                    response.sendError(HttpStatus.CONFLICT.value(), error);
                }
            }
        }
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public void handleEntityNotFoundException(EntityNotFoundException e,
                                                      HttpServletResponse response,
                                                      Locale locale) throws IOException {

        String error = messageService.getErrorMessage("ENTITY_NOT_FOUND_EXCEPTION",
                new String[]{e.getEntityName(), e.getId().toString()}, locale);
        LOGGER.error(error, e);
        response.sendError(HttpStatus.NOT_FOUND.value(), error);
    }

}
