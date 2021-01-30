package codegen.symbol_table.dscp.record;

import codegen.symbol_table.dscp.Descriptor;

public class RecordElement {
    public int index;
    public Descriptor descriptor;

    public RecordElement(int index, Descriptor descriptor) {
        this.index = index;
        this.descriptor = descriptor;
    }
}
