/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_StringBuilder_68b.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
 * Sinks: trim
 *    GoodSink: Check data for null before calling trim()
 *    BadSink : Call trim() on possibly null object
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE690_NULL_Deref_from_Return;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;

public class CWE690_NULL_Deref_from_Return__Class_StringBuilder_68b
{

    public void bad_sink() throws Throwable
    {
        StringBuilder data = CWE690_NULL_Deref_from_Return__Class_StringBuilder_68a.data;

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        StringBuilder data = CWE690_NULL_Deref_from_Return__Class_StringBuilder_68a.data;

        /* POTENTIAL FLAW: data could be null */
        String sOut = data.toString().trim();

        IO.writeLine(sOut);

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink() throws Throwable
    {
        StringBuilder data = CWE690_NULL_Deref_from_Return__Class_StringBuilder_68a.data;

        /* FIX: explicit check for null */
        if (data != null)
        {
            String sOut = data.toString().trim();
            IO.writeLine(sOut);
        }

    }
}
