package codegen.ast.expression.binary_expression.arithmetic;

import codegen.symbol_table.stacks.SemanticStack;

public class Add extends BinaryArithmeticExpression {
    public Add(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void compile() {
//        super.compile();
        SemanticStack.getInstance().push(firstOperand + secondOperand);
    }
}
