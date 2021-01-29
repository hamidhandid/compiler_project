package codegen.symbol_table.dscp.variables;

import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public abstract class VariableDescriptor extends Descriptor {
    private String value;

    public VariableDescriptor(String name, Type type, boolean isLocal) {
        super(name, type, isLocal);
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
