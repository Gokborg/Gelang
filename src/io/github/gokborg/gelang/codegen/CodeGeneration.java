package io.github.gokborg.gelang.codegen;

import java.util.ArrayList;
import java.util.List;

import io.github.gokborg.gelang.parser.AST;
import io.github.gokborg.gelang.parser.nodes.Expression;
import io.github.gokborg.gelang.parser.nodes.Node;
import io.github.gokborg.gelang.parser.nodes.expressions.BinaryOp;
import io.github.gokborg.gelang.parser.nodes.expressions.UnaryOp;
import io.github.gokborg.gelang.parser.nodes.expressions.UnaryType;

public class CodeGeneration
{
	//2^(bit count of reg) = MAX_REGISTERS
	public static final int MAX_REGISTERS = 8;
	
	private List<String> asm = new ArrayList<>();
	private RegisterHandler reghdlr = new RegisterHandler();
	
	public CodeGeneration(AST ast)
	{
		List<Node> nodes = ast.getNodes();
		
		traverse(nodes.get(0));
		
		System.out.println("\033[95mINSTRUCTIONS\033[m");
		System.out.println("============================");
		for(String instr : asm)
		{
			System.out.println(instr);
		}
	}

	private void traverse(Node node)
	{
		if(node instanceof Expression)
		{
			Expression expression = (Expression) node;
			
			traverseExpression(expression);
		}
	}
	
	private Register traverseExpression(Expression expr)
	{
		if(expr instanceof UnaryOp)
		{
			UnaryOp single = (UnaryOp) expr;
			if(single.getType() == UnaryType.NUMBER)
			{
				Register reg = reghdlr.getReg();
				asm.add("LI " + reg + ", " + single.getValue());
				return reg;
			}
			return null;
		}
		else if(expr instanceof BinaryOp)
		{
			BinaryOp bop = (BinaryOp) expr;
			Register reg1 = traverseExpression(bop.getLeft());
			Register reg2 = traverseExpression(bop.getRight());
			asm.add("ADD " + reg1 + ", " + reg2);
			reghdlr.free(reg2);
			return reg1;
		}
		return null;
	}
}