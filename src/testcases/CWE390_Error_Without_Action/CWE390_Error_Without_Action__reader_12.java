/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__reader_12.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: reader
*    GoodSink: Report and rethrow FileNotFoundException
*    BadSink : Catch FileNotFoundException, but don't do anything about it
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;

public class CWE390_Error_Without_Action__reader_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
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

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
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
