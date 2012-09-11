/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE605_Multiple_Binds_Same_Port__basic_12.java
Label Definition File: CWE605_Multiple_Binds_Same_Port__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 605 Multiple binds to the same port
* Sinks:
*    GoodSink: two binds on different ports
*    BadSink : two binds on one port
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE605_Multiple_Binds_Same_Port;

import testcasesupport.*;

import java.net.ServerSocket;
import java.net.InetSocketAddress;

public class CWE605_Multiple_Binds_Same_Port__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));
            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15000)); /* FLAW - This will bind a second
	   Socket to port 15000, but only for connections from localhost */
        }
        else {

            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));

            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15001)); /* FIX - This will bind the second
	   Socket to a different port */

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));
            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15001)); /* FIX - This will bind the second
	   Socket to a different port */
        }
        else {

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
