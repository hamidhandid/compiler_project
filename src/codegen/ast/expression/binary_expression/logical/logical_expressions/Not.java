package codegen.ast.expression.binary_expression.logical.logical_expressions;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.logical.LogicalExpression;
import codegen.symbol_table.dscp.Descriptor;

public class Not extends LogicalExpression {

    public Not(Descriptor firstOperand) {
        super(firstOperand, null, "!");
    }

    @Override
    public void compile() {
       super.compile();
    }
}
