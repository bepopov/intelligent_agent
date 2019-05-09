package ru.kpfu.itis.group11501.popov.intelligent_agent.service;

public interface PojoMappingService {
    <T> T map(String content, Class<T> valueType);
}
