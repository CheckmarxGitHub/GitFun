/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__getCookiesServlet_17.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-17.tmpl.java
*/
/*
* @description
* CWE: 789 Uncontrolled Memory Allocation
* BadSource: getCookiesServlet Read data from the first cookie
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* BadSink: HashMap Create a HashMap using data as the initial size
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE789_Uncontrolled_Mem_Alloc;

import testcasesupport.*;

import javax.servlet.http.*;

import javax.servlet.http.*;
import java.util.logging.Logger;

import java.util.HashMap;

public class CWE789_Uncontrolled_Mem_Alloc__getCookiesServlet_17 extends AbstractTestCaseServlet
{

    /* uses badsource and badsink */
    public void bad(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;
        /* We need to have one source outside of a for loop in order
           to prevent the Java compiler from generating an error because
           data is uninitialized */

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

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;
        }

        /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
        HashMap list = new HashMap(data);

    }

    /* goodG2B() - use goodsource and badsink by reversing the block outside the
       for statement with the one in the for statement */
    private void goodG2B(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        for(int for_index_i = 0; for_index_i < 0; for_index_i++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        }

        /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
        HashMap list = new HashMap(data);

    }

    public void good(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        goodG2B(request, response);
    }

    /* Below is the main(). It is only used when building this testcase on
       its own for testing or for building a binary to use in testing binary
       analysis tools. It is not used when compiling all the testcases as one
       application, which is how source code analysis tools are tested. */
    public static void main(String[] args) throws ClassNotFoundException,
           InstantiationException, IllegalAccessException
    {
        mainFromParent(args);
    }
}
