package edu.itsphere.back.user.registration;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class RegistrationRequest {
    private String login;
    private String password;
    private String name;
    private String about;
}
