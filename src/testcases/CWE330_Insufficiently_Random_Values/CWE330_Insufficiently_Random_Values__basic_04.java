/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE330_Insufficiently_Random_Values__basic_04.java
Label Definition File: CWE330_Insufficiently_Random_Values__basic.label.xml
Template File: point-flaw-04.tmpl.java
*/
/*
* @description
* CWE: 330 Insufficiently Random Values
* Sinks:
*    GoodSink: use SecureRandom
*    BadSink : hardcoded salt
* Flow Variant: 04 Control flow: if(private_final_t) and if(private_final_f)
*
* */

package testcases.CWE330_Insufficiently_Random_Values;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import java.security.SecureRandom;
import java.util.Random;

public class CWE330_Insufficiently_Random_Values__basic_04 extends AbstractTestCase
{

    /* The two variables below are declared "final", so a tool should
       be able to identify that reads of these will always return their
       initialized values. */
    private final boolean private_final_t = true;
    private final boolean private_final_f = false;

    public void bad() throws Throwable
    {
        if (private_final_t)
        {
            Random rand = new Random();
            /* FLAW: seed is static, making the numbers always occur in the same sequence */
            rand.setSeed(123456);
            IO.writeLine("Random int: " + rand.nextInt(100));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: use SecureRandom to be cryptographically secure */
            SecureRandom rand = new SecureRandom();
            IO.writeLine("Random int: " + rand.nextInt(100));

        }
    }

    /* good1() changes private_final_t to private_final_f */
    private void good1() throws Throwable
    {
        if(private_final_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            Random rand = new Random();
            /* FLAW: seed is static, making the numbers always occur in the same sequence */
            rand.setSeed(123456);
            IO.writeLine("Random int: " + rand.nextInt(100));
        }
        else {

            /* FIX: use SecureRandom to be cryptographically secure */
            SecureRandom rand = new SecureRandom();
            IO.writeLine("Random int: " + rand.nextInt(100));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_final_t)
        {
            /* FIX: use SecureRandom to be cryptographically secure */
            SecureRandom rand = new SecureRandom();
            IO.writeLine("Random int: " + rand.nextInt(100));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            Random rand = new Random();
            /* FLAW: seed is static, making the numbers always occur in the same sequence */
            rand.setSeed(123456);
            IO.writeLine("Random int: " + rand.nextInt(100));

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
