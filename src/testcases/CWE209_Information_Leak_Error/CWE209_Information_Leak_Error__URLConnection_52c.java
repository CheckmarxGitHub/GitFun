/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__URLConnection_52c.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-52c.tmpl.java
*/
/*
 * @description
 * CWE: 209 Information exposure through error message
 * BadSource: URLConnection Read a string from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: stackDump
 *    GoodSink: Generic error message
 *    BadSink : Error causes stack dump
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__URLConnection_52c
{

    public void bad_sink(String data ) throws Throwable
    {

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
    public void goodG2B_sink(String data ) throws Throwable
    {

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
    public void goodB2G_sink(String data ) throws Throwable
    {

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
