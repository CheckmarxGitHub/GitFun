/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE486_Compare_Classes_By_Name__basic_11.java
Label Definition File: CWE486_Compare_Classes_By_Name__basic.label.xml
Template File: point-flaw-11.tmpl.java
*/
/*
* @description
* CWE: 486 Compare Classes by Name
* Sinks:
*    GoodSink: properly compare class
*    BadSink : compare class to string
* Flow Variant: 11 Control flow: if(IO.static_returns_t()) and if(IO.static_returns_f())
*
* */

package testcases.CWE486_Compare_Classes_By_Name;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class CWE486_Compare_Classes_By_Name__basic_11 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t())
        {
            /* FLAW: Differentiating by name is not enough, since different classes may use the same name */
            testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass tc2 = new testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass();
            if (tc2.getClass().getSimpleName().equals("CWE486_Compare_Classes_By_Name__TrustedClass"))
            {
                IO.writeLine("toString = " + tc2.toString());
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* You cannot compare classes directly that are different;
             * the java compiler detects this and reports a "incomparable type" error,
             * so we have to do a little workaround.
             */

            ArrayList<Object> list = new ArrayList<Object>();

            testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass tc2 = new testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass();
            list.add(tc2);

            testcases.CWE486_Compare_Classes_By_Name.CWE486_Compare_Classes_By_Name__TrustedClass tc = new testcases.CWE486_Compare_Classes_By_Name.CWE486_Compare_Classes_By_Name__TrustedClass();
            list.add(tc);

            /* FIX: comparing getClass() values is more precise */
            if (list.get(0).getClass() == list.get(1).getClass())
            {
                IO.writeLine("toString = " + tc2.toString());
            }
            else
            {
                IO.writeLine("classes are different");
            }

        }
    }

    /* good1() changes IO.static_returns_t() to IO.static_returns_f() */
    private void good1() throws Throwable
    {
        if(IO.static_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Differentiating by name is not enough, since different classes may use the same name */
            testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass tc2 = new testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass();
            if (tc2.getClass().getSimpleName().equals("CWE486_Compare_Classes_By_Name__TrustedClass"))
            {
                IO.writeLine("toString = " + tc2.toString());
            }
        }
        else {

            /* You cannot compare classes directly that are different;
             * the java compiler detects this and reports a "incomparable type" error,
             * so we have to do a little workaround.
             */

            ArrayList<Object> list = new ArrayList<Object>();

            testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass tc2 = new testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass();
            list.add(tc2);

            testcases.CWE486_Compare_Classes_By_Name.CWE486_Compare_Classes_By_Name__TrustedClass tc = new testcases.CWE486_Compare_Classes_By_Name.CWE486_Compare_Classes_By_Name__TrustedClass();
            list.add(tc);

            /* FIX: comparing getClass() values is more precise */
            if (list.get(0).getClass() == list.get(1).getClass())
            {
                IO.writeLine("toString = " + tc2.toString());
            }
            else
            {
                IO.writeLine("classes are different");
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_returns_t())
        {
            /* You cannot compare classes directly that are different;
             * the java compiler detects this and reports a "incomparable type" error,
             * so we have to do a little workaround.
             */
            ArrayList<Object> list = new ArrayList<Object>();
            testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass tc2 = new testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass();
            list.add(tc2);
            testcases.CWE486_Compare_Classes_By_Name.CWE486_Compare_Classes_By_Name__TrustedClass tc = new testcases.CWE486_Compare_Classes_By_Name.CWE486_Compare_Classes_By_Name__TrustedClass();
            list.add(tc);
            /* FIX: comparing getClass() values is more precise */
            if (list.get(0).getClass() == list.get(1).getClass())
            {
                IO.writeLine("toString = " + tc2.toString());
            }
            else
            {
                IO.writeLine("classes are different");
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: Differentiating by name is not enough, since different classes may use the same name */
            testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass tc2 = new testcases.CWE486_Compare_Classes_By_Name.TrustedClass1.CWE486_Compare_Classes_By_Name__TrustedClass();
            if (tc2.getClass().getSimpleName().equals("CWE486_Compare_Classes_By_Name__TrustedClass"))
            {
                IO.writeLine("toString = " + tc2.toString());
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
