/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE606_Unchecked_Loop_Condition__connect_tcp_67b.java
Label Definition File: CWE606_Unchecked_Loop_Condition.label.xml
Template File: sources-sinks-67b.tmpl.java
*/
/*
 * @description
 * CWE: 606 Unchecked Input for Loop Condition
 * BadSource: connect_tcp Read data using an outbound tcp connection
 * GoodSource: hardcoded int in string form
 * Sinks:
 *    GoodSink: validate loop variable
 *    BadSink : loop variable not validated
 * Flow Variant: 67 Data flow: data passed in a class from one method to another in different source files in the same package
 *
 * */

package testcases.CWE606_Unchecked_Loop_Condition;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;

public class CWE606_Unchecked_Loop_Condition__connect_tcp_67b
{

    public void bad_sink(CWE606_Unchecked_Loop_Condition__connect_tcp_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

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
    public void goodG2B_sink(CWE606_Unchecked_Loop_Condition__connect_tcp_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

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
    public void goodB2G_sink(CWE606_Unchecked_Loop_Condition__connect_tcp_67a.Container data_container ) throws Throwable
    {
        String data = data_container.a;

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
