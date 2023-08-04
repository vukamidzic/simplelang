package org.node.arithmetic;

import org.simplelang.Ast;
import org.error.Err;
import org.node.Expression;

public class Mul extends Expression {
    public Mul() {super();}

    @Override public Err codegen(Ast tree) {
        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;

        Expression lhs = (Expression)children.get(0);
        Expression rhs = (Expression)children.get(1);

        Err lhsErr = lhs.codegen(tree);
        if (lhsErr.errno != Err.Errno.OK) return lhsErr;
        Err rhsErr = rhs.codegen(tree);
        if (rhsErr.errno != Err.Errno.OK) return rhsErr;

        if (lhs.exprTy == ExprTy.BOOL || rhs.exprTy == ExprTy.BOOL) {
            return new Err(Err.Errno.ERR_TY, lineno, "Can't do addition with bool and other type!!");
        }

        if (lhs.exprTy == rhs.exprTy) {
            switch (lhs.exprTy) {
                case INT : {
                    exprTy = ExprTy.INT;
                    System.out.format("    %%t%d = mul i32 %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
                case FLOAT : {
                    exprTy = ExprTy.FLOAT;
                    System.out.format("    %%t%d = fmul double %%t%d, %%t%d\n", tmpNum, lhs.tmpNum, rhs.tmpNum);
                    break;
                }
            }
        }
        else {
            return new Err(Err.Errno.ERR_TY, lineno, "Can't do multiplication with int and float!!");
        }

        return new Err(Err.Errno.OK, -1, "");
    }
}
