package codegen.utils.errors;
import codegen.CodeGenerator;
import scanner.classes.Type;

public class TypeError extends RuntimeException {
    private static String stringifyMultipleType(Type[] types) {
        String returnVal = "";
        for (Type s: types){
            returnVal += s.toString() + ", ";
        }
        return returnVal;
    }

    public TypeError(String operation, Type... Types) {
        super("TypeError: unsupported operand type(s) for" + operation + ": " + stringifyMultipleType(Types) + " at line " + CodeGenerator.lexical.getLine());
    }

    /*public TypeError(String operation, Type firstType, Type secondType) {
        super("TypeError: unsupported operand type(s) for" + operation + ": " + firstType + ", " + secondType);
    }*/
}
