/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Unsafe_Treatment_of_XPath_Input__URLConnection_54d.java
Label Definition File: CWE643_Unsafe_Treatment_of_XPath_Input.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 643 Unsafe Treatment of XPath Input
 * BadSource: URLConnection Read a string from a web server with URLConnection
 * GoodSource: A hardcoded string
 * Sinks: unvalidatedXPath
 *    GoodSink: validate input through StringEscapeUtils
 *    BadSink : user input is used without validate
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE643_Unsafe_Treatment_of_XPath_Input;

import testcasesupport.*;

import java.io.*;
import javax.xml.xpath.*;
import javax.servlet.http.*;

import org.xml.sax.InputSource;

import org.apache.commons.lang.StringEscapeUtils;

public class CWE643_Unsafe_Treatment_of_XPath_Input__URLConnection_54d
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE643_Unsafe_Treatment_of_XPath_Input__URLConnection_54e()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE643_Unsafe_Treatment_of_XPath_Input__URLConnection_54e()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE643_Unsafe_Treatment_of_XPath_Input__URLConnection_54e()).goodB2G_sink(data );
    }
}
