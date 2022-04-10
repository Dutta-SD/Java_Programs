package edu.sandip.blog_app_apis.payloads;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/*
Need to validate these properties
TO make these enabled, use @Valid in the controller
@NotNul -- Allows empty things; @NotEmpty -- NotNull + Does not allow empty things
To pass RegEX - @Pattern
*/
@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private Integer id;

    @NotEmpty
    @Size(min = 4, message = "userName Must be minimum 4 characters")
    private String name;

    @Email(message = "Your Email is Invalid.. Please check it")
    private String email;

    @NotEmpty
    @Size(min = 3, max = 10, message = "password must be min 3 characters and maximum of 10 chars")
    private String password;

    @NotNull
    private String about;
}
