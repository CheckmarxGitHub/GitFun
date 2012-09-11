/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE477_Obsolete_Functions__Date_parse_10.java
Label Definition File: CWE477_Obsolete_Functions.label.xml
Template File: point-flaw-10.tmpl.java
*/
/*
* @description
* CWE: 477 Use of Obsolete Functions
* Sinks: Date_parse
*    GoodSink: Use of prefered java.text.DateFormat.parse(String)
*    BadSink : Use of deprecated java.util.Date.parse(String) method
* Flow Variant: 10 Control flow: if(IO.static_t) and if(IO.static_f)
*
* */

package testcases.CWE477_Obsolete_Functions;

import testcasesupport.*;

import java.net.*;
import java.text.*;
import java.util.*;
import java.io.*;
import javax.servlet.http.*;

public class CWE477_Obsolete_Functions__Date_parse_10 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_t)
        {
            /* FLAW: Use of deprecated Date.parse(String) method */
            long unixDate = java.util.Date.parse("2010-07-13 10:41:00");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: Use prefered DateFormat.parse(String) method */
            Date d = java.text.DateFormat.getInstance().parse("2010-07-13 10:41:00");

        }
    }

    /* good1() changes IO.static_t to IO.static_f */
    private void good1() throws Throwable
    {
        if(IO.static_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Use of deprecated Date.parse(String) method */
            long unixDate = java.util.Date.parse("2010-07-13 10:41:00");
        }
        else {

            /* FIX: Use prefered DateFormat.parse(String) method */
            Date d = java.text.DateFormat.getInstance().parse("2010-07-13 10:41:00");

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(IO.static_t)
        {
            /* FIX: Use prefered DateFormat.parse(String) method */
            Date d = java.text.DateFormat.getInstance().parse("2010-07-13 10:41:00");
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: Use of deprecated Date.parse(String) method */
            long unixDate = java.util.Date.parse("2010-07-13 10:41:00");

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
