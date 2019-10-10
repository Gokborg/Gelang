package io.github.gokborg.gelang;

import java.util.List;

import io.github.gokborg.gelang.codegen.CodeGeneration;
import io.github.gokborg.gelang.lexer.Lexer;
import io.github.gokborg.gelang.lexer.TokenizedLine;
import io.github.gokborg.gelang.parser.AST;

public class Gelang
{
	public static void main(String[] args)
	{
		String[] lines = new String[] {
				"1+2+3+4"
		};
		System.out.println("What a gay!");
		List<TokenizedLine> tokLines = new Lexer().lex(lines);
		
		AST ast = new AST(tokLines);
		System.out.println("<Tree>");
		ast.tree(" ");
		
		CodeGeneration codeGen = new CodeGeneration(ast);
	}
}
