/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__connect_tcp_68b.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 209 Information exposure through error message
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: A hardcoded string
 * Sinks: stackDump
 *    GoodSink: Generic error message
 *    BadSink : Error causes stack dump
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__connect_tcp_68b
{

    public void bad_sink() throws Throwable
    {
        String data = CWE209_Information_Leak_Error__connect_tcp_68a.data;

        try
        {
            int iConversion = Integer.valueOf(data);
        }
        catch( Exception e )
        {
            e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
        }

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String data = CWE209_Information_Leak_Error__connect_tcp_68a.data;

        try
        {
            int iConversion = Integer.valueOf(data);
        }
        catch( Exception e )
        {
            e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
        }

    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink() throws Throwable
    {
        String data = CWE209_Information_Leak_Error__connect_tcp_68a.data;

        try
        {
            int iConversion = Integer.valueOf(data);
        }
        catch( Exception e )
        {
            IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
        }

    }
}
