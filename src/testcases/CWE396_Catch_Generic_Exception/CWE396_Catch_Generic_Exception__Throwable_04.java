/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE396_Catch_Generic_Exception__Throwable_04.java
Label Definition File: CWE396_Catch_Generic_Exception.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 396 An overly broad catch statement may cause errors in program execution if unexpected exceptions are thrown
* Sinks: Throwable
*    GoodSink: Catch specific exception type (NumberFormatException)
*    BadSink : Catch Throwable, which is overly generic
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE396_Catch_Generic_Exception;

import testcasesupport.*;

public class CWE396_Catch_Generic_Exception__Throwable_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        if (private_final_t)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (NumberFormatException e)     /* FIX: Catch NumberFormatException */
            {
                IO.writeLine("Caught Exception");
                throw e; /* Rethrow */
            }

        }
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1() throws Throwable
    {
        if(private_final_f)
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
        else {

            try {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (NumberFormatException e)     /* FIX: Catch NumberFormatException */
            {
                IO.writeLine("Caught Exception");
                throw e; /* Rethrow */
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_t)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (Throwable e)     /* FLAW: Catch Throwable, which is overly generic */
            {
                IO.writeLine("Caught Throwable");
                throw e; /* Rethrow */
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
