/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__getParameterServlet_modulo_54b.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-54b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: getParameterServlet Read data from a querystring using getParameter
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE369_Divide_By_Zero__getParameterServlet_modulo_54b
{

    public void bad_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE369_Divide_By_Zero__getParameterServlet_modulo_54c()).bad_sink(data , request, response);
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE369_Divide_By_Zero__getParameterServlet_modulo_54c()).goodG2B_sink(data , request, response);
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(int data , HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        (new CWE369_Divide_By_Zero__getParameterServlet_modulo_54c()).goodB2G_sink(data , request, response);
    }
}
