/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE369_Divide_By_Zero__Environment_divide_54a.java
Label Definition File: CWE369_Divide_By_Zero.label.xml
Template File: sources-sinks-54a.tmpl.java
*/
/*
 * @description
 * CWE: 369 Divide by zero
 * BadSource: Environment Read data from an environment variable
 * GoodSource: A hardcoded non-zero, non-min, non-max, even number
 * Sinks: divide
 *    GoodSink: Check for zero before dividing
 *    BadSink : Dividing by a value that may be zero
 * Flow Variant: 54 Data flow: data passed as an argument from one method through three others to a fifth; all five functions are in different classes in the same package
 *
 * */

package testcases.CWE369_Divide_By_Zero;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.SecureRandom;

import java.util.logging.Logger;

public class CWE369_Divide_By_Zero__Environment_divide_54a extends AbstractTestCase
{

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

        (new CWE369_Divide_By_Zero__Environment_divide_54b()).bad_sink(data );
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

        (new CWE369_Divide_By_Zero__Environment_divide_54b()).goodG2B_sink(data );
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

        (new CWE369_Divide_By_Zero__Environment_divide_54b()).goodB2G_sink(data );
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
