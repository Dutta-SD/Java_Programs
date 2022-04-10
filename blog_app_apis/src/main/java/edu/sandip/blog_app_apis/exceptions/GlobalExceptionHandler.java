package edu.sandip.blog_app_apis.exceptions;

import edu.sandip.blog_app_apis.payloads.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/*
 *
 * Global Exception Handling
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /* Exception Handler -- Method to handle exceptions */
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ApiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException exception) {
        String message = exception.getMessage();
        System.out.println(message);
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setMessage("Id not Found. Please Enter Valid ID");
        return new ResponseEntity<>(apiResponse, HttpStatus.NOT_FOUND);
    }

    /* If DTO is invalid */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException exception) {
        System.out.println(exception.getMessage());
        Map<String, String> errors = new HashMap<>();
        // Find name and error -- getBindingResults
        exception.getBindingResult().getAllErrors().forEach((error) -> {

            // FieldError -- To get fields
            String field = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(field, message);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }


}
