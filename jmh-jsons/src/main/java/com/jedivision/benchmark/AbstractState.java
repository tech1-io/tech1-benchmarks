package com.jedivision.benchmark;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.jedivision.configuration.Application;
import com.jedivision.jsons.*;
import org.apache.commons.io.IOUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.jedivision.configuration.ApplicationConstants.DATE_FORMAT;
import static com.jedivision.jsons.JsonProviderType.*;

public class AbstractState {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
            .setDateFormat(new SimpleDateFormat(DATE_FORMAT));

    private final ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
    private final Gson gson = context.getBean(Gson.class);
    private final Jackson jackson = context.getBean(Jackson.class);
    private final Flexjson flexjson = context.getBean(Flexjson.class);
    private final Genson genson = context.getBean(Genson.class);

    private String json;
    private Class<?> userClass;
    private List<Serializable> users = Collections.emptyList();
    private Map<JsonProviderType, AbstractJson> jsonProviders = new HashMap<>();

    protected void initJson(String jsonPath) throws IOException {
        try (InputStream is = AbstractState.class.getResourceAsStream(jsonPath)) {
            json = IOUtils.toString(is, StandardCharsets.UTF_8.toString());
        }
    }

    protected void initUserType(Class<?> userClass) {
        this.userClass = userClass;
    }

    protected void initJsonProviders() {
        jsonProviders.put(GSON, gson);
        jsonProviders.put(JACKSON, jackson);
        jsonProviders.put(FLEXJSON, flexjson);
        jsonProviders.put(GENSON, genson);
    }

    protected void initUsers() throws IOException {
        CollectionType type = MAPPER.getTypeFactory().constructCollectionType(List.class, userClass);
        users = MAPPER.readValue(json, type);
    }

    public void toJson(JsonProviderType jsonProviderType) throws Exception {
        jsonProviders.get(jsonProviderType).toJson(users);
    }

    public void fromJson(JsonProviderType jsonProviderType) throws Exception {
        List<?> objects = jsonProviders.get(jsonProviderType).fromJson(json, userClass);
        if (!users.equals(objects)) {
            throw new RuntimeException("Serialization failed: users are not equals after deserialization process.");
        }
    }
}
