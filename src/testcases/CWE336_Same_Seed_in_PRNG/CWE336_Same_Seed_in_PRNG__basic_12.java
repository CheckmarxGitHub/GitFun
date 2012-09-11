/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE336_Same_Seed_in_PRNG__basic_12.java
Label Definition File: CWE336_Same_Seed_in_PRNG__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 336 Same Seed in PRNG
* Sinks:
*    GoodSink: canonicalize before validate
*    BadSink : hardcoded seed
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE336_Same_Seed_in_PRNG;

import testcasesupport.*;

import javax.servlet.http.*;
import java.security.SecureRandom;

public class CWE336_Same_Seed_in_PRNG__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            final byte[] SEED = new byte[] {0x01, 0x02, 0x03, 0x04, 0x05};
            SecureRandom r = new SecureRandom();
            /* FLAW: using the same seed can make the PRNG sequence predictable if the seed is known */
            r.setSeed(SEED);
            IO.writeLine("" + r.nextInt()); /* run this several times and notice that the bad values are always the same */
            IO.writeLine("" + r.nextInt());
        }
        else {

            SecureRandom r = new SecureRandom(); /* FIX: no explicit seed specified; produces far less predictable PRNG sequence */

            IO.writeLine("" + r.nextInt());
            IO.writeLine("" + r.nextInt());

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            SecureRandom r = new SecureRandom(); /* FIX: no explicit seed specified; produces far less predictable PRNG sequence */
            IO.writeLine("" + r.nextInt());
            IO.writeLine("" + r.nextInt());
        }
        else {

            SecureRandom r = new SecureRandom(); /* FIX: no explicit seed specified; produces far less predictable PRNG sequence */

            IO.writeLine("" + r.nextInt());
            IO.writeLine("" + r.nextInt());

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
