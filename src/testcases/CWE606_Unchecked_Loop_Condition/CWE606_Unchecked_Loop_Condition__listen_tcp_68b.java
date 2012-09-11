/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__listen_tcp_68b.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-68b.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: listen_tcp Read data using a listening tcp connection
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 68 Data flow: data passed as a member variable in the "a" class, which is used by a method in another class in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

//!! other imports come from the label definitions

import java.sql.*;
import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__listen_tcp_68b
{

    public void bad_sink() throws Throwable
    {
        String data = CWE606_Unchecked_Loop_Condition__listen_tcp_68a.data;

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

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink() throws Throwable
    {
        String data = CWE606_Unchecked_Loop_Condition__listen_tcp_68a.data;

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

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink() throws Throwable
    {
        String data = CWE606_Unchecked_Loop_Condition__listen_tcp_68a.data;

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
