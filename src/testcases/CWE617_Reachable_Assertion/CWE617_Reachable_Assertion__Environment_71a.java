/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__Environment_71a.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-71a.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 71 Data flow: data passed as an Object reference argument from one method to another in different classes in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE617_Reachable_Assertion__Environment_71a extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        (new CWE617_Reachable_Assertion__Environment_71b()).bad_sink((Object)data  );
    }

    public void good() throws Throwable
    {
        goodG2B();
    }

    /* goodG2B() - use goodsource and badsink */
    private void goodG2B() throws Throwable
    {
        String data;

        java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

        /* FIX: Use a hardcoded string */
        data = "foo";

        (new CWE617_Reachable_Assertion__Environment_71b()).goodG2B_sink((Object)data  );
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
