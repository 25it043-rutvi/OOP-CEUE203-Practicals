package service;
import model.Account;
import util.AnnotationValidator;

public class MiniBank {
    public static void main(String[] args) {
        Account invalid = new Account("AC0001", "A very very very very very long customer name", -100);
        String[] errors = AnnotationValidator.validate(invalid);
        for (String error : errors) System.out.println(error);
        Account valid = new Account("AC0002", "Riya", 500);
        System.out.println("Valid account errors: " + AnnotationValidator.validate(valid).length);
    }
}
