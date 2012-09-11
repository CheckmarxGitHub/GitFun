/*
 * @description Improper Resource Shutdown.  Performs some, but not all, necessary resource cleanup (FileReader is not closed).
 * 
 * */

package testcases.CWE404_Improper_Resource_Shutdown;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;

public class CWE404_Improper_Resource_Shutdown__FileReader_01
		extends AbstractTestCase 
{	
    private static java.util.logging.Logger log = java.util.logging.Logger.getLogger("local-logger");
    
	public void bad() throws IOException 
	{
		BufferedReader buffread = null;
		FileReader fread = null;
		try
		{
			File f = new File("c:\\file.txt");
			fread = new FileReader(f);
			buffread = new BufferedReader(fread);
	        String readString = buffread.readLine();
	        
	        IO.writeLine(readString);
		}
		catch(Exception e)
		{
            log.warning("Error!");
		}
		finally
		{
            try
            {
                if (buffread != null)
                {
                    buffread.close();
                }
            }
            catch( Exception e )
            {
                log.warning("Error closing buffread");
            }
			
			/* FLAW: FileReader not closed */
			
		}
	}
	
	private void good1() throws IOException 
	{		
		BufferedReader buffread = null;
		FileReader fread = null;
		try
		{
			File f = new File("c:\\file.txt");
			fread = new FileReader(f);
			buffread = new BufferedReader(fread);
	        String readString = buffread.readLine();
	        
	        IO.writeLine(readString);
		}
		catch(Exception e)
		{
            log.warning("Error!");
		}
		finally
		{
            try
            {
                if (buffread != null)
                {
                    buffread.close();
                }
            }
            catch( Exception e )
            {
                log.warning("Error closing buffread");
            }
			
			/* FIX: FileReader closed appropriately */
			finally
			{
				try {
					if( fread != null ) {
						fread.close();
					}
				}
				catch( IOException ioe ) {
					log.warning("Error closing fread");
				}
			}
		}
	}
	
	public void good() throws IOException 
	{
        good1();
    }

	/* Below is the main(). It is only used when building this testcase on 
	   its own for testing or for building a binary to use in testing binary 
	   analysis tools. It is not used when compiling all the testcases as one 
	   application, which is how source code analysis tools are tested. */ 
	public static void main(String[] args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		mainFromParent(args);
	}
}
