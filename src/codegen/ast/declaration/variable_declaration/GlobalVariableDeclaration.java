package codegen.ast.declaration.variable_declaration;

import scanner.classes.Type;

public class GlobalVariableDeclaration extends VariableDeclaration {
    public GlobalVariableDeclaration(String name, Type type) {
        super(name, type, false);
    }

    @Override
    public void compile() {

    }
}
