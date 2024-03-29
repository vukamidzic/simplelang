package org.node;

import java.util.Stack;

import org.simplelang.Ast;
import org.error.Err;

public class Block extends Statement {
    public Node stmts;
    public boolean canAddScope = true;
    public Block() {super();}

    @Override
    public Stack<Err> codegen(Ast tree) {
        System.err.format("(line %d)Node: Block node, depth: %d\n", lineno, tree.symTable.size());
        System.err.println(tree.symTable);
        Stack<Err> stackErrs = new Stack<Err>();
        
        if (canAddScope) tree.addScope();
        Stack<Err> stmtsErrs = stmts.codegen(tree);
        stackErrs.addAll(stmtsErrs);
        tree.removeScope();
        if (children.size() != 0) {
            Statement nextNode = (Statement) children.get(0);
            Stack<Err> nextErrs = nextNode.codegen(tree);
            stackErrs.addAll(nextErrs);
        }

        return stackErrs;
    }

    // returns first node from inside of block
    public Node getFirstStmt() {return stmts;}

    // checks if the block contains any return statements
    public boolean containsRetStmt() {
        Statement curr = (Statement) this.stmts;

        while (curr.children.size() > 0) {
            if (curr instanceof Return) return true; 
            curr = (Statement) curr.children.get(0);
        }

        return (curr instanceof Return);
    }
}
