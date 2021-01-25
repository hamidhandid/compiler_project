package codegen.ast.expression.binary_expression;

import codegen.symbol_table.stacks.SemanticStack;

public class Add extends BinaryExpression {
    super.surrogate = "+";
    public Add(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand);
    }

    @Override
    public void compile() {
//        super.compile();
        generate_code(surrogate);
    }
}
