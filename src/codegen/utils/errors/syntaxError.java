package codegen.utils.errors;

public class syntaxError extends RuntimeException {
    public syntaxError() {
        super("SyntaxError: invalid syntax");
    }
}
