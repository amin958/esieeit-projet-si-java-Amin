package com.esieeit.projetsi.domain.validation;

import com.esieeit.projetsi.domain.exception.ValidationException;
import java.util.regex.Pattern;

public final class Validators {
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[^@\\s]+@[^@\\s]+\\.[^@\\s]+$");

    private Validators() {} // On ne peut pas instancier cette classe

    public static void requireNonNull(Object value, String fieldName) {
        if (value == null) {
            throw new ValidationException(fieldName + " ne doit pas être null");
        }
    }

    public static String requireNonBlank(String value, String fieldName, int min, int max) {
        if (value == null || value.trim().isEmpty()) {
            throw new ValidationException(fieldName + " ne doit pas être vide");
        }
        String v = value.trim();
        if (v.length() < min || v.length() > max) {
            throw new ValidationException(fieldName + " doit avoir entre " + min + " et " + max + " caractères");
        }
        return v;
    }

    public static String requireEmail(String value, String fieldName) {
        String v = requireNonBlank(value, fieldName, 5, 254);
        if (!EMAIL_PATTERN.matcher(v).matches()) {
            throw new ValidationException(fieldName + " doit être un email valide");
        }
        return v;
    }
}