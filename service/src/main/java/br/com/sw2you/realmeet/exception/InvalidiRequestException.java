package br.com.sw2you.realmeet.exception;


import br.com.sw2you.realmeet.validator.ValidatiorErros;

public class InvalidiRequestException extends RuntimeException {

    private final ValidatiorErros validationErrors;

    public InvalidiRequestException(ValidatiorErros validationErrors) {
            super(validationErrors.toString());
            this.validationErrors = validationErrors;
    }

    public ValidatiorErros validationErrors(){
        return validationErrors;
    }

}
