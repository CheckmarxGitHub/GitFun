/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE328_Reversible_One_Way_Hash__basic_07.java
Label Definition File: CWE328_Reversible_One_Way_Hash__basic.label.xml
Template File: point-flaw-07.tmpl.java
*/
/*
* @description
* CWE: 328 Bad case uses insecure cryptographic hashing algorithm (MD5). Good case uses secure cryptographic hashing algorithm (SHA-512).
* Sinks:
*    GoodSink: sha512
*    BadSink : md5
* Flow Variant: 07 Control flow: if(private_five==5) and if(private_five!=5)
*
* */

package testcases.CWE328_Reversible_One_Way_Hash;

import testcasesupport.*;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

public class CWE328_Reversible_One_Way_Hash__basic_07 extends AbstractTestCase
{

    /* The variable below is not declared "final", but is never assigned
       any other value so a tool should be able to identify that reads of
       this will always give its initialized value. */
    private int private_five = 5;

    public void bad() throws Throwable
    {
        if (private_five==5)
        {
            String input = "Test Input";
            /* FLAW: Insecure cryptographic hashing algorithm (MD5) */
            MessageDigest hash = MessageDigest.getInstance("MD5");
            byte[] hashv = hash.digest(input.getBytes()); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashv));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String input = "Test Input";

            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            byte[] hashv = hash.digest(input.getBytes()); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */

            IO.writeLine(IO.toHex(hashv));

        }
    }

    /* good1() changes private_five==5 to private_five!=5 */
    private void good1() throws Throwable
    {
        if(private_five!=5)
        {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
            String input = "Test Input";
            /* FLAW: Insecure cryptographic hashing algorithm (MD5) */
            MessageDigest hash = MessageDigest.getInstance("MD5");
            byte[] hashv = hash.digest(input.getBytes()); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashv));
        }
        else {

            String input = "Test Input";

            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            byte[] hashv = hash.digest(input.getBytes()); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */

            IO.writeLine(IO.toHex(hashv));

        }
    }

    /* good2() reverses the bodies in the if statement */
    private void good2() throws Throwable
    {
        if(private_five==5)
        {
            String input = "Test Input";
            /* FIX: Secure cryptographic hashing algorithm (SHA-512) */
            MessageDigest hash = MessageDigest.getInstance("SHA-512");
            byte[] hashv = hash.digest(input.getBytes()); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */
            IO.writeLine(IO.toHex(hashv));
        }
        else {
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */

            String input = "Test Input";

            /* FLAW: Insecure cryptographic hashing algorithm (MD5) */
            MessageDigest hash = MessageDigest.getInstance("MD5");
            byte[] hashv = hash.digest(input.getBytes()); /* INCIDENTAL FLAW: Hard-coded input to hash algorithm */

            IO.writeLine(IO.toHex(hashv));

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
