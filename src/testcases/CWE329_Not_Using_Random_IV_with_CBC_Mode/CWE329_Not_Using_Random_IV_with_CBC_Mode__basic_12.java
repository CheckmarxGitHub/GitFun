/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_12.java
Label Definition File: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic.label.xml
Template File: point-flaw-12.tmpl.java
*/
/*
* @description
* CWE: 329 Not using random IV with CBC Mode
* Sinks:
*    GoodSink: use random iv
*    BadSink : use hardcoded iv
* Flow Variant: 12 Control flow: if(IO.static_returns_t_or_f())
*
* */

package testcases.CWE329_Not_Using_Random_IV_with_CBC_Mode;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_12 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        if (IO.static_returns_t_or_f())
        {
            byte[] text ="asdf".getBytes();
            byte[] iv =
            {
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,
                0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00
            };
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();
            /* FLAW: hardcoded initialization vector used */
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            IvParameterSpec ips = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, ips);
            IO.writeLine(IO.toHex(cipher.doFinal(text)));
        }
        else {

            byte[] text ="asdf".getBytes();

            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            int block_size = cipher.getBlockSize();
            byte[] iv = new byte[block_size];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);

            /* FIX: using cryptographically secure pseudo-random number as initialization vector */
            IvParameterSpec ips = new IvParameterSpec(iv);

            cipher.init(Cipher.ENCRYPT_MODE, key, ips);

            IO.writeLine(IO.toHex(cipher.doFinal(text)));

        }
    }

    /* good1() changes the "if" so that both branches use the GoodSink */
    private void good1() throws Throwable
    {
        if(IO.static_returns_t_or_f())
        {
            byte[] text ="asdf".getBytes();
            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            int block_size = cipher.getBlockSize();
            byte[] iv = new byte[block_size];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);
            /* FIX: using cryptographically secure pseudo-random number as initialization vector */
            IvParameterSpec ips = new IvParameterSpec(iv);
            cipher.init(Cipher.ENCRYPT_MODE, key, ips);
            IO.writeLine(IO.toHex(cipher.doFinal(text)));
        }
        else {

            byte[] text ="asdf".getBytes();

            KeyGenerator kg = KeyGenerator.getInstance("AES");
            kg.init(128);
            SecretKey key = kg.generateKey();

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            int block_size = cipher.getBlockSize();
            byte[] iv = new byte[block_size];
            SecureRandom random = new SecureRandom();
            random.nextBytes(iv);

            /* FIX: using cryptographically secure pseudo-random number as initialization vector */
            IvParameterSpec ips = new IvParameterSpec(iv);

            cipher.init(Cipher.ENCRYPT_MODE, key, ips);

            IO.writeLine(IO.toHex(cipher.doFinal(text)));

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
