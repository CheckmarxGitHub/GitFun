/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__getParameterServlet_61b.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE606_Unchecked_Loop_Condition__getParameterServlet_61b
{

    public String bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from request */
        data = request.getParameter("name");

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public String goodG2B_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        data = "5";

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public String goodB2G_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* read parameter from request */
        data = request.getParameter("name");

        return data;
    }
}
