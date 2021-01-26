package codegen.utils.type;

import codegen.utils.TypeError;
import scanner.classes.Type;

public class TypeChecker {
    public static boolean checkType(Type firstType, Type secondType, String operation) {
        if (firstType == secondType) {
            return true;
        }
        throw new TypeError("TypeError: unsupported operand type(s) for" + operation + ": " + firstType + ", " + secondType);
    }
}
