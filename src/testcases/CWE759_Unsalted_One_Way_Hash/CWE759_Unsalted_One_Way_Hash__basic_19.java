/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE759_Unsalted_One_Way_Hash__basic_19.java
Label Definition File: CWE759_Unsalted_One_Way_Hash__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 759 Use of one-way hash with no salt
* Sinks:
*    GoodSink: use a sufficiently random salt
*    BadSink : SHA512 with no salt
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE759_Unsalted_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class CWE759_Unsalted_One_Way_Hash__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            MessageDigest hash = MessageDigest.getInstance("SHA-512"); /* FLAW: SHA512 with no salt */
            byte[] hashv = hash.digest("hash me".getBytes());

            IO.writeLine(IO.toHex(hashv));

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            SecureRandom r = new SecureRandom();

            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes());

            IO.writeLine(IO.toHex(hashv));

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

            SecureRandom r = new SecureRandom();

            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            hash.update(r.getSeed(32));  /* FIX: Use a sufficiently random salt */
            byte[] hashv = hash.digest("hash me".getBytes());

            IO.writeLine(IO.toHex(hashv));

        }
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            MessageDigest hash = MessageDigest.getInstance("SHA-512"); /* FLAW: SHA512 with no salt */
            byte[] hashv = hash.digest("hash me".getBytes());

            IO.writeLine(IO.toHex(hashv));

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

