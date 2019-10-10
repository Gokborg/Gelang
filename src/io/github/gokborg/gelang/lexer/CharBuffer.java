package io.github.gokborg.gelang.lexer;

public class CharBuffer
{
	private int pointer;
	private String line;
	private boolean isdone;
	private char current;
	
	public void setLine(String line)
	{
		this.line = line;
		pointer = 0;
		isdone = false;
	}
	
	public char getCurrent()
	{
		return current;
	}
	
	public char next()
	{
		if(pointer >= line.length())
		{
			current = '\0';
			isdone = true;
			return '\0';
		}
		current = line.charAt(pointer);
		pointer++;
		return current;
	}

	public boolean isDone()
	{
		return isdone;
	}
}
