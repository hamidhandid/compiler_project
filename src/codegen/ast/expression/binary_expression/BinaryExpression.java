package codegen.ast.expression.binary_expression;

import codegen.ast.Compilable;
import codegen.ast.expression.Expression;
import codegen.utils.type.TypeChecker;

public abstract class BinaryExpression implements Compilable {

    protected Expression firstOperand;
    protected Expression secondOperand;
    protected String surrogate;

    public BinaryExpression(Expression firstOperand, Expression secondOperand) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
    }

    @Override
    public void compile() {
        TypeChecker.checkType(firstOperand.getType(), secondOperand.getType(), surrogate);
        // SemanticStack.getInstance().push(firstOperand + secondOperand);
        // set opcode
        // set number1
        // set number2
        // generate code of BinaryExpression with opcode
    }
}
