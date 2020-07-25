package com.share.sharelt.validations.user;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidationWIthGooglelibphonenumberAPI implements ConstraintValidator<ValidPhone, String> {


    @Override
    public void initialize(ValidPhone constraintAnnotation) {

    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO: 2020-07-25 Todo phone validator
        return true;
    }
}