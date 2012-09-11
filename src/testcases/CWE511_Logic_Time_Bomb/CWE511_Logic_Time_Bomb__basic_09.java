/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE511_Logic_Time_Bomb__basic_09.java
Label Definition File: CWE511_Logic_Time_Bomb__basic.label.xml
Template File: point-flaw-09.tmpl.java
*/
/*
* @description
* CWE: 511 Logic Time Bomb
* Sinks:
*    GoodSink: no debugging bypass
*    BadSink : after a certain date, launch an executable
* Flow Variant: 09 Control flow: if(IO.static_final_t) and if(IO.static_final_f)
*
* */

package testcases.CWE511_Logic_Time_Bomb;

import testcasesupport.*;

import java.io.*;
import java.util.Calendar;

public class CWE511_Logic_Time_Bomb__basic_09 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_final_t)
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
        else {
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

        }
    }

    /* good1() changes IO.static_final_t to IO.static_final_f */
    private void good1() throws Throwable
    {
        if(IO.static_final_f)
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
        }
        else {

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

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_final_t)
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
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    public void good() throws Throwable
    {
        good1();
        good2();
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
