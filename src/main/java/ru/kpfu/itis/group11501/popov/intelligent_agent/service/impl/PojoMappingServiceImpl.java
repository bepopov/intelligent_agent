package ru.kpfu.itis.group11501.popov.intelligent_agent.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.group11501.popov.intelligent_agent.service.PojoMappingService;

import java.io.IOException;

@Service
public class PojoMappingServiceImpl implements PojoMappingService {

    private ObjectMapper mapper;

    public PojoMappingServiceImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public <T> T map(String content, Class<T> valueType) {
        try {
            return mapper.readValue(content, valueType);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
