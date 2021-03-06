package com.maximo.esm.apimcr.api.dto.model.response;


import java.util.ArrayList;
import java.util.List;

public class Response<T> {

    private T data;
    private List<String> erros;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<String> getErros() {
        if(this.erros == null){
            this.erros = new ArrayList<>();
        }
        return erros;
    }

    public void setErros(List<String> erros) {
        this.erros = erros;
    }

    public Response() {
    }
}
