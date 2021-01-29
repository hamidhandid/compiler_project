package codegen.ast.declaration.record_declartion;

import codegen.CodeGenerator;
import codegen.ast.declaration.DeclarationWithType;
import codegen.symbol_table.GlobalSymbolTable;
import codegen.symbol_table.dscp.variables.RecordVariableDescriptor;
import scanner.classes.Type;

public class RecordVariableDeclaration extends DeclarationWithType {
    public RecordVariableDeclaration(String name, Type type) {
        super(name, type);
    }

    @Override
    public void compile() {
        GlobalSymbolTable.getSymbolTable().addDescriptor(getName(), new RecordVariableDescriptor(CodeGenerator.getVariableName(), getType()));
    }
}
