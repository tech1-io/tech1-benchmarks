package com.jedivision.temple.benchmark;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import com.jedivision.temple.configuration.Application;
import com.jedivision.temple.serialization.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.jedivision.temple.serialization.SerializationType.*;

public class AbstractState {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss X"));

    private final ApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
    private final JdkSerializer jdkSerializer = context.getBean(JdkSerializer.class);
    private final FastjsonSerializer fastjsonSerializer = context.getBean(FastjsonSerializer.class);
    private final JacksonJsonSerializer jacksonJsonSerializer = context.getBean(JacksonJsonSerializer.class);
    private final JacksonSmileSerializer jacksonSmileSerializer = context.getBean(JacksonSmileSerializer.class);
    private final FstSerializer fstSerializer = context.getBean(FstSerializer.class);
    private final FstUnsafeSerializer fstUnsafeSerializer = context.getBean(FstUnsafeSerializer.class);
    private final KryoSerializer kryoSerializer = context.getBean(KryoSerializer.class);
    private final KryoUnsafeSerializer kryoUnsafeSerializer = context.getBean(KryoUnsafeSerializer.class);
    private final MessagePackSerializer messagePackSerializer = context.getBean(MessagePackSerializer.class);

    private Map<SerializationType, AbstractSerializer> serializers = new HashMap<>();
    private Class<?> userClass;
    private List<Serializable> users = Collections.emptyList();
    private Map<SerializationType, List<byte[]>> usersBytesBySerializationType = new HashMap<>();

    protected void initSerializers() {
        serializers.put(JDK, jdkSerializer);
        serializers.put(FASTJSON, fastjsonSerializer);
        serializers.put(JACKSON_JSON, jacksonJsonSerializer);
        serializers.put(JACKSON_SMILE, jacksonSmileSerializer);
        serializers.put(FST, fstSerializer);
        serializers.put(FST_UNSAFE, fstUnsafeSerializer);
        serializers.put(KRYO, kryoSerializer);
        serializers.put(KRYO_UNSAFE, kryoUnsafeSerializer);
        serializers.put(MESSAGE_PACK, messagePackSerializer);
    }

    protected void initUsers(String jsonPath, Class<?> userClass) throws IOException {
        this.userClass = userClass;
        try (InputStream is = AbstractState.class.getResourceAsStream(jsonPath)) {
            CollectionType type = MAPPER.getTypeFactory().constructCollectionType(List.class, userClass);
            users = MAPPER.readValue(is, type);
        }
    }

    protected void initSerializedBytesByType() {
        Stream.of(SerializationType.values()).forEach(type -> {
            usersBytesBySerializationType.put(type, users.stream().map(user -> {
                try {
                    return serializers.get(type).serialize(user);
                } catch (Exception e) {
                    return null;
                }
            }).collect(Collectors.toList()));
        });
    }

    public long serialize(SerializationType serializationType) throws Exception {
        long serializationBytes = 0;
        for (Serializable user: users) {
            byte[] bytes = serializers.get(serializationType).serialize(user);
            serializationBytes += bytes.length;
        }
        return serializationBytes;
    }

    public void deserialize(SerializationType serializationType) throws Exception {
        List<byte[]> usersBytes = usersBytesBySerializationType.get(serializationType);
        for (int i = 0; i < usersBytes.size(); i++) {
            Object deserializeUser = serializers.get(serializationType).deserialize(usersBytes.get(i), userClass);
            Serializable user = users.get(i);
            if (!user.equals(deserializeUser)) {
                throw new RuntimeException("Serialization failed: users are not equals after deserialization process.");
            }
        }
    }
}
