/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE78_OS_Command_Injection__URLConnection_51b.java
Label Definition File: CWE78_OS_Command_Injection.label.xml
Template File: sources-sink-51b.tmpl.java
*/
/*
 * @description
 * CWE: 78 OS Command Injection
 * BadSource: URLConnection Read a string from a web server with URLConnection
 * GoodSource: A hardcoded string
 * BadSink: exec dynamic command execution with Runtime.getRuntime().exec()
 * Flow Variant: 51 Data flow: data passed as an argument from one function to another in different classes in the same package
 *
 * */

package testcases.CWE78_OS_Command_Injection;

import testcasesupport.*;

import javax.servlet.http.*;

public class CWE78_OS_Command_Injection__URLConnection_51b
{

    public void bad_sink(String data ) throws Throwable
    {

        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process p = Runtime.getRuntime().exec(osCommand + data);
        p.waitFor();

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {

        String osCommand;
        if(System.getProperty("os.name").toLowerCase().indexOf("win") >= 0)
        {
            /* running on Windows */
            osCommand = "c:\\WINDOWS\\SYSTEM32\\cmd.exe /c dir ";
        }
        else
        {
            /* running on non-Windows */
            osCommand = "/bin/ls ";
        }

        /* POTENTIAL FLAW: command injection */
        Process p = Runtime.getRuntime().exec(osCommand + data);
        p.waitFor();

    }
}