package codegen.ast.declaration.variable_declaration;

import codegen.symbol_table.stacks.SymbolTableStack;
import scanner.classes.Type;

public class LocalVariableDeclaration extends VariableDeclaration {

    public LocalVariableDeclaration(String name, Type type) {
        super(name, type, true);
    }

    @Override
    public void compile() {
    }
}
