/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE209_Information_Leak_Error__Environment_05.java
Label Definition File: CWE209_Information_Leak_Error.label.xml
Template File: sources-sinks-05.tmpl.java
*/
/*
* @description
* CWE: 209 Information exposure through error message
* BadSource: Environment Read a string from an environment variable
* GoodSource: A hardcoded string
* Sinks: stackDump
*    GoodSink: Generic error message
*    BadSink : Error causes stack dump
* Flow Variant: 05 Control flow: if(private_t) and if(private_f)
*
* */

package testcases.CWE209_Information_Leak_Error;

import testcasesupport.*;

import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE209_Information_Leak_Error__Environment_05 extends AbstractTestCase
{

    /* The two variables below are not defined as "final", but are never
       assigned any other value, so a tool should be able to identify that
       reads of these will always return their initialized values. */
    private boolean private_t = true;
    private boolean private_f = false;

    public void bad() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
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
        if(private_t)
        {
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
            }

        }

    }

    /* goodG2B1() - use goodsource and badsink by changing first private_t to private_f */
    private void goodG2B1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 570 Statement is Always False */
        if(private_f)
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
        if(private_t)
        {
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
            }

        }
    }

    /* goodG2B2() - use goodsource and badsink by reversing statements in first if */
    private void goodG2B2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
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
        if(private_t)
        {
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
            }

        }
    }

    /* goodB2G1() - use badsource and goodsink by changing second private_t to private_f */
    private void goodB2G1() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
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
        if(private_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
            }
        }
        else {

            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
            }

        }
    }

    /* goodB2G2() - use badsource and goodsink by reversing statements in second if  */
    private void goodB2G2() throws Throwable
    {
        String data;
        /* INCIDENTAL: CWE 571 Statement is Always True */
        if(private_t)
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
        if(private_t)
        {
            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                IO.writeLine("There was an error parsing the string"); /* FIX: print a generic message */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            try
            {
                int iConversion = Integer.valueOf(data);
            }
            catch( Exception e )
            {
                e.printStackTrace(); /* POTENTIAL FLAW: Print stack trace on error */
            }

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
