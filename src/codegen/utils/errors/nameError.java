package codegen.utils.errors;

import codegen.CodeGenerator;

public class nameError extends RuntimeException {
    public nameError(String name, boolean isDefined) {
        super("NameError: name '" + name + "' is"+ (isDefined ? "": " not") + " defined at line " + CodeGenerator.lexical.getLine());
    }
}
