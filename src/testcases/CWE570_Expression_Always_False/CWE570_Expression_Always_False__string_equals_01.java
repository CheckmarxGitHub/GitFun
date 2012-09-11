/*
 * @description statement always evaluates to false
 * 
 * */
package testcases.CWE570_Expression_Always_False;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class CWE570_Expression_Always_False__string_equals_01 extends AbstractTestCase 
{
    public void bad()
    {
        String f = "false";
        /* FLAW: always evaluates to false */
        if( f.equals("true") )
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
        java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

        String f = "";
        IO.writeLine("Enter a string: ");
        boolean errored = false;
        
        BufferedReader bufread2 = null;
        InputStreamReader inread2 = null;
        try
        {
            inread2 = new InputStreamReader(System.in);
            bufread2 = new BufferedReader(inread2);
            f = bufread2.readLine();
        }
        catch( IOException e )
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
        /* FIX: may evaluate to true or false */
        if( f.contentEquals("true") )
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
