package com.gallia.planif.service;

import java.util.Locale;

public interface MessageService {

    String getErrorMessage(String key, Object[] args, Locale locale);

}
