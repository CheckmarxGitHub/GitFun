/*
 * @description 
 * Java code makes a call into a potentially unsafe unmanaged DLL.
 * The bad case allows the user to specify the length of the input string.
 * In addition, the case does not recognize the limitations of the unmanaged
 * code and does no input validation.
 * 
 * In order to get this to run, you need to place the JNITest.dll in your
 * Java library path.
 * 
 * */

package testcases.CWE111_Unsafe_JNI;

import testcasesupport.AbstractTestCase;
import testcasesupport.IO;
import java.io.*;

public class CWE111_Unsafe_JNI__console_01 extends AbstractTestCase {

	native String test(String s1, int len);
	
	static 
	{
		try
		{
			System.loadLibrary("JNItest"); /* load JNItest.dll */
		}
		catch(Exception e)
		{
			IO.writeLine("Error when loading the library");
		}
	}
    
    private static java.util.logging.Logger log = java.util.logging.Logger.getLogger("local-logger");
	
	public void bad() throws IOException {
        InputStreamReader inread = null;
        BufferedReader buffread = null;

		int num = 0;
		try
		{
            IO.writeLine("Enter a string: (asdf)" );

            inread = new InputStreamReader(System.in);
            buffread = new BufferedReader(inread);
            
            String text = buffread.readLine();
            
            IO.writeLine("How long was your string? (200) ");
			num = Integer.parseInt(buffread.readLine());
		
            IO.writeLine("Result from native method: " + test(text, num)); /* POTENTIAL FLAW: Passing user input into native methods without validation */
		}
		catch(Exception e)
		{
			IO.writeLine("ERROR!");
			return;
		}
        finally {
            try {
                if( buffread != null ) {
                    buffread.close();
                }
            }
            catch( IOException e ) {
                log.warning("Error closing buffread");
            }
            finally {
                try {
                    if( inread != null ) {
                        inread.close();
                    }
                }
                catch( IOException e ) {
                    log.warning("Error closing inread");
                }
            }
        }
	}

	private void good1() throws IOException {
        InputStreamReader inread = null;
        BufferedReader buffread = null;

		try
		{
            IO.writeLine("Enter a string: (asdf)" );

            inread = new InputStreamReader(System.in);
            buffread = new BufferedReader(inread);
            
            String text = buffread.readLine();
		
            /* FIX: We know the native method is limited to 9 characters plus NULL terminator */
            if (10 > text.length() && text.length() > 0)
            {
                IO.writeLine("Result from native method: " + test(text, text.length()));
            }
            else
            {
                IO.writeLine("ERROR");
            }
		}
		catch(Exception e)
		{
			IO.writeLine("ERROR!");
			return;
		}
        finally {
            try {
                if( buffread != null ) {
                    buffread.close();
                }
            }
            catch( IOException e ) {
                log.warning("Error closing buffread");
            }
            finally {
                try {
                    if( inread != null ) {
                        inread.close();
                    }
                }
                catch( IOException e ) {
                    log.warning("Error closing inread");
                }
            }
        }
	}
    
    public void good() throws IOException {
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
