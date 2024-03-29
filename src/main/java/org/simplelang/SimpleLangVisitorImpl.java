package org.simplelang;

import org.antlr.v4.runtime.misc.Interval;
import org.node.*;
import org.node.Expression.ExprTy;
import org.node.arithmetic.*;
import org.node.basic.*;
import org.node.comp.*;
import org.node.logic.*;

public class SimpleLangVisitorImpl extends SimpleLangBaseVisitor<Node> {
    @Override
    public Node visitBlock(SimpleLangParser.BlockContext ctx) {
        Block blockNode = new Block();
        blockNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        blockNode.errText = ctx.start.getInputStream().getText(interval);
        blockNode.stmts = visit(ctx.statements());
        return blockNode;
    }
    @Override
    public Node visitSingleStat(SimpleLangParser.SingleStatContext ctx) {
        return visit(ctx.statement());
    }

    @Override
    public Node visitMultipleStat(SimpleLangParser.MultipleStatContext ctx) {
        Statement statNode = (Statement)visit(ctx.statement());
        Statement nextStat = (Statement)visit(ctx.statements());
        statNode.children.add(nextStat);

        return statNode;
    }

    @Override public Node visitAssignVar(SimpleLangParser.AssignVarContext ctx) {
        Assignment assignNode = new Assignment(Ast.Mut.VAR);
        assignNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        assignNode.errText = ctx.start.getInputStream().getText(interval);
        assignNode.varName = ctx.ID().getText();
        assignNode.exprValue = (Expression)visit(ctx.expr());
        return assignNode;
    }

    @Override public Node visitAssignConst(SimpleLangParser.AssignConstContext ctx) {
        Assignment assignNode = new Assignment(Ast.Mut.CONST);
        assignNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        assignNode.errText = ctx.start.getInputStream().getText(interval);
        assignNode.varName = ctx.ID().getText();
        assignNode.exprValue = (Expression)visit(ctx.expr());
        return assignNode;
    }

    @Override
    public Node visitSFuncCall(SimpleLangParser.SFuncCallContext ctx) {
        StatFuncCall funcCallNode = new StatFuncCall(ctx.ID().getText());
        funcCallNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        funcCallNode.errText = ctx.start.getInputStream().getText(interval);
        int n = ctx.expr().size();
        for (int i = 0; i < n; ++i) {
            funcCallNode.args.add((Expression) visit(ctx.expr(i)));
        }
        return funcCallNode;
    }

    @Override public Node visitNonEmptyIf(SimpleLangParser.NonEmptyIfContext ctx) {
        If ifNode = new If(false);
        ifNode.cond = (Expression) visit(ctx.expr());
        ifNode.blockOfStmts = (Block) visit(ctx.block_of_stmts());
        return ifNode;
    }

    @Override public Node visitEmptyIf(SimpleLangParser.EmptyIfContext ctx) {
        If ifNode = new If(true);
        ifNode.cond = new Bool(true);
        ifNode.blockOfStmts = (Block) visit(ctx.block_of_stmts());
        return ifNode;
    }

    @Override
    public Node visitWhileStmt(SimpleLangParser.WhileStmtContext ctx) {
        While whileNode = new While();
        whileNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        whileNode.errText = ctx.start.getInputStream().getText(interval);
        whileNode.cond = (Expression) visit(ctx.expr());
        whileNode.blockOfStmts = (Block) visit(ctx.block_of_stmts());
        return whileNode;
    }

    @Override
    public Node visitForStmt(SimpleLangParser.ForStmtContext ctx) {
        For forNode = new For(ctx.ID().getText());
        forNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        forNode.errText = ctx.start.getInputStream().getText(interval);
        forNode.startExpr = (Expression)visit(ctx.expr(0));
        forNode.endExpr = (Expression)visit(ctx.expr(1));
        forNode.blockOfStmts = (Block) visit(ctx.block_of_stmts());
        return forNode;
    }

    @Override
    public Node visitFuncDef(SimpleLangParser.FuncDefContext ctx) {
        FuncDef funcDefNode = new FuncDef(ctx.ID(0).getText());
        funcDefNode.blockOfStmts = (Block) visit(ctx.block_of_stmts());
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        funcDefNode.errText = ctx.start.getInputStream().getText(interval);
        int sz = ctx.ID().size();
        
        for (int i = 1; i < sz; ++i) {
            Expression.ExprTy ty = ExprTy.UNDEFINED;
            switch (ctx.TYPE(i-1).getText()) {
                case "int" : 
                    ty = ExprTy.INT;
                    break;
                case "float" : 
                    ty = ExprTy.FLOAT;
                    break;
                case "bool" : 
                    ty = ExprTy.BOOL;
                    break;
                case "char" : 
                    ty = ExprTy.CHAR;
                    break;
                case "Array" : 
                    ty = ExprTy.ARRAY;
                    break;
            }
            funcDefNode.args.put(ctx.ID(i).getText(), ty);
        }

        switch (ctx.TYPE(sz-1).getText()) {
            case "int" :  funcDefNode.funcRetType = "i32"; break;
            case "float" :  funcDefNode.funcRetType = "double"; break;
            case "bool" :  funcDefNode.funcRetType = "i1"; break;
            case "char" : funcDefNode.funcRetType = "i8"; break;
            // case "Array" :  funcDefNode.funcRetType = "{ i64, i8* }"; break;
            default : funcDefNode.funcRetType = "void"; break;
        }

        return funcDefNode;
    }

    @Override
    public Node visitReturn(SimpleLangParser.ReturnContext ctx) {
        Return retNode = new Return();
        retNode.retExpr = (Expression) visit(ctx.expr());
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        retNode.errText = ctx.start.getInputStream().getText(interval);
        return retNode;
    }

    @Override
    public Node visitExpression(SimpleLangParser.ExpressionContext ctx) {
        return visit(ctx.logical());
    }

    @Override
    public Node visitOr(SimpleLangParser.OrContext ctx) {
        Or orNode = new Or();
        orNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        orNode.errText = ctx.start.getInputStream().getText(interval);
        orNode.children.add(visit(ctx.logical()));
        orNode.children.add(visit(ctx.compare()));
        return orNode;
    }

    @Override
    public Node visitAnd(SimpleLangParser.AndContext ctx) {
        And andNode = new And();
        andNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        andNode.errText = ctx.start.getInputStream().getText(interval);
        andNode.children.add(visit(ctx.logical()));
        andNode.children.add(visit(ctx.compare()));
        return andNode;
    }

    @Override public Node visitGreat(SimpleLangParser.GreatContext ctx) {
        Great greatNode = new Great();
        greatNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        greatNode.errText = ctx.start.getInputStream().getText(interval);
        greatNode.children.add(visit(ctx.compare()));
        greatNode.children.add(visit(ctx.plusOrMinus()));
        return greatNode;
    }

    @Override public Node visitLess(SimpleLangParser.LessContext ctx) {
        Less lessNode = new Less();
        lessNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        lessNode.errText = ctx.start.getInputStream().getText(interval);
        lessNode.children.add(visit(ctx.compare()));
        lessNode.children.add(visit(ctx.plusOrMinus()));
        return lessNode;
    }

    @Override public Node visitNeq(SimpleLangParser.NeqContext ctx) {
        Neq neqNode = new Neq();
        neqNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        neqNode.errText = ctx.start.getInputStream().getText(interval);
        neqNode.children.add(visit(ctx.compare()));
        neqNode.children.add(visit(ctx.plusOrMinus()));
        return neqNode;
    }

    @Override public Node visitEq(SimpleLangParser.EqContext ctx) {
        Eq eqNode = new Eq();
        eqNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        eqNode.errText = ctx.start.getInputStream().getText(interval);
        eqNode.children.add(visit(ctx.compare()));
        eqNode.children.add(visit(ctx.plusOrMinus()));
        return eqNode;
    }

    @Override
    public Node visitPlus(SimpleLangParser.PlusContext ctx) {
        Plus plusNode = new Plus();
        plusNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        plusNode.errText = ctx.start.getInputStream().getText(interval);
        plusNode.children.add(visit(ctx.plusOrMinus()));
        plusNode.children.add(visit(ctx.mulOrDiv()));
        return plusNode;
    }

    @Override
    public Node visitMinus(SimpleLangParser.MinusContext ctx) {
        Minus minusNode = new Minus();
        minusNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        minusNode.errText = ctx.start.getInputStream().getText(interval);
        minusNode.children.add(visit(ctx.plusOrMinus()));
        minusNode.children.add(visit(ctx.mulOrDiv()));
        return minusNode;
    }

    @Override
    public Node visitMul(SimpleLangParser.MulContext ctx) {
        Mul mulNode = new Mul();
        mulNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        mulNode.errText = ctx.start.getInputStream().getText(interval);
        mulNode.children.add(visit(ctx.mulOrDiv()));
        mulNode.children.add(visit(ctx.pointer()));
        return mulNode;
    }

    @Override
    public Node visitDiv(SimpleLangParser.DivContext ctx) {
        Div divNode = new Div();
        divNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        divNode.errText = ctx.start.getInputStream().getText(interval);
        divNode.children.add(visit(ctx.mulOrDiv()));
        divNode.children.add(visit(ctx.pointer()));
        return divNode;
    }

    @Override public Node visitPtr(SimpleLangParser.PtrContext ctx) {
        Pointer ptrNode = new Pointer();
        ptrNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        ptrNode.errText = ctx.start.getInputStream().getText(interval);
        ptrNode.children.add(visit(ctx.atom()));
        return ptrNode;
    }

    @Override public Node visitFloat(SimpleLangParser.FloatContext ctx) {
        FloatP floatNode = new FloatP();
        floatNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        floatNode.errText = ctx.start.getInputStream().getText(interval);
        floatNode.numValue = Float.parseFloat(ctx.FLOAT().getText());
        return floatNode;
    }

    @Override public Node visitCharacter(SimpleLangParser.CharacterContext ctx) {
        Char charNode = new Char();
        charNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        charNode.errText = ctx.start.getInputStream().getText(interval);
        charNode.charValue = ctx.CHAR().getText().charAt(1);
        return charNode;
    }

    @Override public Node visitString (SimpleLangParser.StringContext ctx) {
        String content = ctx.getText();
        Str stringNode = new Str(content.substring(1, content.length()-1));
        stringNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        stringNode.errText = ctx.start.getInputStream().getText(interval);
        return stringNode;
    }

    @Override
    public Node visitInteger(SimpleLangParser.IntegerContext ctx) {
        Int intNode = new Int();
        intNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        intNode.errText = ctx.start.getInputStream().getText(interval);
        intNode.numValue = Integer.parseInt(ctx.INT().getText());
        return intNode;
    }

    @Override
    public Node visitEFuncCall(SimpleLangParser.EFuncCallContext ctx) {
        ExprFuncCall funcCallNode = new ExprFuncCall(ctx.ID().getText());
        funcCallNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        funcCallNode.errText = ctx.start.getInputStream().getText(interval);
        int n = ctx.expr().size();
        for (int i = 0; i < n; ++i) {
            funcCallNode.args.add((Expression) visit(ctx.expr(i)));
        }
        return funcCallNode;
    }

    @Override public Node visitTrue(SimpleLangParser.TrueContext ctx) {
        Bool boolNode = new Bool(true);
        boolNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        boolNode.errText = ctx.start.getInputStream().getText(interval);
        return boolNode;
    }

    @Override public Node visitFalse(SimpleLangParser.FalseContext ctx) {
        Bool boolNode = new Bool(false);
        boolNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        boolNode.errText = ctx.start.getInputStream().getText(interval);
        return boolNode;
    }

    @Override
    public Node visitVariable(SimpleLangParser.VariableContext ctx) {
        Var varNode = new Var();
        varNode.lineno = ctx.getStart().getLine();
        int a = ctx.start.getStartIndex();
        int b =  ctx.stop.getStopIndex();
        Interval interval = new Interval(a, b);
        varNode.errText = ctx.start.getInputStream().getText(interval);
        varNode.varName = ctx.ID().getText();
        return varNode;
    }

    @Override
    public Node visitParens(SimpleLangParser.ParensContext ctx) {
        return visit(ctx.logical());
    }
}
