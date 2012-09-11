/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__String_getBytes_16.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: String_getBytes
*    GoodSink: Use of prefered java.lang.String.getBytes() method
*    BadSink : Use of deprecated java.lang.String.getBytes(int, int, byte[], int) method
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.*;
import java.text.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__String_getBytes_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length() - 1, bytes, 0);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String s2bytes = "Convert this to bytes";
            /* FIX: Use prefered String.getBytes() method */
            byte[] bytes = s2bytes.getBytes(); /* FIX: Use prefered method */
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
            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length() - 1, bytes, 0);
            break;
        }

        while(true)
        {
            String s2bytes = "Convert this to bytes";
            /* FIX: Use prefered String.getBytes() method */
            byte[] bytes = s2bytes.getBytes(); /* FIX: Use prefered method */
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
