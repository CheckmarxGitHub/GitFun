/*
 * @description statement always evaluates to true
 * 
 * */
package testcases.CWE571_Expression_Always_True;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;

public class CWE571_Expression_Always_True__n_equal_m_minus_one_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to true */
        int n = 30;
        int m = 31;
        if( n == (m - 1) )
        {
            IO.writeLine("always prints");
        }
    }
	
	public void good()
    {
		good1();
	}
	
	private void good1()
    {
        /* FIX: may evaluate to true or false */
        SecureRandom rand = new SecureRandom();
        int n = rand.nextInt();
        int m = rand.nextInt();
        if( n != m )
        {
            IO.writeLine("sometimes prints");
        }
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
