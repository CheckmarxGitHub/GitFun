/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_StringBuilder_05.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource:  Use a custom method which may return null
* GoodSource: Use a custom method that never returns null
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__Class_StringBuilder_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        StringBuilder data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: call getStringBuilderG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.toString().trim();
                IO.writeLine(sOut);
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_t to private_f */
    private void goodG2B1() throws Throwable
    {
        StringBuilder data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();
        }
        else {

            /* FIX: call getStringBuilderG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.toString().trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        StringBuilder data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* FIX: call getStringBuilderG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.toString().trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_t to private_f */
    private void goodB2G1() throws Throwable
    {
        StringBuilder data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: call getStringBuilderG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: data could be null */
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
        }
        else {

            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.toString().trim();
                IO.writeLine(sOut);
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        StringBuilder data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: call getStringBuilderG(), which will never return null */
            data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
        {
            /* FIX: explicit check for null */
            if (data != null)
            {
                String sOut = data.toString().trim();
                IO.writeLine(sOut);
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: data could be null */
            String sOut = data.toString().trim();

            IO.writeLine(sOut);

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
