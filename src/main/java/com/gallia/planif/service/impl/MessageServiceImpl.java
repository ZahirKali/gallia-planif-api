package com.gallia.planif.service.impl;

import com.gallia.planif.service.MessageService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class MessageServiceImpl implements MessageService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MessageServiceImpl.class);
    private static final String ERROR = "error";

    private final MessageSource messageSource;

    public MessageServiceImpl(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Override
    public String getErrorMessage(String key, Object[] args, Locale locale) {
        return getMessageByKey(ERROR, key, args, locale);
    }

    private String getMessageByKey(String prefix, String key, Object[] args, Locale locale) {
        final String fullMessageKey = Stream.of(prefix, key)
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.joining("."));
        try {
            return messageSource.getMessage(
                    fullMessageKey,
                    args,
                    locale);
        } catch (Exception e) {
            LOGGER.warn("Missing field {} for locale {} ", fullMessageKey, locale);
            return fullMessageKey;
        }
    }
}
