package io.github.gokborg.gelang.codegen;

public class RegisterHandler
{
	private Register[] registers = new Register[CodeGeneration.MAX_REGISTERS];
	
	public RegisterHandler()
	{
		for(int i = 0; i < registers.length; i++)
		{
			registers[i] = new Register(i);
		}
	}
	
	public Register getReg()
	{
		for(Register reg : registers)
		{
			if(!reg.isAllocated())
			{
				reg.setAllocated(true);
				return reg;
			}
		}
		return null;
	}
	
	public void free(Register reg)
	{
		if(reg == null) return;
		registers[reg.getAddress()].setAllocated(false);
	}
}
