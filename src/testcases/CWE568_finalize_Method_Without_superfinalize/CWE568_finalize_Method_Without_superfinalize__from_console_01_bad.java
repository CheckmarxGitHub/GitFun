/*
 * @description protected finalize method does not call super.finalize()
 * 
 * */
package testcases.CWE568_finalize_Method_Without_superfinalize;

import testcasesupport.AbstractTestCaseClassIssueBad;
import testcasesupport.IO;

public class CWE568_finalize_Method_Without_superfinalize__from_console_01_bad
		extends AbstractTestCaseClassIssueBad 
{

	public class TestObject 
    {
		/* The finalize method of built-in Java objects are hidden, so a custom object is used instead.
		 * Alternative to extend an object like FileInputStream and invoke the finalize() method from within
		 * by overriding the close() method. e.g. super.finalize()
		 */
		private String msg;
		
		public TestObject() 
        {
			this.msg = new String("hello world");
		}
		
		public void sayHello() 
        {
			IO.writeLine(this.msg);
		}
		
		protected void finalize() 
        {
			try
			{
				IO.writeLine("finalizing TestObject");
			}
			finally
			{
				try
				{
					super.finalize();
				}
				catch(Throwable t)
				{
					IO.writeLine("caught an exception calling super.finalize() from the TestObject");
				}
			}
		}
	}
	
	public class BadObject extends TestObject 
    {
		
		protected void finalize() 
        {
			/* FLAW: missing super.finalize in this overridden method will cause a memory leak 
			 * when the GC attempts to perform cleanup. */
			IO.writeLine("finalizing BadObject");
		}
	}
	
	public void bad() throws Throwable 
    {
		BadObject badObj = new BadObject();
		try
        {
			badObj.sayHello();
		} 
        catch (Exception e) 
        {
			IO.writeLine("An error occurred.");
		} 
        finally 
        {
			/* cleanup */
			badObj = null;
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
