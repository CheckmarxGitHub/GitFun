/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__reader_08.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: reader
*    GoodSink: Report and rethrow FileNotFoundException
*    BadSink : Catch FileNotFoundException, but don't do anything about it
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;

public class CWE390_Error_Without_Action__reader_08 extends AbstractTestCase
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
            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new FileReader("C:\\doesntexistandneverwill.txt"));
                reader.close();
            }
            catch( FileNotFoundException fe )
            {
                /* FLAW: do nothing if the file doesn't exist */
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new FileReader("C:\\doesntexistandneverwill.txt"));
                reader.close();
            }
            catch( FileNotFoundException fe )
            {
                /* FIX: report read failure and rethrow */
                IO.writeLine("Error reading path: " + fe.getMessage());
                throw fe;
            }

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new FileReader("C:\\doesntexistandneverwill.txt"));
                reader.close();
            }
            catch( FileNotFoundException fe )
            {
                /* FLAW: do nothing if the file doesn't exist */
            }
        }
        else {

            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new FileReader("C:\\doesntexistandneverwill.txt"));
                reader.close();
            }
            catch( FileNotFoundException fe )
            {
                /* FIX: report read failure and rethrow */
                IO.writeLine("Error reading path: " + fe.getMessage());
                throw fe;
            }

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new FileReader("C:\\doesntexistandneverwill.txt"));
                reader.close();
            }
            catch( FileNotFoundException fe )
            {
                /* FIX: report read failure and rethrow */
                IO.writeLine("Error reading path: " + fe.getMessage());
                throw fe;
            }
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            BufferedReader reader;
            try
            {
                reader = new BufferedReader(new FileReader("C:\\doesntexistandneverwill.txt"));
                reader.close();
            }
            catch( FileNotFoundException fe )
            {
                /* FLAW: do nothing if the file doesn't exist */
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
