/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__getCookiesServlet_modulo_61b.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-61b.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: getCookiesServlet Read data from the first cookie
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: modulo
 *    GoodSink: Check for zero before modulo
 *    BadSink : Modulo by a value that may be zero
 * Flow Variant: 61 Data flow: data returned from one method to another in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import javax.servlet.http.*;
import java.util.logging.Logger;

public class CWE369_Divide_By_Zero__getCookiesServlet_modulo_61b
{

    public int bad_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init Data$ */
        data = -1;

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            String s_data = cookieSources[0].getValue();
            data = Integer.parseInt(s_data.trim());
        }

        return data;
    }

    /* goodG2B() - use goodsource and badsink */
    public int goodG2B_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        return data;
    }

    /* goodB2G() - use badsource and goodsink */
    public int goodB2G_source(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init Data$ */
        data = -1;

        /* read parameter from cookie */
        Cookie cookieSources[] = request.getCookies();
        if (cookieSources != null)
        {
            String s_data = cookieSources[0].getValue();
            data = Integer.parseInt(s_data.trim());
        }

        return data;
    }
}
