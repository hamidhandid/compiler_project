package codegen.ast.expression.binary_expression;

import codegen.ast.expression.Expression;
import codegen.ast.expression.constant.IntegerConstant;
import codegen.symbol_table.SymbolTable;
import codegen.symbol_table.dscp.Descriptor;
import codegen.symbol_table.stacks.SymbolTableStack;
import codegen.utils.type.TypeChecker;

public abstract class BinaryExpression extends Expression {

    protected Expression firstOperand;
    protected Expression secondOperand;
    protected String operation;

    public BinaryExpression(Expression firstOperand, Expression secondOperand, String operation) {
        this.firstOperand = firstOperand;
        this.secondOperand = secondOperand;
        this.operation = operation;
    }

    @Override
    public void compile() {
//        if (firstOperand instanceof Descriptor && secondOperand instanceof Descriptor) {
//            Descriptor firstOperandDes = (Descriptor) firstOperand;
//            Descriptor secondOperandDes = (Descriptor) secondOperand;
//            SymbolTable st = SymbolTableStack.top();
//            if (st.containsDescriptor(firstOperandDes.getName()) && st.containsDescriptor(secondOperandDes.getName())) {
//                TypeChecker.checkType(firstOperandDes.getType(), secondOperandDes.getType(), operation);
//            } else {
//                System.err.println("Not Defined Before");
//            }
//        } else if (firstOperand instanceof IntegerConstant && secondOperand instanceof IntegerConstant) {
//            IntegerConstant firstOperandIntConst = (IntegerConstant) firstOperand;
//            IntegerConstant secondOperandIntConst = (IntegerConstant) secondOperand;
//            TypeChecker.checkType(firstOperandIntConst.getType(), secondOperandIntConst.getType(), operation);
//        }
        // SemanticStack.getInstance().push(firstOperand + secondOperand);
        // set opcode
        // set number1
        // set number2
        // generate code of BinaryExpression with opcode
    }
}
