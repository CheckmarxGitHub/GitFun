/*
 * @description Declare that the function throws "Exception" rather than a specific exception.  In this test case, we don't actually throw an exception to differentiate it from other test cases.
 *
 * */


package testcases.CWE397_Throw_Generic_Exception;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.io.FileNotFoundException;


public class CWE397_Throw_Generic_Exception__declare_Exception_01 extends AbstractTestCase 
{
	public void bad() throws Exception /* FLAW: Method is declared as throwing Exception, which is very generic */ 
	{
		IO.writeLine("Test"); /* Do something, but don't throw an exception */
	}

	private void good1() throws FileNotFoundException /* FIX: Declare that method throws a specific exception */
	{
		IO.writeLine("Test"); /* Do something, but don't throw an exception */
	}
    
	public void good() throws FileNotFoundException
	{
        good1();
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
