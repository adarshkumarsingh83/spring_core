package com.espark.adarsh.event;

import org.springframework.context.ApplicationEvent;

/**
 * Created by akumar6 on 9/23/16.
 */
public class MethodCallEvent<T> extends ApplicationEvent {

    public T data;

    public MethodCallEvent(Object source, T data) {
        super(source);
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
