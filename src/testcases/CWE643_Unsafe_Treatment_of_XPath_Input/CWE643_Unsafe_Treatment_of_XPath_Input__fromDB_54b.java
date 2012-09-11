/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE643_Unsafe_Treatment_of_XPath_Input__fromDB_54b.java
Label Definition File: CWE643_Unsafe_Treatment_of_XPath_Input.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 643 Unsafe Treatment of XPath Input
 * BadSource: fromDB Read a string from a database connection
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

public class CWE643_Unsafe_Treatment_of_XPath_Input__fromDB_54b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE643_Unsafe_Treatment_of_XPath_Input__fromDB_54c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE643_Unsafe_Treatment_of_XPath_Input__fromDB_54c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE643_Unsafe_Treatment_of_XPath_Input__fromDB_54c()).goodB2G_sink(data );
    }
}
