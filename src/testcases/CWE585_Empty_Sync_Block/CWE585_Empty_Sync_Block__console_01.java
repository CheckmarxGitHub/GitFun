/*
 * @description The bad case has an empty synchronized block.
 * 
 * */

package testcases.CWE585_Empty_Sync_Block;

import testcasesupport.AbstractTestCase;

public class CWE585_Empty_Sync_Block__console_01 extends AbstractTestCase 
{
	private static int shared = 0;
	
	public void bad() 
    {
		synchronized(this)
		{
			/* FLAW: empty */
		}
	}

	private void good1() 
    {
		synchronized(CWE585_Empty_Sync_Block__console_01.class)
		{
			shared++; /* FIX: non-empty */
		}
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
