package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.binary_expression.arithmetic.BinaryExpression;
import codegen.symbol_table.stacks.SemanticStack;

public class Add extends BinaryExpression {

    public Add(int firstOperand, int secondOperand) {
        super(firstOperand, secondOperand);
        super.surrogate = "+";
    }

    @Override
    public void compile() {
//        super.compile();
        generate_code(surrogate);
    }
}
