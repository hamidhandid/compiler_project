package codegen.ast.declaration.record_declartion;

import codegen.ast.declaration.Declaration;
import codegen.symbol_table.dscp.variables.RecordVariableDescriptor;

import java.util.List;

public class RecordDeclaration extends Declaration {

    private List<RecordVariableDescriptor> variableDescriptors;
    private String type;

    public RecordDeclaration(String name) {
        super(name);
    }

    @Override
    public void compile() {
//        GlobalSymbolTable.getSymbolTable().addDescriptor(new RecordDes(getName(), ));
    }
}
