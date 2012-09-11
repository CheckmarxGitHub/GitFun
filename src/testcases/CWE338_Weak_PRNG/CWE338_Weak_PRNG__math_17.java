/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__math_17.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: math
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.SecureRandom;
import java.util.Random;

public class CWE338_Weak_PRNG__math_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            /* FLAW: Math.random() is a known weak PRNG */
            IO.writeLine("" + Math.random());
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom r = new SecureRandom();
            IO.writeLine("" + r.nextDouble());
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: Math.random() is a known weak PRNG */
            IO.writeLine("" + Math.random());
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
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
