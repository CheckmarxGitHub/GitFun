/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__String_getBytes_07.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: String_getBytes
*    GoodSink: Use of prefered java.lang.String.getBytes() method
*    BadSink : Use of deprecated java.lang.String.getBytes(int, int, byte[], int) method
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.*;
import java.text.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__String_getBytes_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad() throws Throwable
    {
        if (private_five==5)
        {
            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length() - 1, bytes, 0);
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String s2bytes = "Convert this to bytes";
            /* FIX: Use prefered String.getBytes() method */
            byte[] bytes = s2bytes.getBytes(); /* FIX: Use prefered method */

        }
    }

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1() throws Throwable
    {
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length() - 1, bytes, 0);
        }
        else {

            String s2bytes = "Convert this to bytes";
            /* FIX: Use prefered String.getBytes() method */
            byte[] bytes = s2bytes.getBytes(); /* FIX: Use prefered method */

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_five==5)
        {
            String s2bytes = "Convert this to bytes";
            /* FIX: Use prefered String.getBytes() method */
            byte[] bytes = s2bytes.getBytes(); /* FIX: Use prefered method */
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length() - 1, bytes, 0);

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
