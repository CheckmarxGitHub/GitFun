/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE484_Omitted_Break_Statement__basic_14.java
Label Definition File: CWE484_Omitted_Break_Statement__basic.label.xml
Template File: point-flaw-14.tmpl.java
*/
/*
* @description
* CWE: 484 Omitted Break Statement
* Sinks:
*    GoodSink: no missing break
*    BadSink : missing break
* Flow Variant: 14 Control flow: if(IO.static_five==5) and if(IO.static_five!=5)
*
* */

package testcases.CWE484_Omitted_Break_Statement;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE484_Omitted_Break_Statement__basic_14 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_five==5)
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            int num = 0;
            IO.writeLine("Enter a number: ");
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                num = Integer.parseInt(bufread2.readLine());
                IO.writeLine("bad(): ");
            }
            catch( IOException e )
            {
                num = 0;
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
            switch (num)
            {
            case 1:
                IO.writeLine("one");
                break;
            case 2:
                IO.writeLine("two"); /* FLAW: Case 2 is missing a break statement */
            default:
                IO.writeLine("Invalid number entered!");
                break;
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            int num = 0;

            IO.writeLine("Enter a number: ");
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                num = Integer.parseInt(bufread2.readLine());
                IO.writeLine("bad(): ");
            }
            catch( IOException e )
            {
                num = 0;
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

            switch (num)
            {
            case 1:
                IO.writeLine("one");
                break;
            case 2:
                IO.writeLine("two");
                break; /* FIX: Case 2 has a break statement */
            default:
                IO.writeLine("Invalid number entered!");
                break;
            }

        }
    }

    /* good1() changes IO.static_five==5 to IO.static_five!=5 */
    private void good1() throws Throwable
    {
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            int num = 0;
            IO.writeLine("Enter a number: ");
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                num = Integer.parseInt(bufread2.readLine());
                IO.writeLine("bad(): ");
            }
            catch( IOException e )
            {
                num = 0;
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
            switch (num)
            {
            case 1:
                IO.writeLine("one");
                break;
            case 2:
                IO.writeLine("two"); /* FLAW: Case 2 is missing a break statement */
            default:
                IO.writeLine("Invalid number entered!");
                break;
            }
        }
        else {

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            int num = 0;

            IO.writeLine("Enter a number: ");
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                num = Integer.parseInt(bufread2.readLine());
                IO.writeLine("bad(): ");
            }
            catch( IOException e )
            {
                num = 0;
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

            switch (num)
            {
            case 1:
                IO.writeLine("one");
                break;
            case 2:
                IO.writeLine("two");
                break; /* FIX: Case 2 has a break statement */
            default:
                IO.writeLine("Invalid number entered!");
                break;
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_five==5)
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            int num = 0;
            IO.writeLine("Enter a number: ");
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                num = Integer.parseInt(bufread2.readLine());
                IO.writeLine("bad(): ");
            }
            catch( IOException e )
            {
                num = 0;
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
            switch (num)
            {
            case 1:
                IO.writeLine("one");
                break;
            case 2:
                IO.writeLine("two");
                break; /* FIX: Case 2 has a break statement */
            default:
                IO.writeLine("Invalid number entered!");
                break;
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            int num = 0;

            IO.writeLine("Enter a number: ");
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                num = Integer.parseInt(bufread2.readLine());
                IO.writeLine("bad(): ");
            }
            catch( IOException e )
            {
                num = 0;
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

            switch (num)
            {
            case 1:
                IO.writeLine("one");
                break;
            case 2:
                IO.writeLine("two"); /* FLAW: Case 2 is missing a break statement */
            default:
                IO.writeLine("Invalid number entered!");
                break;
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
