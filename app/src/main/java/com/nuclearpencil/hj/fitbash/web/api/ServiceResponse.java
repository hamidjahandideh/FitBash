package com.nuclearpencil.hj.fitbash.web.api;



import java.io.Serializable;

/**
 * Created by hamid on 6/28/17.
 * Email: hamid.jahandidehok@gmail.com
 * Phone: +989364565413
 */

public class ServiceResponse<T> implements Serializable {


    private String code;
    private String msg;
    private ResponseStatus status;
    private T data;



    public ResponseStatus getStatus() {
        return status;
    }

    public ServiceResponse setStatus(ResponseStatus status) {
        this.status = status;
        return this;
    }

    public T getData() {
        return data;
    }

    public ServiceResponse setData(T data) {
        this.data = data;
        return this;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
