/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE396_Catch_Generic_Exception__Throwable_19.java
Label Definition File: CWE396_Catch_Generic_Exception.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 396 An overly broad catch statement may cause errors in program execution if unexpected exceptions are thrown
* Sinks: Throwable
*    GoodSink: Catch specific exception type (NumberFormatException)
*    BadSink : Catch Throwable, which is overly generic
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE396_Catch_Generic_Exception;

import testcasesupport.*;

public class CWE396_Catch_Generic_Exception__Throwable_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            try {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (Throwable e)     /* FLAW: Catch Throwable, which is overly generic */
            {
                IO.writeLine("Caught Throwable");
                throw e; /* Rethrow */
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

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

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
        {

            try {
                Integer.parseInt("Test"); /* Will throw NumberFormatException */
            }
            catch (NumberFormatException e)     /* FIX: Catch NumberFormatException */
            {
                IO.writeLine("Caught Exception");
                throw e; /* Rethrow */
            }

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

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

