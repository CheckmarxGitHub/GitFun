/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__random_67a.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-67a.tmpl.java
*/
/*
 * @description
 * CWE: 789 Uncontrolled Memory Allocation
 * BadSource: random Set data to a random value
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: HashMap
 *    BadSink : Create a HashMap using data as the initial size
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE789_Uncontrolled_Mem_Alloc;

import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;
import java.util.logging.Logger;

public class CWE789_Uncontrolled_Mem_Alloc__random_67a extends AbstractTestCase
{

    static class Container
    {
        public int a;
    }

    public void bad() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        SecureRandom r = new SecureRandom();
        data = r.nextInt();

        Container data_container = new Container();
        data_container.a = data;
        (new CWE789_Uncontrolled_Mem_Alloc__random_67b()).bad_sink(data_container  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        int data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                divide by zero, or loss-of-precision issues */
        data = 2;

        Container data_container = new Container();
        data_container.a = data;
        (new CWE789_Uncontrolled_Mem_Alloc__random_67b()).goodG2B_sink(data_container  );
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
