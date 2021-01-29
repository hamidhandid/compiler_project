package codegen.utils;

public class nameError extends RuntimeException {
    public nameError(String name, boolean isDefined) {
        if (isDefined) {
            super("NameError: name '" + name + "' is not defined");
            return;
        }
        super("NameError: name '" + name + "' is defined before");
    }
}
