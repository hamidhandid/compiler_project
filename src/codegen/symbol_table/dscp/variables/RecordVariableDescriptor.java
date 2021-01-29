package codegen.symbol_table.dscp.variables;

import scanner.classes.Type;

public class RecordVariableDescriptor extends VariableDescriptor{
    public RecordVariableDescriptor(String name, Type type) {
        super(name, type, false);
    }
}
