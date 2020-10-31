package com.share.sharelt.exceptions;

import lombok.Data;

@Data
public class ApiException {
    private int status;

    private String message;

    private long timeStamp;


}
