package io.github.gokborg.gelang.parser.nodes;

public abstract class Node
{
	public int lineNumber;

	public void tree(String prefix, boolean last)
	{
		System.out.println(prefix + "<Node>:" + lineNumber);
	}
}
