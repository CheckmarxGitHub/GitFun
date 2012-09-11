/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_StringBuilder_66a.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-66a.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__Class_StringBuilder_66a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();

        StringBuilder[] data_array = new StringBuilder[5];
        data_array[2] = data;
        (new CWE690_NULL_Deref_from_Return__Class_StringBuilder_66b()).bad_sink(data_array  );
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

        StringBuilder[] data_array = new StringBuilder[5];
        data_array[2] = data;
        (new CWE690_NULL_Deref_from_Return__Class_StringBuilder_66b()).goodG2B_sink(data_array  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        StringBuilder data;

        /* POTENTIAL FLAW: Call getStringBuilderG(), which may return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBuilderBad();

        StringBuilder[] data_array = new StringBuilder[5];
        data_array[2] = data;
        (new CWE690_NULL_Deref_from_Return__Class_StringBuilder_66b()).goodB2G_sink(data_array  );
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
