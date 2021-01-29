package codegen.utils.errors;
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
        super("TypeError: unsupported operand type(s) for" + operation + ": " + stringifyMultipleType(Types));
    }

    /*public TypeError(String operation, Type firstType, Type secondType) {
        super("TypeError: unsupported operand type(s) for" + operation + ": " + firstType + ", " + secondType);
    }*/
}
