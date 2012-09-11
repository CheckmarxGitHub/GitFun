/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE395_NullPointerException_Catch__basic_08.java
Label Definition File: CWE395_NullPointerException_Catch__basic.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 395 An object may be null when asked to perform a method; a catch block for NullPointerException is used instead of checking for null objects in the code
* Sinks:
*    GoodSink: check for null reference before taking action
*    BadSink : using catch to detect null references
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE395_NullPointerException_Catch;

import testcasesupport.*;

import java.io.*;

public class CWE395_NullPointerException_Catch__basic_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (private_returns_t())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /* This code could be a part of a user questionnaire */
            String address = null;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                IO.writeLine("Do you know your forwarding address (y/n)? ");
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                if (bufread2.readLine().equalsIgnoreCase("y"))
                {
                    IO.writeLine("Enter your forwarding address: ");
                    inread2 = new InputStreamReader(System.in);
                    bufread2 = new BufferedReader(inread2);
                    address = bufread2.readLine();
                }
                IO.writeLine("bad() - address length = " + address.length()); /* INCIDENTAL: CWE476 Null Pointer Dereference */
            }
            catch (NullPointerException npe)  /* FLAW: Use of catch block to detect null dereferences */
            {
                IO.writeLine(npe.getMessage());
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

            /* This code could be a part of a user questionnaire */
            String address = null;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;

            try {
                IO.writeLine("Do you know your forwarding address (y/n)? ");
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);

                if (bufread2.readLine().equalsIgnoreCase("y"))
                {
                    IO.writeLine("Enter your forwarding address: ");
                    inread2 = new InputStreamReader(System.in);
                    bufread2 = new BufferedReader(inread2);
                    address = bufread2.readLine();
                }
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

            if (address != null) /* FIX: Check for null value before calling a method */
            {
                IO.writeLine("good() - address length = " + address.length());
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /* This code could be a part of a user questionnaire */
            String address = null;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                IO.writeLine("Do you know your forwarding address (y/n)? ");
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                if (bufread2.readLine().equalsIgnoreCase("y"))
                {
                    IO.writeLine("Enter your forwarding address: ");
                    inread2 = new InputStreamReader(System.in);
                    bufread2 = new BufferedReader(inread2);
                    address = bufread2.readLine();
                }
                IO.writeLine("bad() - address length = " + address.length()); /* INCIDENTAL: CWE476 Null Pointer Dereference */
            }
            catch (NullPointerException npe)  /* FLAW: Use of catch block to detect null dereferences */
            {
                IO.writeLine(npe.getMessage());
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

            /* This code could be a part of a user questionnaire */
            String address = null;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;

            try {
                IO.writeLine("Do you know your forwarding address (y/n)? ");
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);

                if (bufread2.readLine().equalsIgnoreCase("y"))
                {
                    IO.writeLine("Enter your forwarding address: ");
                    inread2 = new InputStreamReader(System.in);
                    bufread2 = new BufferedReader(inread2);
                    address = bufread2.readLine();
                }
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

            if (address != null) /* FIX: Check for null value before calling a method */
            {
                IO.writeLine("good() - address length = " + address.length());
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            /* This code could be a part of a user questionnaire */
            String address = null;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                IO.writeLine("Do you know your forwarding address (y/n)? ");
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                if (bufread2.readLine().equalsIgnoreCase("y"))
                {
                    IO.writeLine("Enter your forwarding address: ");
                    inread2 = new InputStreamReader(System.in);
                    bufread2 = new BufferedReader(inread2);
                    address = bufread2.readLine();
                }
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
            if (address != null) /* FIX: Check for null value before calling a method */
            {
                IO.writeLine("good() - address length = " + address.length());
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");

            /* This code could be a part of a user questionnaire */
            String address = null;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;

            try {
                IO.writeLine("Do you know your forwarding address (y/n)? ");
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);

                if (bufread2.readLine().equalsIgnoreCase("y"))
                {
                    IO.writeLine("Enter your forwarding address: ");
                    inread2 = new InputStreamReader(System.in);
                    bufread2 = new BufferedReader(inread2);
                    address = bufread2.readLine();
                }

                IO.writeLine("bad() - address length = " + address.length()); /* INCIDENTAL: CWE476 Null Pointer Dereference */
            }
            catch (NullPointerException npe)  /* FLAW: Use of catch block to detect null dereferences */
            {
                IO.writeLine(npe.getMessage());
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
