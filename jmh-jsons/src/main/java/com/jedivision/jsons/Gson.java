package com.jedivision.jsons;

import com.google.gson.GsonBuilder;
import com.jedivision.utils.ListOfSomething;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.jedivision.configuration.ApplicationConstants.DATE_FORMAT;

@Service
public class Gson implements AbstractJson {
    private com.google.gson.Gson gson = new GsonBuilder()
            .setDateFormat(DATE_FORMAT)
            .create();

    @Override
    public <T> String toJson(List<T> objects) throws Exception {
        return gson.toJson(objects);
    }

    @Override
    public <T> List<T> fromJson(String json, Class<T> clazz) throws Exception {
        return gson.fromJson(json, new ListOfSomething<>(clazz));
    }
}
