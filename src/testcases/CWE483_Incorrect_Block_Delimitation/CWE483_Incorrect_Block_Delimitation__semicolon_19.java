/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE483_Incorrect_Block_Delimitation__semicolon_19.java
Label Definition File: CWE483_Incorrect_Block_Delimitation.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 483 Incorrect Block Delimitation
* Sinks: semicolon
*    GoodSink: Absence of suspicious semicolon
*    BadSink : Suspicious semicolon before the if statement brace
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE483_Incorrect_Block_Delimitation;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE483_Incorrect_Block_Delimitation__semicolon_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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

