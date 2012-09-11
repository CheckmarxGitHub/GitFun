/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__DataInputStream_readLine_12.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: DataInputStream_readLine
*    GoodSink: Use of prefered java.io.BufferedReader(InputStreamReader)
*    BadSink : Use of deprecated java.io.DataInputStream.readLine() method
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.*;
import java.text.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__DataInputStream_readLine_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            DataInputStream dis = null;
            try
            {
                /* FLAW: Use of deprecated DataInputStream.readLine() method */
                dis = new DataInputStream(System.in);
                String cmd = dis.readLine();
            }
            catch( Exception e )
            {
                log2.warning("Error reading from console");
            }
            finally
            {
                try
                {
                    if( dis != null )
                    {
                        dis.close();
                    }
                }
                catch(IOException e)
                {
                    log2.warning("Error closing dis");
                }
            }
        }
        else {

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                /* FIX: Use prefered BufferedReader(InputStreamReader) constructor */
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String cmd = bufread2.readLine();
            }
            catch( Exception e )
            {
                log2.warning("Error reading from console");
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
                }
            }

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                /* FIX: Use prefered BufferedReader(InputStreamReader) constructor */
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String cmd = bufread2.readLine();
            }
            catch( Exception e )
            {
                log2.warning("Error reading from console");
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
                }
            }
        }
        else {

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                /* FIX: Use prefered BufferedReader(InputStreamReader) constructor */
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                String cmd = bufread2.readLine();
            }
            catch( Exception e )
            {
                log2.warning("Error reading from console");
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
                }
            }

        }
    }

    public void good() throws Throwable
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
