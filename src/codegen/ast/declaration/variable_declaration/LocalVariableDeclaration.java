package codegen.ast.declaration.variable_declaration;

import scanner.classes.Type;

public class LocalVariableDeclaration extends VariableDeclaration{

    public LocalVariableDeclaration(String name, Type type) {
        super(name, type, true);
    }

    @Override
    public void compile() {

    }
}
