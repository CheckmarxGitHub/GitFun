/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__todo_19.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: todo
*    GoodSink: log non-sensitive information to the logfile
*    BadSink : does not contain a suspicious comment
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

import java.io.*;

public class CWE546_Suspicious_Comment__todo_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            /* FLAW: This is the suspicious comment */
            /* TODO: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");

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

            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FLAW: This is the suspicious comment */
            /* TODO: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");

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

