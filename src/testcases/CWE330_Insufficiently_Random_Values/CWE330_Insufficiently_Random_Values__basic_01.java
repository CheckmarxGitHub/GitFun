/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE330_Insufficiently_Random_Values__basic_01.java
Label Definition File: CWE330_Insufficiently_Random_Values__basic.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 330 Insufficiently Random Values
* Sinks:
*    GoodSink: use SecureRandom
*    BadSink : hardcoded salt
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE330_Insufficiently_Random_Values;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import java.security.SecureRandom;
import java.util.Random;

public class CWE330_Insufficiently_Random_Values__basic_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        Random rand = new Random();
        /* FLAW: seed is static, making the numbers always occur in the same sequence */
        rand.setSeed(123456);
        IO.writeLine("Random int: " + rand.nextInt(100));

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        /* FIX: use SecureRandom to be cryptographically secure */
        SecureRandom rand = new SecureRandom();
        IO.writeLine("Random int: " + rand.nextInt(100));

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

