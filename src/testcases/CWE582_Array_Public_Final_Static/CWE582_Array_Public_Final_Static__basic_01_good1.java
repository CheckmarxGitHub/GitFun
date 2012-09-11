/*
 * @description A class defines a final static array with public protection.
 * 
 * This is the "good" version, which has a protected final static array.
 * 
 * */

package testcases.CWE582_Array_Public_Final_Static;

import testcasesupport.*;

public class CWE582_Array_Public_Final_Static__basic_01_good1 extends AbstractTestCaseClassIssueGood
{
	protected final static int arrayI[] = {1,2,3,4,5}; /* FIX: protected, final, static */
	
   	private void good1() 
    { 
        CWE582_Array_Public_Final_Static__basic_01_good1 c = new CWE582_Array_Public_Final_Static__basic_01_good1();

        IO.writeLine("arrayI[0]: " + Integer.toString(c.arrayI[0]));
        c.arrayI[0] = 2;
        IO.writeLine("arrayI[0]: " + Integer.toString(c.arrayI[0]));
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
