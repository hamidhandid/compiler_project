package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.BinaryExpression;

public class Divide extends BinaryExpression {
    public Divide(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "/";
    }

    @Override
    public void compile() {
        super.compile();
    }
}
