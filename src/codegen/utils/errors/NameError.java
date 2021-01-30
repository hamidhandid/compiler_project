package codegen.utils.errors;

import codegen.CodeGenerator;

public class NameError extends RuntimeException {
    public NameError(String name, boolean isDefined) {
        super("NameError: name '" + name + "' is"+ (isDefined ? "": " not") + " defined at line " + CodeGenerator.lexical.getLine());
    }

    public NameError(String name, boolean isDefined,String prefix) {
        super(prefix != null ? prefix : "" + "NameError: name '" + name + "' is"+ (isDefined ? "": " not") + " defined at line " + CodeGenerator.lexical.getLine());
    }

}
