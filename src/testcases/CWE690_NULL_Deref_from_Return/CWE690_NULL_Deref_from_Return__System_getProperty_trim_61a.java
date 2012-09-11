/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__System_getProperty_trim_61a.java
Label Definition File: CWE690_NULL_Deref_from_Return.label.xml
Template File: sources-sinks-61a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource: System_getProperty Set data to return of System.getProperty
 * GoodSource: Set data to fixed, non-null String
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__System_getProperty_trim_61a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data = (new CWE690_NULL_Deref_from_Return__System_getProperty_trim_61b()).bad_source();

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.trim();

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
        String data = (new CWE690_NULL_Deref_from_Return__System_getProperty_trim_61b()).goodG2B_source();

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.trim();

        IO.writeLine(sOut);

    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        String data = (new CWE690_NULL_Deref_from_Return__System_getProperty_trim_61b()).goodB2G_source();

        /* FIX: explicit check for null */
        if (data != null)
        {
            String sOut = data.trim();
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
