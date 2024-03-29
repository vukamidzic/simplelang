package org.node.basic;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;


public class Bool extends Expression {
    public boolean boolValue;
    public Bool(boolean _boolValue) {
        super();
        exprTy = Expression.ExprTy.BOOL;
        boolValue = _boolValue;
    }

    @Override
    public Stack<Err> codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        System.out.format("    %%t%d = add i1 %d, 0\n", tmpNum, (boolValue) ? 1 : 0);

        return new Stack<Err>();
    }
}
