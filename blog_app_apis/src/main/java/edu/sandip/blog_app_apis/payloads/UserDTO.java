package edu.sandip.blog_app_apis.payloads;

import edu.sandip.blog_app_apis.utils.Constants;
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
    @Size(min = Constants.USERNAME_MIN_LIMIT, message = Constants.USER_NAME_INVALID_MESSAGE)
    private String name;

    @Email(message = Constants.EMAIL_INVALID_MESSAGE)
    private String email;

    @NotEmpty
    @Size(
            min = Constants.PASSWORD_MIN_LIMIT,
            max = Constants.PASSWORD_MAX_LIMIT,
            message = Constants.PASSWORD_INVALID_MESSAGE
    )
    private String password;

    @NotNull
    private String about;
}
