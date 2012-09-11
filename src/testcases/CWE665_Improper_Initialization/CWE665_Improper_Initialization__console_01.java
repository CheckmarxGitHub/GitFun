/*
 * @description reliance on incorrectly set boolean field results in incomplete initialization
 *
 * */

package testcases.CWE665_Improper_Initialization;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE665_Improper_Initialization__console_01 extends
		AbstractTestCase 
{

	public class BadClass
	{
		private boolean initialized = true; /* FLAW: This should be false to avoid incomplete initalization */
		
		public BadClass()
		{
			initialize();
		}
		
		public void initialize()
		{
			if (!initialized)
			{
				IO.writeLine("Initializing...");
				initialized = true;
			}
				
		}
		
		public boolean isInitialized()
		{
			return initialized;
		}
	}
	
	public class GoodClass
	{
		private boolean initialized = false; /* FIX: correctly marked false */
		
		public GoodClass()
		{
			initialize();
		}
		
		public void initialize()
		{
			if (!initialized)
			{
				IO.writeLine("Initializing...");
				initialized = true;
			}
				
		}
		
		public boolean isInitialized()
		{
			return initialized;
		}
	}
	
	public void bad() 
    {
		BadClass b = new BadClass();
		
		IO.writeLine("Initialized? " + b.isInitialized());
	}

	private void good1() 
    {
		GoodClass c = new GoodClass();
		IO.writeLine("Initialized? " + c.isInitialized());

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
