/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE690_NULL_Deref_from_Return__Class_String_61b.java
Label Definition File: CWE690_NULL_Deref_from_Return__Class.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 690 Unchecked return value is null, leading to a null pointer dereference.
 * BadSource:  Use a custom method which may return null
 * GoodSource: Use a custom method that never returns null
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

public class CWE690_NULL_Deref_from_Return__Class_String_61b
{

    public String bad_source() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Call getStringG(), which may return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public String goodG2B_source() throws Throwable
    {
        String data;

        /* FIX: call getStringG(), which will never return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringGood();

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public String goodB2G_source() throws Throwable
    {
        String data;

        /* POTENTIAL FLAW: Call getStringG(), which may return null */
        data = CWE690_NULL_Deref_from_Return__Class__Helper.getStringBad();

        return data;
    }
}
