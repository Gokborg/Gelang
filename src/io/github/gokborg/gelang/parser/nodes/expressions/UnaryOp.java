package io.github.gokborg.gelang.parser.nodes.expressions;

import io.github.gokborg.gelang.parser.nodes.Expression;

public class UnaryOp extends Expression
{
	private UnaryType type;
	private String value;
	
	public UnaryOp(UnaryType type, String value)
	{
		this.type = type;
		this.value = value;
	}
	
	public UnaryType getType()
	{
		return type;
	}

	public void setType(UnaryType type)
	{
		this.type = type;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value;
	}
	
	public String toString()
	{
		return type.toString() + "(" + value + ")";
	}
	
	@Override
	public void tree(String prefix, boolean last)
	{
		System.out.println(prefix + toString() + ":" + lineNumber);
	}
}
