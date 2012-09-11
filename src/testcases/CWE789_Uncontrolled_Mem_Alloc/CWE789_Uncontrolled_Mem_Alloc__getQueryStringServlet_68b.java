/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__getQueryStringServlet_68b.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-68b.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: getQueryStringServlet Parse id param out of the querystring without getParam
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * BadSink: HashMap Create a HashMap using data as the initial size
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc;

import testcasesupport.*;

//!! other imports come from the label definitions

import javax.servlet.http.*;

import java.util.HashMap;

public class CWE789_Uncontrolled_Mem_Alloc__getQueryStringServlet_68b
{

    public void bad_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = CWE789_Uncontrolled_Mem_Alloc__getQueryStringServlet_68a.data;

        /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
        HashMap list = new HashMap(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(HttpServletRequest request, HttpServletResponse response) throws Throwable
    {
        int data = CWE789_Uncontrolled_Mem_Alloc__getQueryStringServlet_68a.data;

        /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
        HashMap list = new HashMap(data);

    }
}
