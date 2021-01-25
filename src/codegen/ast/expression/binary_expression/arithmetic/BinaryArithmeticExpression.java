package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.Compilable;

public abstract class BinaryArithmeticExpression implements Compilable {

    protected int firstOperand;
    protected int secondOperand;

    public BinaryArithmeticExpression(int firstOperand, int secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public void compile() {}
}
