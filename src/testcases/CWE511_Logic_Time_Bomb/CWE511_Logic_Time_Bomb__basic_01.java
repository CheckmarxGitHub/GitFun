/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__basic_01.java
Label Definition File: CWE511_Logic_Time_Bomb__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks:
*    GoodSink: no debugging bypass
*    BadSink : after a certain date, launch an executable
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.io.*;
import java.util.Calendar;

public class CWE511_Logic_Time_Bomb__basic_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        Calendar now = Calendar.getInstance();

        Calendar e = Calendar.getInstance();
        e.set(2020, 1, 1);

        /* FLAW: date triggered backdoor */
        if (now.after(e))
        {
            Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        Calendar now = Calendar.getInstance();

        Calendar e = Calendar.getInstance();
        e.set(2020, 1, 1);

        /* FIX: no execution of external process */
        if (now.after(e))
        {
            IO.writeLine("Sorry, your license has expired.  Please contact support.");
            return;
        }

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

