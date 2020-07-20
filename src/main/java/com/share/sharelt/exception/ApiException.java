package com.share.sharelt.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Data
public class ApiException {
    private int status;

    private String message;

    private long timeStamp;


}
