package io.github.gokborg.gelang.parser;

import java.util.ArrayList;
import java.util.List;

import io.github.gokborg.gelang.lexer.TokenType;
import io.github.gokborg.gelang.lexer.TokenizedLine;
import io.github.gokborg.gelang.parser.nodes.Expression;
import io.github.gokborg.gelang.parser.nodes.Node;
import io.github.gokborg.gelang.parser.nodes.expressions.BinaryOp;
import io.github.gokborg.gelang.parser.nodes.expressions.OperationType;
import io.github.gokborg.gelang.parser.nodes.expressions.UnaryOp;
import io.github.gokborg.gelang.parser.nodes.expressions.UnaryType;

public class AST
{
	private TokenBuffer buf = new TokenBuffer();
	private List<Node> nodes = new ArrayList<>();
	public AST(List<TokenizedLine> lines)
	{
		//Puts the first line of tokens into a tree
		buf.setTokens(lines.get(0).getTokens());
		Expression exp = parseExpression();
		System.out.println(exp);
		nodes.add(exp);
	}
	
	public List<Node> getNodes()
	{
		return nodes;
	}
	
	private Expression parseExpression()
	{
		return parseFactor();
	}
	
	private Expression parseFactor()
	{
		Expression node = parseTerm();
		//System.out.println(node);
		while(buf.next().getType() == TokenType.PLUS)
		{
			node = new BinaryOp(OperationType.ADD, parseTerm(), node);
			System.out.println(node);
		}
		return node;
	}
	
	private Expression parseTerm()
	{
		if(buf.next().getType() == TokenType.NUMBER)
		{
			return new UnaryOp(UnaryType.NUMBER, buf.getCurrent().getValue());
		}
		return null;
	}
	
	public void tree(String prefix)
	{
		for(int i = 0; i < nodes.size() -1; i++)
		{
			nodes.get(i).tree(prefix + "├─", false);
		}
		nodes.get(nodes.size() - 1).tree(prefix + "└─", true);
	}
}
