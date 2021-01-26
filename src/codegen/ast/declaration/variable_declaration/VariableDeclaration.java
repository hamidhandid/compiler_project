package codegen.ast.declaration.variable_declaration;

import codegen.ast.declaration.DeclarationWithType;
import scanner.classes.Type;

public abstract class VariableDeclaration extends DeclarationWithType {

    private boolean isLocal;

    public VariableDeclaration(String name, Type type, boolean isLocal) {
        super(name, type);
        this.isLocal = isLocal;
    }
}
