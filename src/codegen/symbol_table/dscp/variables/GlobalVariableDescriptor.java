package codegen.symbol_table.dscp.variables;

import scanner.classes.Type;

public class GlobalVariableDescriptor extends VariableDescriptor {
    public GlobalVariableDescriptor(String name, Type type) {
        super(name, type, false);
    }
}
