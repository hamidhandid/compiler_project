package codegen.symbol_table.dscp.record;

import codegen.ast.declaration.record_declartion.RecordDeclaration;
import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public class RecordDescriptor extends Descriptor {
    private RecordDeclaration recordDeclaration;

    public RecordDescriptor(String name, Type type, boolean isLocal, RecordDeclaration recordDeclaration) {
        super(name, type, isLocal);
        this.recordDeclaration = recordDeclaration;
    }
}
