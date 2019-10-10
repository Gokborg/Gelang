package io.github.gokborg.gelang.parser.nodes;

public abstract class Expression extends Node
{
	public abstract String toString();
	
	@Override
	public void tree(String prefix, boolean last)
	{
		System.out.println(prefix + "<Expression>:" + lineNumber);
	}
}
