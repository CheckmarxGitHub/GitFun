/*
 * @description demonstrates good nonreentrant pattern using ReentrantLock.
 * 
 * */

package testcases.CWE663_Use_Non_Reentrant_Function_Unsync;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.locks.ReentrantLock;

import testcasesupport.AbstractTestCaseClassIssueGood;
import testcasesupport.IO;

public class CWE663_Use_Non_Reentrant_Function_Unsync__console_reentrantlock_01_good1
		extends AbstractTestCaseClassIssueGood 
{

	int test = 0;
	private final ReentrantLock lock = new ReentrantLock();
	
	private int good_nonreentrant(int inte)
	{
		/* FIX: locking done properly */
		lock.lock();
		try
		{
			test = inte *2;
		}
		catch(Exception e)
		{
			IO.writeLine("An error occurred when assigning test");
		}
		finally
		{
			lock.unlock();
		}
		
		return test;
	}
	
	public void good() throws Throwable 
    {
		good1();
	}
	
	private void good1() throws IOException
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
            
            IO.writeLine("" + good_nonreentrant(integer));
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
