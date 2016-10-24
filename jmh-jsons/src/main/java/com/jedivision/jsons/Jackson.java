package com.jedivision.jsons;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

import static com.jedivision.configuration.ApplicationConstants.DATE_FORMAT;

@Service
public class Jackson implements AbstractJson {
    private ObjectMapper mapper = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setDateFormat(new SimpleDateFormat(DATE_FORMAT));

    @Override
    public <T> String toJson(List<T> objects) throws Exception {
        return mapper.writeValueAsString(objects);
    }

    @Override
    public <T> List<T> fromJson(String json, Class<T> clazz) throws Exception {
        CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, clazz);
        return mapper.readValue(json, type);
    }
}
