/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_StringBuilder_66b.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-66b.tmpl.java
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

public class CWE690_NULL_Deref_from_Return__Class_StringBuilder_66b
{

    public void bad_sink(StringBuilder data_array[] ) throws Throwable
    {
        StringBuilder data = data_array[2];

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(StringBuilder data_array[] ) throws Throwable
    {
        StringBuilder data = data_array[2];

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(StringBuilder data_array[] ) throws Throwable
    {
        StringBuilder data = data_array[2];

        /* FIX: explicit check for null */
        if (data != null)
        {
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
        }

    }
}
