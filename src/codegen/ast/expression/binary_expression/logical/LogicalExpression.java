package codegen.ast.expression.binary_expression.logical;

import codegen.ast.expression.Expression;
import codegen.ast.expression.binary_expression.BinaryExpression;
import codegen.symbol_table.dscp.Descriptor;
import scanner.classes.Type;

public abstract class LogicalExpression extends BinaryExpression {

    public LogicalExpression(Descriptor firstOperand, Descriptor secondOperand, String operation) {
        super(firstOperand, secondOperand, operation);
    }
}
