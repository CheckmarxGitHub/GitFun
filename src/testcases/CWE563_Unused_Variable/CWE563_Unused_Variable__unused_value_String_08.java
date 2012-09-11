/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE563_Unused_Variable__unused_value_String_08.java
Label Definition File: CWE563_Unused_Variable__unused_value.label.xml
Template File: sources-sinks-08.tmpl.java
*/
/*
* @description
* CWE: 563 Unused Variable
* BadSource:  Initialize data
* GoodSource: Initialize and use data
* Sinks:
*    GoodSink: Use data
*    BadSink : re-initialize and use data
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE563_Unused_Variable;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE563_Unused_Variable__unused_value_String_08 extends AbstractTestCase
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
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = "Good";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Initialize and use data before it is overwritten */
            data = "Good";

            IO.writeLine(data);

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = "Reinitialize";
            IO.writeLine(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use data without over-writing its value */
            IO.writeLine(data);

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_returns_t() to private_returns_f() */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = "Good";
        }
        else {

            /* FIX: Initialize and use data before it is overwritten */
            data = "Good";

            IO.writeLine(data);

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = "Reinitialize";
            IO.writeLine(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use data without over-writing its value */
            IO.writeLine(data);

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* FIX: Initialize and use data before it is overwritten */
            data = "Good";
            IO.writeLine(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = "Good";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = "Reinitialize";
            IO.writeLine(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use data without over-writing its value */
            IO.writeLine(data);

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_returns_t() to private_returns_f() */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = "Good";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Initialize and use data before it is overwritten */
            data = "Good";

            IO.writeLine(data);

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = "Reinitialize";
            IO.writeLine(data);
        }
        else {

            /* FIX: Use data without over-writing its value */
            IO.writeLine(data);

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* POTENTIAL FLAW: Initialize, but do not use data */
            data = "Good";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Initialize and use data before it is overwritten */
            data = "Good";

            IO.writeLine(data);

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_returns_t())
        {
            /* FIX: Use data without over-writing its value */
            IO.writeLine(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Possibly over-write the initial value of data before using it */
            data = "Reinitialize";

            IO.writeLine(data);

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
