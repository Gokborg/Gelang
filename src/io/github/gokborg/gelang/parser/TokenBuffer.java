package io.github.gokborg.gelang.parser;

import java.util.List;

import io.github.gokborg.gelang.lexer.Token;
import io.github.gokborg.gelang.lexer.TokenType;

public class TokenBuffer
{
	private List<Token> tokens;
	private Token current;
	private int pointer;
	private boolean isdone;
	private final Token NONE = new Token(TokenType.NONE, "\0");
	
	public void setTokens(List<Token> tokens)
	{
		this.tokens = tokens;
		pointer = 0;
		isdone = false;
	}
	
	public Token peekBack(int num)
	{
		int index = pointer - num;
		if(index <= 0)
		{
			return NONE;
		}
		return tokens.get(index);
	}
	
	public Token peekBack()
	{
		if(pointer <= 0)
		{
			return NONE;
		}
		return tokens.get(pointer-1);
	}
	
	public Token next()
	{
		if(pointer >= tokens.size())
		{
			isdone = true;
			current = NONE;
		}
		else
		{
			current = tokens.get(pointer);
			pointer++;
		}
		return current;
	}
	
	public Token getCurrent()
	{
		return current;
	}
	
	public boolean isDone()
	{
		return isdone;
	}
}
