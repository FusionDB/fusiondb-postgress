package cn.fusiondb.core;

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
        ANTLRInputStream input = new ANTLRInputStream("LOAD 'HDFS'.'/usr/test' FORMAT 'CSV' OPTIONS('header'='true') AS T WHERE A=1 AND B=1 AND C=1;");
        SqlBaseLexer lexer = new SqlBaseLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        SqlBaseParser parser = new SqlBaseParser(tokens);
        ParseTree tree = parser.statement(); // fql is the starting rule

        for (int i=0; i< tree.getChildCount(); i++) {
            System.out.println(tree.getChild(i).getText());
        }

        System.out.println("LISP:");
        System.out.println(tree.toStringTree(parser));
        System.out.println();

        System.out.println("Visitor:");
        SqlBaseVisitor evalByVisitor = new SqlBaseBaseVisitor();
        evalByVisitor.visit(tree);
        System.out.println();

        System.out.println("Listener:");
        ParseTreeWalker walker = new ParseTreeWalker();
        SqlBaseListener evalByListener = new SqlBaseBaseListener();
        walker.walk(evalByListener, tree);
    }

}
