/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE597_Wrong_Operator_String_Comparison__basic_12.java
Label Definition File: CWE597_Wrong_Operator_String_Comparison__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 597 Use of '==' instead of 'equals()' to test String equivalence
* Sinks:
*    GoodSink: Correctly use .equals() to compare strings
*    BadSink : Use == operator instead of .equals() to compare strings
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE597_Wrong_Operator_String_Comparison;

import testcasesupport.*;

import java.io.*;

public class CWE597_Wrong_Operator_String_Comparison__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                /* output comparison results */
                if (str1 == str2) 	/* FLAW: using == operator instead of .equals() object method */
                {
                    System.out.println("bad(): Strings are equal");
                }
                else
                {
                    System.out.println("bad(): Strings are not equal"); /* This will always display */
                }
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
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);

                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();

                /* output comparison */
                if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                {
                    System.out.println("good(): Strings are equal");
                }
                else
                {
                    System.out.println("good(): Strings are not equal");
                }
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
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();
                /* output comparison */
                if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                {
                    System.out.println("good(): Strings are equal");
                }
                else
                {
                    System.out.println("good(): Strings are not equal");
                }
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
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);

                /* read user input from console */
                IO.writeLine("Enter string1: "); /* enter "test" */
                String str1 = bufread2.readLine();
                IO.writeLine("Enter string2: "); /* enter "test" */
                String str2 = bufread2.readLine();

                /* output comparison */
                if (str1.equals(str2))  /* FIX: use of equals() instead of == operator */
                {
                    System.out.println("good(): Strings are equal");
                }
                else
                {
                    System.out.println("good(): Strings are not equal");
                }
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
