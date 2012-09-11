/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE617_Reachable_Assertion__Environment_67a.java
Label Definition File: CWE617_Reachable_Assertion.label.xml
Template File: sources-sink-67a.tmpl.java
*/
/*
 * @description
 * CWE: 617 Assertion is reachable
 * BadSource: Environment Read a string from an environment variable
 * GoodSource: A hardcoded string
 * Sinks:
 *    BadSink : possibility of assertion being triggered
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE617_Reachable_Assertion;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE617_Reachable_Assertion__Environment_67a extends AbstractTestCase
{

    static class Container
    {
        public String a;
    }

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        Container data_container = new Container();
        data_container.a = data;
        (new CWE617_Reachable_Assertion__Environment_67b()).bad_sink(data_container  );
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

        Container data_container = new Container();
        data_container.a = data;
        (new CWE617_Reachable_Assertion__Environment_67b()).goodG2B_sink(data_container  );
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
