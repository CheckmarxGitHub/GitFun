/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__math_19.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: math
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.SecureRandom;
import java.util.Random;

public class CWE338_Weak_PRNG__math_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            /* FLAW: Math.random() is a known weak PRNG */
            IO.writeLine("" + Math.random());

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom r = new SecureRandom();

            IO.writeLine("" + r.nextDouble());

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

            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom r = new SecureRandom();

            IO.writeLine("" + r.nextDouble());

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            /* FLAW: Math.random() is a known weak PRNG */
            IO.writeLine("" + Math.random());

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

