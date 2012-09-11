/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE378_Creation_of_File_with_Insecure_Perms__basic_19.java
Label Definition File: CWE378_Creation_of_File_with_Insecure_Perms__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 378 Explicitly set permissions on files
* Sinks:
*    GoodSink: set permissions on file
*    BadSink : permissions never set on file
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE378_Creation_of_File_with_Insecure_Perms;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE378_Creation_of_File_with_Insecure_Perms__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            File temp = File.createTempFile("temp", "1234");

            /* FLAW: permissions never set on file */
            BufferedWriter bufOut = new BufferedWriter(new FileWriter(temp.getAbsolutePath()));
            bufOut.write("This is temporary data");
            bufOut.close();

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            File temp = File.createTempFile("temp", "1234");

            /* FIX: set file as writable by owner, readable by owner, not executable */
            temp.setWritable(true, true);
            temp.setReadable(true, true);
            temp.setExecutable(false);

            BufferedWriter bufOut = new BufferedWriter(new FileWriter(temp.getAbsolutePath()));
            bufOut.write("This is temporary data");
            bufOut.close();

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

            File temp = File.createTempFile("temp", "1234");

            /* FIX: set file as writable by owner, readable by owner, not executable */
            temp.setWritable(true, true);
            temp.setReadable(true, true);
            temp.setExecutable(false);

            BufferedWriter bufOut = new BufferedWriter(new FileWriter(temp.getAbsolutePath()));
            bufOut.write("This is temporary data");
            bufOut.close();

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            File temp = File.createTempFile("temp", "1234");

            /* FLAW: permissions never set on file */
            BufferedWriter bufOut = new BufferedWriter(new FileWriter(temp.getAbsolutePath()));
            bufOut.write("This is temporary data");
            bufOut.close();

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

