/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE390_Error_Without_Action__mkdirs_01.java
Label Definition File: CWE390_Error_Without_Action.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 390 Detection of Error Condition Without Action
* Sinks: mkdirs
*    GoodSink: Throw Exception if dirs cannot be created
*    BadSink : Do nothing if dirs cannot be created
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE390_Error_Without_Action;

import testcasesupport.*;

import javax.servlet.http.*;

import java.io.File;
import java.lang.SecurityException;

public class CWE390_Error_Without_Action__mkdirs_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        File dirs = new File("./lvl_1/lvl_2/lvl_3/");
        if( !dirs.mkdirs() )
        {
            /* FLAW: do nothing if dirs cannot be created */
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        File dirs = new File("./lvl_1/lvl_2/lvl_3/");
        if( !dirs.mkdirs() )
        {
            /* FIX: report the mkdirs failure and throw a new Exception */
            IO.writeLine("The directories could not be created");
            StringBuilder sb = new StringBuilder();
            sb.append("The directories (");
            sb.append(dirs.getAbsolutePath());
            sb.append(") could not be created: ");
            throw new Exception(sb.toString());
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

