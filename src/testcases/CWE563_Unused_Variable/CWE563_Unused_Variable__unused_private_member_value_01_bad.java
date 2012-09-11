/*
 * @description Unused private class member value
 * 
 * */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

public class CWE563_Unused_Variable__unused_private_member_value_01_bad extends AbstractTestCaseClassIssueBad 
{
	
	private int i_bad = 5; /* This value of i_bad is never used */

	public void bad() {	
		/* FLAW: Set i_bad to a new value before using it */
		i_bad = 10;
		IO.writeLine(""+i_bad);
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
