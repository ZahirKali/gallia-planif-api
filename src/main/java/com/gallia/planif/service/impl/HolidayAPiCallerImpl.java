package com.gallia.planif.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gallia.planif.service.HolidayAPiCaller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Date;
import java.util.Map;

@Service
public class HolidayAPiCallerImpl implements HolidayAPiCaller {

    @Value("${holiday.api.url}")
    private String apiUrl;


    @Override
    public Map<Date, String> getHoliday(int year) {
        RestTemplate template = new RestTemplate();
        String fullUrl = apiUrl + year + ".json";
        String response = template.getForObject(fullUrl, String.class);

        TypeReference<Map<Date, String>> typeReference = new TypeReference<>() {};
        try {
            return new ObjectMapper().readValue(response, typeReference);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Exception when call holiday api", e);
        }
    }
}
