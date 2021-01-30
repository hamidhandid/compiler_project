package codegen.ast.expression.unary_expression.arithmetic;

import codegen.ast.expression.binary_expression.logical.LogicalExpression;
import codegen.symbol_table.dscp.Descriptor;

public class PlusPlus extends LogicalExpression {

    public PlusPlus(Descriptor firstOperand) {
        super(firstOperand, null, "++");
    }

    @Override
    public void compile() {
        super.compile();
    }
}

