/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE89_SQL_Injection__getQueryStringServlet_executeUpdate_53b.java
Label Definition File: CWE89_SQL_Injection.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 89 SQL Injection
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded string
 * Sinks: executeUpdate
 *    GoodSink: prepared sqlstatement, executeUpdate
 *    BadSink : raw query used in executeUpdate
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE89_SQL_Injection;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE89_SQL_Injection__getQueryStringServlet_executeUpdate_53b
{

    public void bad_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE89_SQL_Injection__getQueryStringServlet_executeUpdate_53c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE89_SQL_Injection__getQueryStringServlet_executeUpdate_53c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE89_SQL_Injection__getQueryStringServlet_executeUpdate_53c()).goodB2G_sink(data , request, response);
    }
}
