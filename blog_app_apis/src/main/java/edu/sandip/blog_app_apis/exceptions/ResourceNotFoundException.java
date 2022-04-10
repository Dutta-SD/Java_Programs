package edu.sandip.blog_app_apis.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
    String resourceName;
    String resourceId;
    Integer fieldValue;

    public ResourceNotFoundException(String resourceName, String resourceId, Integer fieldValue) {
        super(String.format("%s not found with %s : %d", resourceName, resourceId, fieldValue));
        this.resourceName = resourceName;
        this.resourceId = resourceId;
        this.fieldValue = fieldValue;
    }


}
