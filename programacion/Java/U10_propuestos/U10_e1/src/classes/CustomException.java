package classes;

import java.lang.Exception;

public class CustomException extends Exception {
    public CustomException(String msg) {
        super(msg);
    }
}