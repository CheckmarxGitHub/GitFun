/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE396_Catch_Generic_Exception__Throwable_17.java
Label Definition File: CWE396_Catch_Generic_Exception.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 396 An overly broad catch statement may cause errors in program execution if unexpected exceptions are thrown
* Sinks: Throwable
*    GoodSink: Catch specific exception type (NumberFormatException)
*    BadSink : Catch Throwable, which is overly generic
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE396_Catch_Generic_Exception;

import testcasesupport.*;

public class CWE396_Catch_Generic_Exception__Throwable_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            try
            {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (Throwable e)     /* FLAW: Catch Throwable, which is overly generic */
            {
                IO.writeLine("Caught Throwable");
                throw e; /* Rethrow */
            }
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (NumberFormatException e)     /* FIX: Catch NumberFormatException */
            {
                IO.writeLine("Caught Exception");
                throw e; /* Rethrow */
            }
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (Throwable e)     /* FLAW: Catch Throwable, which is overly generic */
            {
                IO.writeLine("Caught Throwable");
                throw e; /* Rethrow */
            }
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
        {
            try
            {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (NumberFormatException e)     /* FIX: Catch NumberFormatException */
            {
                IO.writeLine("Caught Exception");
                throw e; /* Rethrow */
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
