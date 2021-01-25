package codegen.utils.type;

import scanner.classes.Type;

public class TypeChecker {
    public static boolean checkType(Type firstType, Type secondType) {
        return firstType == secondType;
    }
}
