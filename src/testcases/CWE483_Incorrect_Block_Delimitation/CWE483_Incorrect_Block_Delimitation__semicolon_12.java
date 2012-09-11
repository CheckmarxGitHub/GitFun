/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE483_Incorrect_Block_Delimitation__semicolon_12.java
Label Definition File: CWE483_Incorrect_Block_Delimitation.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 483 Incorrect Block Delimitation
* Sinks: semicolon
*    GoodSink: Absence of suspicious semicolon
*    BadSink : Suspicious semicolon before the if statement brace
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE483_Incorrect_Block_Delimitation;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE483_Incorrect_Block_Delimitation__semicolon_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            int x;
            int y;
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            x = (rand.nextInt() % 3);
            y = 0;
            /* FLAW: Suspicious semicolon before the if statement brace
             */
            if (x == 0);
            {
                IO.writeLine("x == 0");
                y = 1;
            }
            if (y == 1) IO.writeLine("x was 0\n");
        }
        else {

            int x;
            int y;

            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            x = (rand.nextInt() % 3);
            y = 0;

            /* FIX: Remove the suspicious semicolon before the if statement brace */
            if (x == 0)
            {
                IO.writeLine("x == 0");
                y = 1;
            }

            if (y == 1) IO.writeLine("x was 0\n");

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            int x;
            int y;
            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            x = (rand.nextInt() % 3);
            y = 0;
            /* FIX: Remove the suspicious semicolon before the if statement brace */
            if (x == 0)
            {
                IO.writeLine("x == 0");
                y = 1;
            }
            if (y == 1) IO.writeLine("x was 0\n");
        }
        else {

            int x;
            int y;

            SecureRandom rand = SecureRandom.getInstance("SHA1PRNG");
            x = (rand.nextInt() % 3);
            y = 0;

            /* FIX: Remove the suspicious semicolon before the if statement brace */
            if (x == 0)
            {
                IO.writeLine("x == 0");
                y = 1;
            }

            if (y == 1) IO.writeLine("x was 0\n");

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
