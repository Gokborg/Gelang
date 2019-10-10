package io.github.gokborg.gelang.parser.nodes.expressions;

import io.github.gokborg.gelang.parser.nodes.Expression;

public class BinaryOp extends Expression
{
	private OperationType op;
	private Expression left;
	private Expression right;
	
	public BinaryOp(OperationType op, Expression left, Expression right)
	{
		this.op = op;
		this.left = left;
		this.right = right;
	}
	
	public BinaryOp(OperationType op)
	{
		this.op = op;
	}
	
	public BinaryOp()
	{
		// TODO Auto-generated constructor stub
	}

	public OperationType getOp()
	{
		return op;
	}

	public void setOp(OperationType op)
	{
		this.op = op;
	}

	public Expression getLeft()
	{
		return left;
	}

	public void setLeft(Expression left)
	{
		this.left = left;
	}

	public Expression getRight()
	{
		return right;
	}

	public void setRight(Expression right)
	{
		this.right = right;
	}
	
	public String toString()
	{
		return "BinaryOp(" + left + " " + op.toString() + " " + right + ")";
	}
	
	@Override
	public void tree(String prefix, boolean last)
	{
		System.out.println(prefix + op.toString() + ":" + lineNumber);
		if(last)
		{
			prefix = prefix.substring(0, prefix.length() - 2) + "  ";
		}
		left.tree(prefix + "├─", false);
		right.tree(prefix + "└─", true);
	}
}
