/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__math_08.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-08.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: math
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 08 Control flow: if(private_returns_t()) and if(private_returns_f())
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.SecureRandom;
import java.util.Random;

public class CWE338_Weak_PRNG__math_08 extends AbstractTestCase
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
            /* FLAW: Math.random() is a known weak PRNG */
            IO.writeLine("" + Math.random());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom r = new SecureRandom();

            IO.writeLine("" + r.nextDouble());

        }
    }

    /* good1() changes private_returns_t() to private_returns_f() */
    private void good1() throws Throwable
    {
        if(private_returns_f())
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Math.random() is a known weak PRNG */
            IO.writeLine("" + Math.random());
        }
        else {

            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom r = new SecureRandom();

            IO.writeLine("" + r.nextDouble());

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_returns_t())
        {
            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom r = new SecureRandom();
            IO.writeLine("" + r.nextDouble());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: Math.random() is a known weak PRNG */
            IO.writeLine("" + Math.random());

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
