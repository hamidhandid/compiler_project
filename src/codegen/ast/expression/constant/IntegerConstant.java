package codegen.ast.expression.constant;

import codegen.symbol_table.dscp.variables.LocalVariableDescriptor;
import codegen.symbol_table.stacks.SemanticStack;

public class IntegerConstant extends ConstantExpression{
    protected int intConst;

    public IntegerConstant(int intConst) {
        this.intConst = intConst;
    }

    @Override
    public void compile() {
        System.out.println(intConst);
        SemanticStack.push(this);
    }
}
