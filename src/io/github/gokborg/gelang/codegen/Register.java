package io.github.gokborg.gelang.codegen;

public class Register
{
	private int value, address;
	private boolean allocated = false;
	
	public Register(int address)
	{
		this.address = address;
	}
	
	public int getAddress()
	{
		return address;
	}
	
	public int getValue()
	{
		return value;
	}
	
	public void setAllocated(boolean allocated)
	{
		this.allocated = allocated;
	}
	
	public boolean isAllocated()
	{
		return allocated;
	}
	
	public String toString()
	{
		return "r" + address;
	}
}
