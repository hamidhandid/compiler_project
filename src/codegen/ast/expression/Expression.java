package codegen.ast.expression;

import codegen.ast.Compilable;

public abstract class Expression implements Compilable {
    public Expression getType() {
        // return type
        return 0;
    }
}
