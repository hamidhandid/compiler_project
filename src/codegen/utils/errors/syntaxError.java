package codegen.utils.errors;

import codegen.CodeGenerator;

public class syntaxError extends RuntimeException {
    public syntaxError() {
        super("SyntaxError: invalid syntax at line " + CodeGenerator.lexical.getLine());
    }
}
