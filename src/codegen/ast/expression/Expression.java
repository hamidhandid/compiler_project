package codegen.ast.expression;

import codegen.ast.Compilable;
import scanner.classes.Type;

public abstract class Expression implements Compilable {
    private Type type;

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
