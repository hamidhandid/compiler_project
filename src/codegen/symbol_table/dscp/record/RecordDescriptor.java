package codegen.symbol_table.dscp.record;

import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

import java.util.List;

public class RecordDescriptor extends Descriptor {
    private String typeName;
    private List<RecordElement> recordElements;

    public RecordDescriptor(String addressName) {
        super(addressName, Type.RECORD, false);
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public void setRecordElements(List<RecordElement> recordElements) {
        this.recordElements = recordElements;
    }

    public int getIndex(String recordElementName) {
        for (int i = 0; i < recordElements.size(); i++) {
            if (recordElements.get(i).descriptor.getName().equals(recordElementName)) {
                return i;
            }
        }
        return -1;
    }
}

