package br.com.sw2you.realmeet.validator;



import org.springframework.data.util.Streamable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidatiorErros implements Streamable<ValidationError> {

    private final List<ValidationError> validationErrorList;

    public ValidatiorErros() {
        this.validationErrorList = new ArrayList<>();
    }

    public ValidatiorErros add(String field, String errorCode){
        return add(new ValidationError(field,errorCode));
    }

    public ValidatiorErros add(ValidationError validationError){
        validationErrorList.add(validationError);
        return this;
    }

    public ValidationError getError(int index){
        return validationErrorList.get(index);
    }
    public int getNumberError(){
        return validationErrorList.size();
    }

    public boolean hasError(){
        return !validationErrorList.isEmpty();
    }

    @Override
    public String toString() {
        return "ValidationErros{" +
                "validationErrorList=" + validationErrorList +
                '}';
    }

    @Override
    public Iterator<ValidationError> iterator() {
        return validationErrorList.iterator();
    }
}
