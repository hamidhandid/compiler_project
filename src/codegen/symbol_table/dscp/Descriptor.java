package codegen.symbol_table.dscp;

import scanner.classes.Type;

import java.util.Objects;

public abstract class Descriptor {
    private String name;
    private Type type;
    private boolean isLocal;

    public Descriptor(String name, Type type, boolean isLocal) {
        this.name = name;
        this.type = type;
        this.isLocal = isLocal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public boolean getIsLocal() {
        return isLocal;
    }

    public void setIsLocal(boolean local) {
        isLocal = local;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descriptor that = (Descriptor) o;
        return Objects.equals(name, that.name) &&
                type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, type);
    }
}
