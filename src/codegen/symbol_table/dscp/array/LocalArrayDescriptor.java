package codegen.symbol_table.dscp.array;

import scanner.classes.Type;

public class LocalArrayDescriptor extends ArrayDescriptor {
    public LocalArrayDescriptor(String name, Type type) {
        super(name, type, true);
    }
}
