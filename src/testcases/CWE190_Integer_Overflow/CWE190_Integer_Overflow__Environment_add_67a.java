/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE190_Integer_Overflow__Environment_add_67a.java
Label Definition File: CWE190_Integer_Overflow.label.xml
Template File: sources-sinks-67a.tmpl.java
*/
/*
 * @description
 * CWE: 190 Integer Overflow
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: add
 *    GoodSink: Ensure there will not be an overflow before performing the addition
 *    BadSink : Unchecked addition, which can lead to overflow
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE190_Integer_Overflow;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE190_Integer_Overflow__Environment_add_67a extends AbstractTestCase
{

    static class Container
    {
        public int a;
    }

    public void bad() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        /* get environment variable ADD */
        String s_data = System.getenv("ADD");
        try {
            data = Integer.parseInt(s_data.trim());
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }

        Container data_container = new Container();
        data_container.a = data;
        (new CWE190_Integer_Overflow__Environment_add_67b()).bad_sink(data_container  );
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
        (new CWE190_Integer_Overflow__Environment_add_67b()).goodG2B_sink(data_container  );
    }

    /* goodB2G() - use badsource and goodsink */
    private void goodB2G() throws Throwable
    {
        int data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* init data */
        data = -1;

        /* get environment variable ADD */
        String s_data = System.getenv("ADD");
        try {
            data = Integer.parseInt(s_data.trim());
        }
        catch( NumberFormatException nfe )
        {
            log_bad.warning("Error with number parsing");
        }

        Container data_container = new Container();
        data_container.a = data;
        (new CWE190_Integer_Overflow__Environment_add_67b()).goodB2G_sink(data_container  );
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
