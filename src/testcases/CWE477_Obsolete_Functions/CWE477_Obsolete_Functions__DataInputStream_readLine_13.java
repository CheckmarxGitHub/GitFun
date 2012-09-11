/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__DataInputStream_readLine_13.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-13.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: DataInputStream_readLine
*    GoodSink: Use of prefered java.io.BufferedReader(InputStreamReader)
*    BadSink : Use of deprecated java.io.DataInputStream.readLine() method
* Flow Variant: 13 Control flow: if(IO.static_final_five==5) and if(IO.static_final_five!=5)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.*;
import java.text.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__DataInputStream_readLine_13 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_final_five==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* good1() changes IO.static_final_five==5 to IO.static_final_five!=5 */
    private void good1() throws Throwable
    {
        if(IO.static_final_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_final_five==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    }

    public void good() throws Throwable
    {
        good1();
        good2();
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
