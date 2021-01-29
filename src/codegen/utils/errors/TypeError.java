package codegen.utils.errors;
import scanner.classes.Type;

public class TypeError extends RuntimeException {
    public TypeError(String operation, Type firstType, Type secondType) {
        super("TypeError: unsupported operand type(s) for" + operation + ": " + firstType + ", " + secondType);
    }
}
