package codegen.ast.declaration.array_declaration;

import codegen.ast.declaration.DeclarationWithType;
import codegen.ast.expression.Expression;
import scanner.classes.Type;

import java.util.List;

public class ArrayDeclaration extends DeclarationWithType {
    private int numberOfDimensions;
    private List<Expression> dimensions;

    public ArrayDeclaration(String name, Type type, int numberOfDimensions, List<Expression> dimensions) {
        super(name, type);
        this.numberOfDimensions = numberOfDimensions;
        this.dimensions = dimensions;
    }

    @Override
    public void compile() {

    }
}
