package io.github.gokborg.gelang.lexer;

import java.util.ArrayList;
import java.util.List;

public class Lexer
{
	private CharBuffer buf = new CharBuffer();
	
	public List<TokenizedLine> lex(String[] lines)
	{
		List<TokenizedLine> tokLines = new ArrayList<>();
		for(int i = 0; i < lines.length; i++)
		{
			buf.setLine(lines[i]);
			List<Token> toks = new ArrayList<>();
			while(!buf.isDone())
			{
				if(Character.isDigit(buf.getCurrent()))
				{
					toks.add(new Token(TokenType.NUMBER, lexNumber()));
				}
				else if(buf.getCurrent() == '+')
				{
					toks.add(new Token(TokenType.PLUS, "+"));
					buf.next();
				}
				else if(buf.getCurrent() == '-')
				{
					toks.add(new Token(TokenType.MINUS, "-"));
					buf.next();
				}
				else
				{
					buf.next();
				}
			}
			tokLines.add(new TokenizedLine(i, toks));
		}
		for(TokenizedLine tl : tokLines)
		{
			System.out.print(tl);
		}
		return tokLines;
	}
	
	private String lexNumber()
	{
		String number = "" + buf.getCurrent();
		while(Character.isDigit(buf.next()))
		{
			number += buf.getCurrent();
		}
		return number;
	}
}
