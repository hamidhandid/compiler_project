package codegen.utils.errors;

import codegen.CodeGenerator;

public class DivisionByZeroError extends RuntimeException {
    public DivisionByZeroError() {
        super("ZeroDivisionError: division by zero at line " + CodeGenerator.lexical.getLine());
    }
}
