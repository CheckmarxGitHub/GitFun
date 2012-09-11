/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE484_Omitted_Break_Statement__basic_05.java
Label Definition File: CWE484_Omitted_Break_Statement__basic.label.xml
Template File: point-flaw-05.tmpl.java
*/
/*
* @description
* CWE: 484 Omitted Break Statement
* Sinks:
*    GoodSink: no missing break
*    BadSink : missing break
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE484_Omitted_Break_Statement;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE484_Omitted_Break_Statement__basic_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        if (private_t)
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

    /* good1() changes private_t to private_f */
    private void good1() throws Throwable
    {
        if(private_f)
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
        if(private_t)
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
