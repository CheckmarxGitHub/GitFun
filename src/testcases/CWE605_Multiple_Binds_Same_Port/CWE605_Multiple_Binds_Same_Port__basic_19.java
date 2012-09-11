/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE605_Multiple_Binds_Same_Port__basic_19.java
Label Definition File: CWE605_Multiple_Binds_Same_Port__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 605 Multiple binds to the same port
* Sinks:
*    GoodSink: two binds on different ports
*    BadSink : two binds on one port
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE605_Multiple_Binds_Same_Port;

import testcasesupport.*;

import java.net.ServerSocket;
import java.net.InetSocketAddress;

public class CWE605_Multiple_Binds_Same_Port__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));

            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15000)); /* FLAW - This will bind a second
	   Socket to port 15000, but only for connections from localhost */

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));

            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15001)); /* FIX - This will bind the second
	   Socket to a different port */

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

            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));

            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15001)); /* FIX - This will bind the second
	   Socket to a different port */

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));

            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15000)); /* FLAW - This will bind a second
	   Socket to port 15000, but only for connections from localhost */

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

