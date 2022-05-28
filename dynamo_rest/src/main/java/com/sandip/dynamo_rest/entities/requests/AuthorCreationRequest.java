package com.sandip.dynamo_rest.entities.requests;

import lombok.Data;

@Data
public class AuthorCreationRequest {
    private String firstName;
    private String lastName;
}
