/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__heap_08.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* Sinks: heap
*    GoodSink: threshold for memory consumption
*    BadSink : no threshold for memory consumption
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class CWE400_Resource_Exhaustion__heap_08 extends AbstractTestCase
{

    /* The methods below always return the same value, so a tool
       should be able to figure out that every call to these
       methods will return true or return false. */
    private boolean private_returns_t()
    {
        return true;
    }

    private boolean private_returns_f()
    {
        return false;
    }

    public void bad() throws Throwable
    {
        if (private_returns_t())
        {
            ArrayList<byte[]> bList = new ArrayList<byte[]>();
            /* INCIDENTAL: CWE 571: Expression is Always True */
            if(true)   /* need this here so that the Java compiler does not error on code after the while(true) as unreachable code */
            {
                while(true)
                {
                    /* FLAW: continued consumption of memory in 10MB XXXXXs with no verification of available memory */
                    byte[] b = new byte[10485760];
                    bList.add(b);
                    IO.writeLine("" + Runtime.getRuntime().freeMemory());
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            ArrayList<byte[]> bList = new ArrayList<byte[]>();
            /* INCIDENTAL: CWE 571: Expression is Always True */
            if(true)   /* need this here so that the Java compiler does not error on code after the while(true) as unreachable code */
            {
                while(true)
                {
                    /* FIX: threshold defined for memory consumption */
                    if (Runtime.getRuntime().freeMemory() < 10485760)
                    {
                        IO.writeLine("Not enough memory to go again");
                        break;
                    }
                    /* consume memory in 10MB chunks */
                    byte[] b = new byte[10485760];
                    bList.add(b);
                    IO.writeLine("" + Runtime.getRuntime().freeMemory());
                }
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            ArrayList<byte[]> bList = new ArrayList<byte[]>();
            /* INCIDENTAL: CWE 571: Expression is Always True */
            if(true)   /* need this here so that the Java compiler does not error on code after the while(true) as unreachable code */
            {
                while(true)
                {
                    /* FLAW: continued consumption of memory in 10MB XXXXXs with no verification of available memory */
                    byte[] b = new byte[10485760];
                    bList.add(b);
                    IO.writeLine("" + Runtime.getRuntime().freeMemory());
                }
            }
        }
        else {

            ArrayList<byte[]> bList = new ArrayList<byte[]>();
            /* INCIDENTAL: CWE 571: Expression is Always True */
            if(true)   /* need this here so that the Java compiler does not error on code after the while(true) as unreachable code */
            {
                while(true)
                {
                    /* FIX: threshold defined for memory consumption */
                    if (Runtime.getRuntime().freeMemory() < 10485760)
                    {
                        IO.writeLine("Not enough memory to go again");
                        break;
                    }
                    /* consume memory in 10MB chunks */
                    byte[] b = new byte[10485760];
                    bList.add(b);
                    IO.writeLine("" + Runtime.getRuntime().freeMemory());
                }
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            ArrayList<byte[]> bList = new ArrayList<byte[]>();
            /* INCIDENTAL: CWE 571: Expression is Always True */
            if(true)   /* need this here so that the Java compiler does not error on code after the while(true) as unreachable code */
            {
                while(true)
                {
                    /* FIX: threshold defined for memory consumption */
                    if (Runtime.getRuntime().freeMemory() < 10485760)
                    {
                        IO.writeLine("Not enough memory to go again");
                        break;
                    }
                    /* consume memory in 10MB chunks */
                    byte[] b = new byte[10485760];
                    bList.add(b);
                    IO.writeLine("" + Runtime.getRuntime().freeMemory());
                }
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            ArrayList<byte[]> bList = new ArrayList<byte[]>();
            /* INCIDENTAL: CWE 571: Expression is Always True */
            if(true)   /* need this here so that the Java compiler does not error on code after the while(true) as unreachable code */
            {
                while(true)
                {
                    /* FLAW: continued consumption of memory in 10MB XXXXXs with no verification of available memory */
                    byte[] b = new byte[10485760];
                    bList.add(b);
                    IO.writeLine("" + Runtime.getRuntime().freeMemory());
                }
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
