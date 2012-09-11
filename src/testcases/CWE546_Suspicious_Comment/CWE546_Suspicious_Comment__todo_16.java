/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE546_Suspicious_Comment__todo_16.java
Label Definition File: CWE546_Suspicious_Comment.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 546 Suspicious Comment
* Sinks: todo
*    GoodSink: log non-sensitive information to the logfile
*    BadSink : does not contain a suspicious comment
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE546_Suspicious_Comment;

import testcasesupport.*;

import java.io.*;

public class CWE546_Suspicious_Comment__todo_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            /* FLAW: This is the suspicious comment */
            /* TODO: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");
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
            /* FLAW: This is the suspicious comment */
            /* TODO: There is a bug at this location...I'm not sure why! */
            IO.writeLine("This a test of the emergency broadcast system");
            break;
        }

        while(true)
        {
            /* FIX: don't have those types of comments :) */
            IO.writeLine("This a test of the emergency broadcast system");
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
