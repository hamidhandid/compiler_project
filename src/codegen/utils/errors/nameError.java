package codegen.utils.errors;

public class nameError extends RuntimeException {
    public nameError(String name, boolean isDefined) {
        super("NameError: name '" + name + "' is"+ (isDefined ? "": " not") + " defined");
    }
}
