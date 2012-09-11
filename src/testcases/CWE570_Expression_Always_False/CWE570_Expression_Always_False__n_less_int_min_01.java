/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.security.SecureRandom;

public class CWE570_Expression_Always_False__n_less_int_min_01 extends AbstractTestCase 
{
    public void bad()
    {
        /* FLAW: always evaluates to false */
        SecureRandom rand = new SecureRandom();
        int n = rand.nextInt();
        if( n < Integer.MIN_VALUE )
        {
            IO.writeLine("never prints");
        }
    }
	
	public void good()
    {
		good1();
	}
	
	private void good1()
    {
        SecureRandom rand = new SecureRandom();
        int n = rand.nextInt();
        /* FIX: may evaluate to true or false */
        if( n < 5000 )
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
