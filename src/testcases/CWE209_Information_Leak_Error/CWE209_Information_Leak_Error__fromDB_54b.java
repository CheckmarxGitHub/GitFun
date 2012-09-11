/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__fromDB_54b.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 209 Information exposure through error message
 * BadSource: fromDB Read a string from a database connection
 * GoodSource: A hardcoded string
 * Sinks: stackDump
 *    GoodSink: Generic error message
 *    BadSink : Error causes stack dump
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__fromDB_54b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__fromDB_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__fromDB_54c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE209_Information_Leak_Error__fromDB_54c()).goodB2G_sink(data );
    }
}
