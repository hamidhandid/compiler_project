package codegen.utils.errors;

import codegen.CodeGenerator;

public class divisionByZeroError extends RuntimeException {
    public divisionByZeroError() {
        super("ZeroDivisionError: division by zero at line " + CodeGenerator.lexical.getLine());
    }
}
