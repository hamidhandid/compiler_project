package codegen.ast.expression.binary_expression.logical.LogicalExpressions;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.logical.LogicalExpression;
public class SmallerThanAndEqual extends LogicalExpression {

    public SmallerThanAndEqual(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "<=";
    }

    @Override
    public void compile() {
        super.compile();
    }
}
