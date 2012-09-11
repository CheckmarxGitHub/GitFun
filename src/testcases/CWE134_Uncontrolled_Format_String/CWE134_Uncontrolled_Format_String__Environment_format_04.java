/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE134_Uncontrolled_Format_String__Environment_format_04.java
Label Definition File: CWE134_Uncontrolled_Format_String.label.xml
Template File: sources-sinks-04.tmpl.java
*/
/*
* @description
* CWE: 134 Uncontrolled Format String
* BadSource: Environment Read a string from an environment variable
* GoodSource: A hardcoded string
* Sinks: format
*    GoodSink: dynamic formatted stdout with string defined
*    BadSink : dynamic formatted stdout without validation
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE134_Uncontrolled_Format_String;

import testcasesupport.*;

import java.util.logging.Logger;

public class CWE134_Uncontrolled_Format_String__Environment_format_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicitly defined string formatting */
            System.out.format("%s\n", data);

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_final_t to private_final_f */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        else {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicitly defined string formatting */
            System.out.format("%s\n", data);

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");
            /* FIX: Use a hardcoded string */
            data = "foo";
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Logger log_bad = Logger.getLogger("local-logger");

            /* get environment variable ADD */
            data = System.getenv("ADD");

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: explicitly defined string formatting */
            System.out.format("%s\n", data);

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_final_t to private_final_f */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);
        }
        else {

            /* FIX: explicitly defined string formatting */
            System.out.format("%s\n", data);

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            Logger log_bad = Logger.getLogger("local-logger");
            /* get environment variable ADD */
            data = System.getenv("ADD");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded string */
            data = "foo";

        }
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_final_t)
        {
            /* FIX: explicitly defined string formatting */
            System.out.format("%s\n", data);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* POTENTIAL FLAW: uncontrolled string formatting */
            System.out.format(data);

        }
    }

    public void good() throws Throwable
    {
        goodG2B1();
        goodG2B2();
        goodB2G1();
        goodB2G2();
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
