/*
 * @description demonstrates bad nonreentrant pattern.
 * 
 * */

package testcases.CWE663_Use_Non_Reentrant_Function_Unsync;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import testcasesupport.AbstractTestCaseClassIssueBad;
import testcasesupport.IO;

public class CWE663_Use_Non_Reentrant_Function_Unsync__console_reentrantlock_01_bad
		extends AbstractTestCaseClassIssueBad 
{

	int test = 0;
	
	private int bad_nonreentrant(int inte) /* FLAW: no locking */
	{
		test = inte * 2;
		return test;
	}
	
	public void bad() throws Throwable 
    {
        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;
        boolean errored = false;
        try
        {
            inread2 = new InputStreamReader(System.in);
            bufread2 = new BufferedReader(inread2);

            String convertme = bufread2.readLine();
	    
            int integer = 0;
            try
            {
                integer = Integer.parseInt(convertme);
            }
            catch(Exception e)
            {
                IO.writeLine("Error, thats not a number");
                errored = true;
            }
            
            IO.writeLine("" + bad_nonreentrant(integer));
        }
        catch( Exception e )
        {
            log2.warning("Error!");
        }
        finally 
        {
            try 
            {
                if( bufread2 != null ) 
                {
                    bufread2.close();
                }
            }
            catch( IOException e )
            {
                log2.warning("Error closing bufread2");
                errored = true;
            }
            finally 
            {
                try 
                {
                    if( inread2 != null ) 
                    {   
                        inread2.close();
                    }
                }
                catch( IOException e )
                {
                    log2.warning("Error closing inread2");
                }
                
                if( errored ) { return; }
            }
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
