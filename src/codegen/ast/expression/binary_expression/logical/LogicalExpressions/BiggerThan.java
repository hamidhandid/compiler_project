package codegen.ast.expression.binary_expression.logical.LogicalExpressions;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.logical.LogicalExpression;

public class BiggerThan extends LogicalExpression {

    public BiggerThan(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = ">";
    }

    @Override
    public void compile() {
        super.compile();
    }
}
