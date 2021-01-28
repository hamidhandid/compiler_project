package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.binary_expression.BinaryExpression;

public class Add extends BinaryExpression {
    public Add(Object firstOperand, Object secondOperand) {
        super(firstOperand, secondOperand, "+");
    }

    @Override
    public void compile() {
        super.compile();
    }
}
