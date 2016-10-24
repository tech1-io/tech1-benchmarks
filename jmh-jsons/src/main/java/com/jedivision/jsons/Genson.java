package com.jedivision.jsons;

import com.google.common.reflect.TypeToken;
import com.owlike.genson.GensonBuilder;
import com.owlike.genson.convert.DefaultConverters;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.List;

import static com.jedivision.configuration.ApplicationConstants.DATE_FORMAT;

@Service
public class Genson implements AbstractJson {
    private com.owlike.genson.Genson genson = new GensonBuilder()
            .useClassMetadata(true)
            .useRuntimeType(true)
            .withConverterFactory(new DefaultConverters.EnumConverterFactory(false))
            .useDateFormat(new SimpleDateFormat(DATE_FORMAT))
            .create();

    @Override
    public <T> String toJson(List<T> objects) throws Exception {
        return genson.serialize(objects);
    }

    @Override
    public <T> List<T> fromJson(String json, Class<T> clazz) throws Exception {
        return (List<T>) genson.deserialize(json, new TypeToken<List<T>>() {}.getRawType());
    }
}