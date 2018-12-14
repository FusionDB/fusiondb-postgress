package cn.fusiondb;

import cn.fusiondb.dsl.parser.*;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.junit.Test;

/**
 * Create by xujiang on 2018/12/12
 **/
public class FqlTest {

    @Test
    public void testVisitor() {
        ANTLRInputStream input = new ANTLRInputStream("load csv.`test/a.txt` as a;");
        FQLLexer lexer = new FQLLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        FQLParser parser = new FQLParser(tokens);
        ParseTree tree = parser.sql(); // fql is the starting rule

        for (int i=0; i< tree.getChildCount(); i++) {
            System.out.println(tree.getChild(i).getText());
        }

        System.out.println("LISP:");
        System.out.println(tree.toStringTree(parser));
        System.out.println();

        System.out.println("Visitor:");
        FQLVisitor evalByVisitor = new FQLBaseVisitor();
        evalByVisitor.visit(tree);
        System.out.println();

        System.out.println("Listener:");
        ParseTreeWalker walker = new ParseTreeWalker();
        FQLListener evalByListener = new FQLBaseListener();
        walker.walk(evalByListener, tree);
    }

}
