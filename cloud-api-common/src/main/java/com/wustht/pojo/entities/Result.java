package com.wustht.pojo.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ht
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Result<T> {
    private Integer code;
    private String message;
    private T data;

    public Result(Integer code,String message){
        this.code = code;
        this.message = message;
    }
}
