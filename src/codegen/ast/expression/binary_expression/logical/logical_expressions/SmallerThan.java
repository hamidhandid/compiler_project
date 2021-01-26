package codegen.ast.expression.binary_expression.logical.logical_expressions;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.logical.LogicalExpression;

public class SmallerThan extends LogicalExpression {

    public  SmallerThan(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "<";
    }

    @Override
    public void compile() {
        super.compile();
    }
}
