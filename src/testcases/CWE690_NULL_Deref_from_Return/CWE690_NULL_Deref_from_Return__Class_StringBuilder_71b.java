/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_StringBuilder_71b.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-71b.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__Class_StringBuilder_71b
{

    public void bad_sink(Object data_obj ) throws Throwable
    {
        StringBuilder data = (StringBuilder)data_obj;

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(Object data_obj ) throws Throwable
    {
        StringBuilder data = (StringBuilder)data_obj;

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(Object data_obj ) throws Throwable
    {
        StringBuilder data = (StringBuilder)data_obj;

        /* FIX: explicit check for null */
        if (data != null)
        {
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
        }

    }
}
