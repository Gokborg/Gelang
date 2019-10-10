package io.github.gokborg.gelang.lexer;

import java.util.List;

public class TokenizedLine
{
	private List<Token> tokens;
	private int lineNumber;
	
	public TokenizedLine(int lineNumber, List<Token> tokens)
	{
		this.lineNumber = lineNumber;
		this.tokens = tokens;
	}
	
	public int getLineNumber()
	{
		return lineNumber;
	}
	
	public List<Token> getTokens()
	{
		return tokens;
	}
	
	public String toString()
	{
		String str = "Line: " + lineNumber + "\n";
		for(Token tok : tokens)
		{
			str += "\t" + tok + "\n";
		}
		return str;
	}
}
