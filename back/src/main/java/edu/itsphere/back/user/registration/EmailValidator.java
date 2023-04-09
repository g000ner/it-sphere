package edu.itsphere.back.user.registration;

import org.springframework.stereotype.Service;

@Service
public class EmailValidator {
    public boolean validate(String email) {
        return true; // TODO написать regex для валидации майла
    }
}
