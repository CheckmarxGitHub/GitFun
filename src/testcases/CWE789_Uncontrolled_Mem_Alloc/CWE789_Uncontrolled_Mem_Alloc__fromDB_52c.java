/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__fromDB_52c.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-52c.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: fromDB Read data from a database connection
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashMap
 *    BadSink : Create a HashMap using data as the initial size
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.HashMap;

public class CWE789_Uncontrolled_Mem_Alloc__fromDB_52c
{

    public void bad_sink(int data ) throws Throwable
    {

        /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
        HashMap list = new HashMap(data);

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(int data ) throws Throwable
    {

        /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
        HashMap list = new HashMap(data);

    }

}