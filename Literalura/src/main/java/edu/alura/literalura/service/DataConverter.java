package edu.alura.literalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataConverter implements IDataConverter {
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public <T> T getData(String json, Class<T> objClass) {
        try{
            return objectMapper.readValue(json,objClass);
        }catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
    }
}
