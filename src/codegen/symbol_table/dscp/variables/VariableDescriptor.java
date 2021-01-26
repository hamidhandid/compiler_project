package codegen.symbol_table.dscp.variables;

import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public abstract class VariableDescriptor extends Descriptor {
    public VariableDescriptor(String name, Type type, boolean isLocal) {
        super(name, type, isLocal);
    }
}
