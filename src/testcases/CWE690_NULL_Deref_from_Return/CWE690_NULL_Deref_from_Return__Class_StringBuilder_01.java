/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_StringBuilder_01.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-01.tmpl.java
*/
/*
* @description
* CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
* BadSource:  Use a custom method which may return null
* GoodSource: Use a custom method that never returns null
* Sinks: trim
*    GoodSink: Check data for null before calling trim()
*    BadSink : Call trim() on possibly null object
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__Class_StringBuilder_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        StringBuilder data;

        /* FIX: call getStringBuilderG(), which will never return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderGood();

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();

        /* FIX: explicit check for null */
        if (data != null)
        {
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
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

