package com.yaoyuan.jiscuss.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
 
@AllArgsConstructor
@Getter
public class Error {
    private int code;
    private String message;
}
