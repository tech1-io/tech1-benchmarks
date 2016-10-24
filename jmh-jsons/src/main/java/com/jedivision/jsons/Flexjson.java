package com.jedivision.jsons;

import com.jedivision.utils.FlexjsonGenderFactory;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jedivision.configuration.ApplicationConstants.DATE_FORMAT;

@Service
public class Flexjson implements AbstractJson {
    private static final DateTransformer DF = new DateTransformer(DATE_FORMAT);

    private JSONSerializer serializer = new JSONSerializer();
    private JSONDeserializer deserializer = new JSONDeserializer();

    @PostConstruct
    public void init() {
        serializer.transform(DF, Date.class);
    }

    @Override
    public <T> String toJson(List<T> objects) throws Exception {
        return serializer.serialize(objects);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> List<T> fromJson(String json, Class<T> clazz) throws Exception {
        return (List<T>) deserializer
                .use(null, ArrayList.class)
                .use(Date.class, DF)
                .use("values", clazz)
                .use("values.gender", new FlexjsonGenderFactory())
                .deserialize(json);
    }
}
