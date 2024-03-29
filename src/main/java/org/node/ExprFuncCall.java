package org.node;

import java.util.ArrayList;
import java.util.Stack;

import org.simplelang.Ast;
import org.simplelang.Ast.FuncType;
import org.error.Err;
import org.error.Err.Errno;
import org.node.basic.Pointer;
import org.node.basic.Pointer.PtrType;

public class ExprFuncCall extends Expression {
    public String funcName;
    public ArrayList<Expression> args;

    public ExprFuncCall(String _funcName) {
        super();
        funcName = _funcName;
        args = new ArrayList<>();
    }

    @Override
    public Stack<Err> codegen(Ast tree) {
        System.err.format("(line %d)Node: FuncCall node, depth: %d, num_args: %d\n",
                lineno, tree.symTable.size(), args.size());
        System.err.println(tree.symTable);

        tmpNum = Expression.tmpCounter;
        Expression.tmpCounter++;
        Stack<Err> stackErrs = new Stack<Err>();

        if (!tree.functions.containsKey(funcName)) {
            stackErrs.push(new Err(
                Err.Errno.ERR_FUNC, 
                lineno, 
                String.format("Function \'%s\' doesn't exist", funcName), 
                errText
            ));
            return stackErrs;
        }

        String funcType = tree.functions.get(funcName).getValue0();
        switch (funcType) {
            case "i32" : {
                exprTy = ExprTy.INT;
                break;
            }
            case "double" : {
                exprTy = ExprTy.FLOAT;
                break;
            }
            case "i1" : {
                exprTy = ExprTy.BOOL;
                break;
            }
            case "i8" : {
                exprTy = ExprTy.CHAR;
                break;
            }
            case "{ i64, i8* }" : {
                exprTy = ExprTy.ARRAY;
                break;
            }
        }

        for (Expression e : this.args) {
            Stack<Err> argErrs = e.codegen(tree);
            stackErrs.addAll(argErrs);
        }

        if (tree.functions.get(funcName).getValue1() == FuncType.LIB) {
            System.out.format("    %%t%d = call %s (i32, ...) @%s(", tmpNum, funcType, this.funcName); 
            
            for (Expression e : this.args) {
                switch (e.exprTy) {
                    case INT : {
                        System.out.format("i32 %d, i32 %%t%d, ", 0, e.tmpNum);
                        break;
                    }
                    case FLOAT : {
                        System.out.format("i32 %d, double %%t%d, ",1, e.tmpNum);
                        break;
                    }
                    case BOOL : {
                        System.out.format("i32 %d, i1 %%t%d, ", 2, e.tmpNum);
                        break;
                    }
                    case CHAR : {
                        System.out.format("i32 %d, i8 %%t%d, ", 3, e.tmpNum);
                        break;
                    }
                    case PTR : {
                        if (((Pointer)e).ptrTy == PtrType.PTRINT)
                            System.out.format("i32 %d, i32** %%t%d, ", 4, e.tmpNum);
                        else 
                            System.out.format("i32 %d, double** %%t%d, ", 5, e.tmpNum);
                        break;
                    }
                    case ARRAY : {
                        System.out.format("i32 %d, %%struct.Array %%t%d, ", 6, e.tmpNum);
                        break;
                    }
                    case STRING : {
                        System.out.format("i32 %d, i8* %%t%d, ", 7, e.tmpNum);
                        break;
                    }
                    default : {
                        stackErrs.push(new Err(Err.Errno.ERR_TY, lineno, "Unsupported type!!!", errText));
                    }
                }
            }
            System.out.format("i32 %d)\n", 8);
        }
        else {
            System.out.format("    %%t%d = call %s (", tmpNum, funcType);
            int n = this.args.size();
            Expression e;
            for (int i = 0; i < n-1; ++i) {
                e = this.args.get(i);
                switch (e.exprTy) {
                    case INT : {
                        System.out.format("i32, ");
                        break;
                    }
                    case FLOAT : {
                        System.out.format("double, ");
                        break;
                    }
                    case BOOL : {
                        System.out.format("i1, ");
                        break;
                    }
                    case CHAR : {
                        System.out.format("i8, ");
                        break;
                    }
                    case ARRAY : {
                        System.out.format("%%struct.Array, ");
                        break;
                    }
                    case STRING : {
                        System.out.format("i8*, ");
                        break;
                    }
                    default : {
                        stackErrs.push(new Err(Errno.ERR_TY, lineno, "Undefined type!!", errText));
                    }
                }
            }
            e = this.args.get(n-1);
            switch (e.exprTy) {
                case INT : {
                    System.out.format("i32) ");
                    break;
                }
                case FLOAT : {
                    System.out.format("double) ");
                    break;
                }
                case BOOL : {
                    System.out.format("i1) ");
                    break;
                }
                case CHAR : {
                    System.out.format("i8) ");
                    break;
                }
                case ARRAY : {
                    System.out.format("%%struct.Array) ");
                    break;
                }
                case STRING : {
                    System.out.format("i8*) ");
                    break;
                }
                default : {
                    stackErrs.push(new Err(Errno.ERR_TY, lineno, "Undefined type!!", errText));
                }
            }
            System.out.format("@%s (", funcName);
            for (int i = 0; i < n-1; ++i) {
                e = this.args.get(i);
                switch (e.exprTy) {
                    case INT : {
                        System.out.format("i32 %%t%d, ", e.tmpNum);
                        break;
                    }
                    case FLOAT : {
                        System.out.format("double %%t%d, ", e.tmpNum);
                        break;
                    }
                    case BOOL : {
                        System.out.format("i1 %%t%d, ", e.tmpNum);
                        break;
                    }
                    case CHAR : {
                        System.out.format("i8 %%t%d, ", e.tmpNum);
                        break;
                    }
                    case ARRAY : {
                        System.out.format("%%struct.Array %%t%d, ", e.tmpNum);
                        break;
                    }
                    case STRING : {
                        System.out.format("i8* %%t%d, ", e.tmpNum);
                        break;
                    }
                    default : {
                        stackErrs.push(new Err(Errno.ERR_TY, lineno, "Undefined type!!", errText));
                    }
                }
            }
            e = this.args.get(n-1);
            switch (e.exprTy) {
                case INT : {
                    System.out.format("i32 %%t%d)\n", e.tmpNum);
                    break;
                }
                case FLOAT : {
                    System.out.format("double %%t%d)\n", e.tmpNum);
                    break;
                }
                case BOOL : {
                    System.out.format("i1 %%t%d)\n", e.tmpNum);
                    break;
                }
                case CHAR : {
                    System.out.format("i8 %%t%d)\n", e.tmpNum);
                    break;
                }
                case ARRAY : {
                    System.out.format("%%struct.Array %%t%d)\n", e.tmpNum);
                    break;
                }
                case STRING : {
                    System.out.format("i8* %%t%d)\n", e.tmpNum);
                    break;
                }
                default : {
                    stackErrs.push(new Err(Errno.ERR_TY, lineno, "Undefined type!!", errText));
                }
            }
        }

        return stackErrs;
    }
}
