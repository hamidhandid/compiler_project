package codegen.symbol_table.dscp.array;

import scanner.classes.Type;

public class GlobalArrayDescriptor extends ArrayDescriptor {
    public GlobalArrayDescriptor(String name, Type type, boolean isLocal) {
        super(name, type, isLocal);
    }
}
