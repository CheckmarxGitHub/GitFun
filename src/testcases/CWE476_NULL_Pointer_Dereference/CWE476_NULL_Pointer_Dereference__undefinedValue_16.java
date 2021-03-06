/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__undefinedValue_16.java
Label Definition File: CWE476_NULL_Pointer_Dereference.point.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* Sinks: undefinedValue
*    GoodSink: checks for null before accessing the variable
*    BadSink : assumes the variable has been defined
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

import java.io.*;

public class CWE476_NULL_Pointer_Dereference__undefinedValue_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            IO.writeLine("Enter index: ");
            int index = 0;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                index = Integer.parseInt(bufread2.readLine());
            }
            catch(Exception e)
            {
                /* default index of 0 */
                index = 0;
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
            String[] a = {null, new String(), new String(), new String(), "test"};
            IO.writeLine(a[index].toString()); /* FLAW: Neither user supplied index or contents are verified */
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            IO.writeLine("Enter start index: ");
            int index = 0;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                index = Integer.parseInt(bufread2.readLine());
            }
            catch(Exception e)
            {
                /* default index of 0 */
                index = 0;
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
            String[] a = {null, new String(), new String(), new String(), "test"};
            if(index >= 0 && index < a.length) /* FIX: validates specified index is within range */
            {
                if(a[index] == null) /* FIX: validates contents of specified index are not null */
                {
                    IO.writeLine("object is null");
                }
                else
                {
                    IO.writeLine(a[index].toString());
                }
            }
            else
            {
                IO.writeLine("invalid index specified. Please specify a value in the range {0," + a.length + "}.");
            }
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            IO.writeLine("Enter index: ");
            int index = 0;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                index = Integer.parseInt(bufread2.readLine());
            }
            catch(Exception e)
            {
                /* default index of 0 */
                index = 0;
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
            String[] a = {null, new String(), new String(), new String(), "test"};
            IO.writeLine(a[index].toString()); /* FLAW: Neither user supplied index or contents are verified */
            break;
        }

        while(true)
        {
            java.util.logging.Logger log2 = java.util.logging.Logger.getLogger("local-logger");
            IO.writeLine("Enter start index: ");
            int index = 0;
            BufferedReader bufread2 = null;
            InputStreamReader inread2 = null;
            try
            {
                inread2 = new InputStreamReader(System.in);
                bufread2 = new BufferedReader(inread2);
                index = Integer.parseInt(bufread2.readLine());
            }
            catch(Exception e)
            {
                /* default index of 0 */
                index = 0;
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
            String[] a = {null, new String(), new String(), new String(), "test"};
            if(index >= 0 && index < a.length) /* FIX: validates specified index is within range */
            {
                if(a[index] == null) /* FIX: validates contents of specified index are not null */
                {
                    IO.writeLine("object is null");
                }
                else
                {
                    IO.writeLine(a[index].toString());
                }
            }
            else
            {
                IO.writeLine("invalid index specified. Please specify a value in the range {0," + a.length + "}.");
            }
            break;
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
