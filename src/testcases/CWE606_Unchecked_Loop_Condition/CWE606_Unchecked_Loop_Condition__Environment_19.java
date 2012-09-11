/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__Environment_19.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-19.tmpl.java
*/
/*
* @description
* CWE: 606 Unchecked Input for Loop Condition
* BadSource: Environment Read a string from an environment variable
* GoodSource: hardcoded int in string form
* Sinks:
*    GoodSink: validate loop variable
*    BadSink : loop variable not validated
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

import java.util.logging.Logger;

public class CWE606_Unchecked_Loop_Condition__Environment_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        {

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        String data;
        {

            data = "5";

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            Logger log_bad = Logger.getLogger("local-logger");

            /* get environment variable ADD */
            data = System.getenv("ADD");

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }

        }
    }

    /* goodB2G() - use badsource and goodsink by switching statements around return */
    private void goodB2G() throws Throwable
    {
        String data;

        Logger log_bad = Logger.getLogger("local-logger");

        /* get environment variable ADD */
        data = System.getenv("ADD");

        {

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            /* FIX: loop number thresholds validated */
            if (loopNum >= 0 && loopNum <= 5)
            {
                for(int i=0; i < loopNum; i++)
                {
                    IO.writeLine("hello world");
                }
            }

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            int loopNum;
            try
            {
                loopNum = Integer.parseInt(data);
            }
            catch (NumberFormatException nfe)
            {
                IO.writeLine("Invalid response. Numeric input expected. Assuming 1.");
                loopNum = 1;
            }

            for(int i=0; i < loopNum; i++)
            {
                /* POTENTIAL FLAW: user supplied input used for loop counter test */
                IO.writeLine("hello world");
            }

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
        goodB2G();
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
