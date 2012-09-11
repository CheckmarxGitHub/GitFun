/*
 * @description Unused method parameter value

 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_parameter_value_01 extends AbstractTestCase 
{

	private void helper_bad(int i_bad) {
		/* FLAW: Overwrite the initial value of the parameter variable before use */
		i_bad = 0;
		IO.writeLine("" + i_bad);
	}
	
	public void bad()
    {
		helper_bad(5);
	}
	
	private void helper_good1(int i_good1) {
		/* FIX: Do not overwrite the value of the parameter variable before use */
		IO.writeLine("" + i_good1);
	}
	
	private void good1() 
    {
		helper_good1(10);
	}
    
    public void good()  
    {
        good1();
    }    
	
	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) 
		throws ClassNotFoundException, InstantiationException, IllegalAccessException 
	{
		mainFromParent(args);
	}
}
