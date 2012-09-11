/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE605_Multiple_Binds_Same_Port__basic_17.java
Label Definition File: CWE605_Multiple_Binds_Same_Port__basic.label.xml
Template File: point-flaw-17.tmpl.java
*/
/*
* @description
* CWE: 605 Multiple binds to the same port
* Sinks:
*    GoodSink: two binds on different ports
*    BadSink : two binds on one port
* Flow Variant: 17 Control flow: for loops
*
* */

package testcases.CWE605_Multiple_Binds_Same_Port;

import testcasesupport.*;

import java.net.ServerSocket;
import java.net.InetSocketAddress;

public class CWE605_Multiple_Binds_Same_Port__basic_17 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 1; for_index_j++)
        {
            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));
            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15000)); /* FLAW - This will bind a second
	   Socket to port 15000, but only for connections from localhost */
        }

        for(int for_index_k = 0; for_index_k < 0; for_index_k++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));
            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15001)); /* FIX - This will bind the second
	   Socket to a different port */
        }
    }

    /* good1() change the conditions on the while statements */
    private void good1() throws Throwable
    {
        for(int for_index_j = 0; for_index_j < 0; for_index_j++)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            ServerSocket sock1 = new ServerSocket();
            sock1.bind(new InetSocketAddress(15000));
            ServerSocket sock2 = new ServerSocket();
            sock2.bind(new InetSocketAddress("localhost", 15000)); /* FLAW - This will bind a second
	   Socket to port 15000, but only for connections from localhost */
        }

        for(int for_index_k = 0; for_index_k < 1; for_index_k++)
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
