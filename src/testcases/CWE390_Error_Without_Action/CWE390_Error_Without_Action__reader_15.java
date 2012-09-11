/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__reader_15.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: reader
*    GoodSink: Report and rethrow FileNotFoundException
*    BadSink : Catch FileNotFoundException, but don't do anything about it
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.*;

public class CWE390_Error_Without_Action__reader_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
        default:
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
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch(7)
        {
        case 7:
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
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
        break;
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
