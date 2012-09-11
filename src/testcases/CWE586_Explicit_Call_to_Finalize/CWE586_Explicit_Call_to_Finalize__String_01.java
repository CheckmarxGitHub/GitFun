/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE586_Explicit_Call_to_Finalize__String_01.java
Label Definition File: CWE586_Explicit_Call_to_Finalize__String.label.xml
Template File: point-flaw-01.tmpl.java
*/
/*
* @description
* CWE: 586 Explicit call to finalize()
* Sinks:
*    GoodSink: let garbage collection invoke finalize
*    BadSink : explictly calling finalize()
* Flow Variant: 01 Baseline
*
* */

package testcases.CWE586_Explicit_Call_to_Finalize;

import testcasesupport.*;

import java.io.IOException;

public class CWE586_Explicit_Call_to_Finalize__String_01 extends AbstractTestCase
{

    public void bad() throws Throwable
    {

        CWE586_Explicit_Call_to_Finalize__TestObject badObj = new CWE586_Explicit_Call_to_Finalize__TestObject();
        try
        {
            badObj.sayHello();
        }
        catch (Exception e)
        {
            IO.writeLine("An error occurred.");
        }
        finally
        {
            /* cleanup */
            badObj.finalize(); /* FLAW: avoid explicitly invoking the finalize method on an object */
        }

    }

    public void good() throws Throwable
    {
        good1();
    }

    private void good1() throws Throwable
    {

        CWE586_Explicit_Call_to_Finalize__TestObject goodObj = new CWE586_Explicit_Call_to_Finalize__TestObject();
        try
        {
            goodObj.sayHello();
        }
        catch (Exception e)
        {
            IO.writeLine("An error occurred.");
        }
        finally
        {
            /* cleanup */
            goodObj = null; /* set reference to null and garbage collector will eventually
	  finalize the object */
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

