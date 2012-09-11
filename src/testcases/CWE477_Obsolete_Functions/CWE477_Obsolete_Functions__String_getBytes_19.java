/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__String_getBytes_19.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: String_getBytes
*    GoodSink: Use of prefered java.lang.String.getBytes() method
*    BadSink : Use of deprecated java.lang.String.getBytes(int, int, byte[], int) method
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.*;
import java.text.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__String_getBytes_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length() - 1, bytes, 0);

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            String s2bytes = "Convert this to bytes";
            /* FIX: Use prefered String.getBytes() method */
            byte[] bytes = s2bytes.getBytes(); /* FIX: Use prefered method */

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

            String s2bytes = "Convert this to bytes";
            /* FIX: Use prefered String.getBytes() method */
            byte[] bytes = s2bytes.getBytes(); /* FIX: Use prefered method */

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            String s2bytes = "Convert this to bytes";
            byte[] bytes = new byte[s2bytes.length()];
            /* FLAW: Use of deprecated String.getBytes(int, int, byte[], int) method */
            s2bytes.getBytes(0, s2bytes.length() - 1, bytes, 0);

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

