package codegen.ast.declaration;

import codegen.ast.Compilable;
import scanner.classes.Type;

public abstract class Declaration implements Compilable {
    private String name;

    public Declaration(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
