/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__getCookiesServlet_add_54d.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-54d.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before performing the addition
 *    BadSink : Unchecked addition, which can lead to overflow
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.security.SecureRandom;

public class CWE190_Integer_Overflow__getCookiesServlet_add_54d
{

    public void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE190_Integer_Overflow__getCookiesServlet_add_54e()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE190_Integer_Overflow__getCookiesServlet_add_54e()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE190_Integer_Overflow__getCookiesServlet_add_54e()).goodB2G_sink(data , request, response);
    }
}
