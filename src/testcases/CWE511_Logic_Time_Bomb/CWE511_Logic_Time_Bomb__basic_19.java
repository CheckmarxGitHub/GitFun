/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__basic_19.java
Label Definition File: CWE511_Logic_Time_Bomb__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks:
*    GoodSink: no debugging bypass
*    BadSink : after a certain date, launch an executable
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.io.*;
import java.util.Calendar;

public class CWE511_Logic_Time_Bomb__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

