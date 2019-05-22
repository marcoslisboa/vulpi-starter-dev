package com.vulpi.starterdev.vo;

import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class MessageVO {

    @Builder.Default
    private String id = UUID.randomUUID().toString();

    private String message;

    @Builder.Default
    private Date time = new Date();

}
