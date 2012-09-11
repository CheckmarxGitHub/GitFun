/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__basic_16.java
Label Definition File: CWE511_Logic_Time_Bomb__basic.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks:
*    GoodSink: no debugging bypass
*    BadSink : after a certain date, launch an executable
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.io.*;
import java.util.Calendar;

public class CWE511_Logic_Time_Bomb__basic_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            Calendar now = Calendar.getInstance();
            Calendar e = Calendar.getInstance();
            e.set(2020, 1, 1);
            /* FLAW: date triggered backdoor */
            if (now.after(e))
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Calendar now = Calendar.getInstance();
            Calendar e = Calendar.getInstance();
            e.set(2020, 1, 1);
            /* FIX: no execution of external process */
            if (now.after(e))
            {
                IO.writeLine("Sorry, your license has expired.  Please contact support.");
                return;
            }
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Calendar now = Calendar.getInstance();
            Calendar e = Calendar.getInstance();
            e.set(2020, 1, 1);
            /* FLAW: date triggered backdoor */
            if (now.after(e))
            {
                Runtime.getRuntime().exec("c:\\windows\\system32\\evil.exe");
            }
            break;
        }

        while(true)
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
            break;
        }
    }

    public void good() throws Throwable
    {
        good1();
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
