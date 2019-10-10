package io.github.gokborg.gelang.parser.nodes;

public class Body extends Node
{
	@Override
	public void tree(String prefix, boolean last)
	{
		System.out.println(prefix + "<Body>:" + lineNumber);
	}
}
