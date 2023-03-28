package br.com.sw2you.realmeet.validator;


import br.com.sw2you.realmeet.exception.InvalidiRequestException;

import static br.com.sw2you.realmeet.validator.ValidatorConstants.BELOW_MIN_VALUE;
import static br.com.sw2you.realmeet.validator.ValidatorConstants.EXCEEDS_MAX_LENGTH;
import static java.util.Objects.isNull;
import static org.apache.commons.lang3.StringUtils.isBlank;

public final class ValidatorUtils {

    private ValidatorUtils(){}

   public static void thorwOnErros(ValidatiorErros validationErrors){
        if (validationErrors.hasError()){
            throw new InvalidiRequestException(validationErrors);
        }
    }

    public static boolean validateRequired(String fields, String fieldName, ValidatiorErros validationErrors){
        if(isBlank(fields)){
            validationErrors.add(fieldName,fieldName +  ValidatorConstants.MISSING);
            return false;
        }
        return true;
    }
    public static boolean validateRequired(Object fields, String fieldName, ValidatiorErros validationErrors){
        if(isNull(fields)){
            validationErrors.add(fieldName,fieldName +  ValidatorConstants.MISSING);
            return false;
        }
        return true;
    }

    public static boolean validateMaxLength(
            String field,
            String fieldName,
            int maxLength,
            ValidatiorErros  validationErrors
    ) {
        if (!isBlank(field) && field.trim().length() > maxLength) {
            validationErrors.add(fieldName, fieldName + EXCEEDS_MAX_LENGTH);
            return false;
        }
        return true;
    }
    public static boolean validateMaxValuw(
            Integer field,
            String fieldName,
            int maxValue,
            ValidatiorErros  validationErrors
    ) {
        if (!isNull(field) && field > maxValue) {
            validationErrors.add(fieldName, fieldName + EXCEEDS_MAX_LENGTH);
            return false;
        }
        return true;
    }
    public static boolean validateMinValuw(
            Integer field,
            String fieldName,
            int maxValue,
            ValidatiorErros  validationErrors
    ) {
        if (!isNull(field) && field < maxValue) {
            validationErrors.add(fieldName, fieldName + BELOW_MIN_VALUE);
            return false;
        }
        return true;
    }
}
