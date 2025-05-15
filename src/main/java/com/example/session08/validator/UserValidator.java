package com.example.session08.validator;

import com.example.session08.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;

        // Kiểm tra tên
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "error.name", "Tên không được để trống");

        // Kiểm tra email
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.email", "Email không được để trống");
        if (user.getEmail() != null && !user.getEmail().matches("^[\\w.-]+@[\\w.-]+\\.\\w{2,}$")) {
            errors.rejectValue("email", "error.email.format", "Email không hợp lệ");
        }

        // Kiểm tra số điện thoại
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "error.phone", "Số điện thoại không được để trống");
        if (user.getPhone() != null && !user.getPhone().matches("\\d{10}")) {
            errors.rejectValue("phone", "error.phone.format", "Số điện thoại phải có 10 chữ số");
        }
    }
}
