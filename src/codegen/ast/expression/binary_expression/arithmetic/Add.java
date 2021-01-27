package codegen.ast.expression.binary_expression.arithmetic;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.BinaryExpression;
import codegen.ast.expression.constant.IntegerConstant;
import codegen.symbol_table.dscp.Descriptor;
import codegen.utils.AssemblyFileWriter;

public class Add extends BinaryExpression {
    public Add(Expression firstOperand, Expression secondOperand) {
        super(firstOperand, secondOperand, "+");
    }

    @Override
    public void compile() {
        super.compile();
//        if (firstOperand instanceof Descriptor && secondOperand instanceof Descriptor) {
//            Descriptor secondDes = (Descriptor) secondOperand;
//            Descriptor firstDes = (Descriptor) firstOperand;
//        } else if (firstOperand instanceof IntegerConstant && secondOperand instanceof IntegerConstant) {
//            IntegerConstant firstIntConst = (IntegerConstant) firstOperand;
//            IntegerConstant secondIntConst = (IntegerConstant) secondOperand;
//            AssemblyFileWriter.appendCommandToCode("la", "");
//        }
    }
}
