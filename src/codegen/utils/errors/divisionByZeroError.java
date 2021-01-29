package codegen.utils.errors;

public class divisionByZeroError extends RuntimeException {
    public divisionByZeroError() {
        super("ZeroDivisionError: division by zero");
    }
}
