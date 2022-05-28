package com.sandip.dynamo_rest.entities.requests;

import lombok.Data;

import java.util.List;

@Data
public class BookLendRequest {
    private List<String> bookIds;
    private String memberId;
}
