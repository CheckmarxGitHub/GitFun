/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__fromFile_66b.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-66b.tmpl.java
*/
/*
 * @description
 * CWE: 209 Information exposure through error message
 * BadSource: fromFile Read data from file (named c:\data.txt)
 * GoodSource: A hardcoded string
 * Sinks: stackDump
 *    GoodSink: Generic error message
 *    BadSink : Error causes stack dump
 * Flow Variant: 66 Data flow: data passed in an array from one method to another in different source files in the same package
 *
 * */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE209_Information_Leak_Error__fromFile_66b
{

    public void bad_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

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
    public void goodG2B_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

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
    public void goodB2G_sink(String data_array[] ) throws Throwable
    {
        String data = data_array[2];

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
