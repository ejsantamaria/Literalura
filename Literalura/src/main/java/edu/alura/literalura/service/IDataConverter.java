package edu.alura.literalura.service;

public interface IDataConverter {
    <T> T getData(String json, Class<T> objClass);
}
