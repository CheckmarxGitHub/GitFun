/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE483_Incorrect_Block_Delimitation__semicolon_07.java
Label Definition File: CWE483_Incorrect_Block_Delimitation.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 483 Incorrect Block Delimitation
* Sinks: semicolon
*    GoodSink: Absence of suspicious semicolon
*    BadSink : Suspicious semicolon before the if statement brace
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE483_Incorrect_Block_Delimitation;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE483_Incorrect_Block_Delimitation__semicolon_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad() throws Throwable
    {
        if (private_five==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1() throws Throwable
    {
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_five==5)
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
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

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
