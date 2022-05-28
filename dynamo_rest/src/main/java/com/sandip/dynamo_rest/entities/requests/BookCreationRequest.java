package com.sandip.dynamo_rest.entities.requests;

import lombok.Data;

@Data
public class BookCreationRequest {
    //    name, isbn, authorId;
    private String name;
    private String isbn;
    private String authorId;
}
