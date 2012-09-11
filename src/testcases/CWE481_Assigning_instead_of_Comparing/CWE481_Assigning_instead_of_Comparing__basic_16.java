/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE481_Assigning_instead_of_Comparing__basic_16.java
Label Definition File: CWE481_Assigning_instead_of_Comparing__basic.label.xml
Template File: point-flaw-16.tmpl.java
*/
/*
* @description
* CWE: 481 Assigning instead of Comparing
* Sinks:
*    GoodSink: Comparing
*    BadSink : Assigning instead of comparing
* Flow Variant: 16 Control flow: while(true) and while(local_f)
*
* */

package testcases.CWE481_Assigning_instead_of_Comparing;

import testcasesupport.*;

import java.security.SecureRandom;

public class CWE481_Assigning_instead_of_Comparing__basic_16 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        boolean local_f = false; /* This local variable is used because the
		  Java compiler will generate an error on while(false) and similar
		  constructs that evaluate to false.  This is the simplest construct
		  that will always be false and still compile. */

        while(true)
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero = true)   /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
            break;
        }

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero == true)   /* FIX: using == instead of = */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
            break;
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        boolean local_f = false;

        while(local_f)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero = true)   /* FLAW: should be == and INCIDENTIAL CWE 571 Expression Is Always True */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
            break;
        }

        while(true)
        {
            int i = (new SecureRandom()).nextInt(2); /* i will be 0 or 1 */
            boolean isZero = (i == 0);
            if(isZero == true)   /* FIX: using == instead of = */
            {
                IO.writeLine("i is 0");
            }
            IO.writeLine("isZero is: " + isZero);
            break;
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
