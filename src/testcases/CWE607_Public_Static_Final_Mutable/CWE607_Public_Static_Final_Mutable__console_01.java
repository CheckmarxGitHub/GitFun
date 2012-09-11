/*
 * @description The bad case doesn't perform a deep copy, so the caller can modify 
 * the value inside the class. The caller should not be able to do this since its 
 * marked public final static.
 * 
 * */

package testcases.CWE607_Public_Static_Final_Mutable;

import java.util.Calendar;
import java.util.Date;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE607_Public_Static_Final_Mutable__console_01 extends AbstractTestCase 
{
	static class BadClass
	{
		public final static Date date = new Date();
		
		public String getHello()
		{
			return "Hello!" + date.getTime();
		}
		
		public Date getDate()
		{
			return date; /* FLAW: reference returned */
		}
	}
	
	static class GoodClass
	{
		private final static Date date = new Date();
		
		public String getHello()
		{
			return "Hello!" + date.getTime();
		}
		
		public final Date getDate()
		{
			return (Date) date.clone(); /* FIX: Do a deep copy */
		}
	}
	
	public void bad() 
    {
		BadClass b = new BadClass();
		
		IO.writeLine("Before: " + b.getHello());
		
		Calendar c = Calendar.getInstance();
		c.set(2020, 01, 01);
		
		b.getDate().setTime(c.getTimeInMillis());
		
		IO.writeLine("After: " + b.getHello());
	}

	public void good() 
    {
		GoodClass c = new GoodClass();
		
		IO.writeLine("Before: " + c.getHello());
		
		Calendar cc = Calendar.getInstance();
		cc.set(2020, 01, 01);
		
		c.getDate().setTime(cc.getTimeInMillis());
		
		IO.writeLine("After: " + c.getHello());
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
