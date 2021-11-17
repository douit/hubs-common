package com.bluecc.domain.enhancer;

public interface IStatusSetter {
    void setStatusId(String statusId);
    String getStatusId();

    default String getStatusDesc(){
        return getStatusId()+": desc.";
    }
}
