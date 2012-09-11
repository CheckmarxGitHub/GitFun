/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE400_Resource_Exhaustion__heap_01.java
Label Definition File: CWE400_Resource_Exhaustion.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 400 Resource Exhaustion
* Sinks: heap
*    GoodSink: threshold for memory consumption
*    BadSink : no threshold for memory consumption
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE400_Resource_Exhaustion;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;

public class CWE400_Resource_Exhaustion__heap_01 extends AbstractTestCase
{

    public void bad() throws Throwable
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

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
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

