package codegen.symbol_table.dscp.variables;

import scanner.classes.Type;

public class LocalVariableDescriptor extends VariableDescriptor {
    public LocalVariableDescriptor(String name, Type type) {
        super(name, type, true);
    }
}
