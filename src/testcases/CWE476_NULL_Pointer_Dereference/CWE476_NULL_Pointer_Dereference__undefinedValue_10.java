/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE476_NULL_Pointer_Dereference__undefinedValue_10.java
Label Definition File: CWE476_NULL_Pointer_Dereference.point.label.xml
Template File: point-flaw-10.tmpl.java
*/
/*
* @description
* CWE: 476 Null Pointer Dereference
* Sinks: undefinedValue
*    GoodSink: checks for null before accessing the variable
*    BadSink : assumes the variable has been defined
* Flow Variant: 10 Control flow: if(IO.static_t) and if(IO.static_f)
*
* */

package testcases.CWE476_NULL_Pointer_Dereference;

import testcasesupport.*;

import java.io.*;

public class CWE476_NULL_Pointer_Dereference__undefinedValue_10 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_t)
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
        }
        else {
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

        }
    }

    /* good1() changes IO.static_t to IO.static_f */
    private void good1() throws Throwable
    {
        if(IO.static_f)
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
        }
        else {

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

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_t)
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
        }
        else {
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
