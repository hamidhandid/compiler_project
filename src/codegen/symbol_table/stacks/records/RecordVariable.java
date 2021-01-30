package codegen.symbol_table.stacks.records;

import scanner.classes.Type;

import java.util.Objects;

public class RecordVariable {
    String id;
    Type type;

    public RecordVariable(String id, Type type) {
        this.id = id;
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RecordVariable that = (RecordVariable) o;
        return Objects.equals(id, that.id) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public Type getType() {
        return type;
    }

    public String getId() {
        return id;
    }
}
