/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE338_Weak_PRNG__util_14.java
Label Definition File: CWE338_Weak_PRNG.label.xml
Template File: point-flaw-14.tmpl.java
*/
/*
* @description
* CWE: 338 Use of Cryptographically Weak PRNG
* Sinks: util
*    GoodSink: stronger PRNG
*    BadSink : weak PRNG
* Flow Variant: 14 Control flow: if(IO.static_five==5) and if(IO.static_five!=5)
*
* */

package testcases.CWE338_Weak_PRNG;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.SecureRandom;
import java.util.Random;

public class CWE338_Weak_PRNG__util_14 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_five==5)
        {
            /* FLAW: java.util.Random() is considered a weak PRNG */
            Random r = new Random();
            IO.writeLine("" + r.nextInt());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom r = new SecureRandom();

            IO.writeLine("" + r.nextDouble());

        }
    }

    /* good1() changes IO.static_five==5 to IO.static_five!=5 */
    private void good1() throws Throwable
    {
        if(IO.static_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            /* FLAW: java.util.Random() is considered a weak PRNG */
            Random r = new Random();
            IO.writeLine("" + r.nextInt());
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
        if(IO.static_five==5)
        {
            /* FIX: java.security.SecureRandom is considered to be a strong PRNG */
            SecureRandom r = new SecureRandom();
            IO.writeLine("" + r.nextDouble());
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            /* FLAW: java.util.Random() is considered a weak PRNG */
            Random r = new Random();

            IO.writeLine("" + r.nextInt());

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
