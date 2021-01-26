package codegen.ast.declaration.function_declartion;

import codegen.ast.declaration.DeclarationWithType;
import codegen.ast.declaration.variable_declaration.LocalVariableDeclaration;
import codegen.ast.declaration.variable_declaration.VariableDeclaration;
import scanner.classes.Type;

import java.util.List;

public class FunctionDeclaration extends DeclarationWithType {

    private List<LocalVariableDeclaration> parameters;

    public FunctionDeclaration(String name, Type type, List<LocalVariableDeclaration> parameters) {
        super(name, type);
        this.parameters = parameters;
    }

    @Override
    public void compile() {

    }
}
