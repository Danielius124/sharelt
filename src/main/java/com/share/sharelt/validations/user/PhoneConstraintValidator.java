package com.share.sharelt.validations.user;


import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneConstraintValidator implements ConstraintValidator<ValidPhone, String> {


    @Override
    public void initialize(ValidPhone constraintAnnotation) {

    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        PhoneNumberUtil phoneNumberUtil = PhoneNumberUtil.getInstance();
        boolean valid = false;
        try {
            valid = phoneNumberUtil.isValidNumber(phoneNumberUtil.parse(value, "LT"));
        } catch (NumberParseException e) {
            e.printStackTrace();
        }
        return valid;
    }
}