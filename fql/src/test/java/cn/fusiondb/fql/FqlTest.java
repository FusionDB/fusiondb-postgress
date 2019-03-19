/*
 * Copyright 2019 Fusionlab, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.fusiondb.fql;

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
