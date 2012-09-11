/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE396_Catch_Generic_Exception__Throwable_08.java
Label Definition File: CWE396_Catch_Generic_Exception.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 396 An overly broad catch statement may cause errors in program execution if unexpected exceptions are thrown
* Sinks: Throwable
*    GoodSink: Catch specific exception type (NumberFormatException)
*    BadSink : Catch Throwable, which is overly generic
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE396_Catch_Generic_Exception;

import testcasesupport.*;

public class CWE396_Catch_Generic_Exception__Throwable_08 extends AbstractTestCase
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

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
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
        if(private_returns_t())
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
