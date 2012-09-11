/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_19.java
Label Definition File: CWE329_Not_Using_Random_IV_with_CBC_Mode__basic.label.xml
Template File: point-flaw-19.tmpl.java
*/
/*
* @description
* CWE: 329 Not using random IV with CBC Mode
* Sinks:
*    GoodSink: use random iv
*    BadSink : use hardcoded iv
* Flow Variant: 19 Control flow: Dead code after an if(true) return
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

public class CWE329_Not_Using_Random_IV_with_CBC_Mode__basic_19 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        {

            byte[] text ="asdf".getBytes();
            byte[] iv ={
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
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
    }

    public void good() throws Throwable
    {
        good1();
    }

    /* good1() reverses the GoodSinkBody and the BadSinkBody so that the BadSinkBody never runs */
    private void good1() throws Throwable
    {
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
        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.  We need the "if(true)" because the Java Language Spec requires that unreachable code generate a compiler error */
        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            byte[] text ="asdf".getBytes();
            byte[] iv ={
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

