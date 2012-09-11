/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE321_Hard_Coded_Cryptographic_Key__basic_52c.java
Label Definition File: CWE321_Hard_Coded_Cryptographic_Key__basic.label.xml
Template File: sources-sink-52c.tmpl.java
*/
/*
 * @description
 * CWE: 321 Hard coded crypto key
 * BadSource:  hardcoded key
 * GoodSource: read key from console
 * Sinks:
 *    BadSink : use data as a key
 * Flow Variant: 53 Data flow: data passed as an argument from one method to another to another in three different classes in the same package
 *
 * */

package testcases.CWE321_Hard_Coded_Cryptographic_Key;

import testcasesupport.*;

import java.sql.*;
import javax.servlet.http.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.*;
import java.math.BigInteger;
import java.util.Properties;

import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.Cipher;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import java.security.InvalidAlgorithmParameterException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

public class CWE321_Hard_Coded_Cryptographic_Key__basic_52c
{

    public void bad_sink(String data ) throws Throwable
    {

        String sToEncrypt = "Super secret Squirrel";
        byte[] bToEncrypt = sToEncrypt.getBytes();

        /* POTENTIAL FLAW: use the potentially-hardcoded key for encryption */
        SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes(), "AES");

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);

        byte[] bCipherText = aesCipher.doFinal(bToEncrypt);

        IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */

    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {

        String sToEncrypt = "Super secret Squirrel";
        byte[] bToEncrypt = sToEncrypt.getBytes();

        /* POTENTIAL FLAW: use the potentially-hardcoded key for encryption */
        SecretKeySpec sKeySpec = new SecretKeySpec(data.getBytes(), "AES");

        Cipher aesCipher = Cipher.getInstance("AES");
        aesCipher.init(Cipher.ENCRYPT_MODE, sKeySpec);

        byte[] bCipherText = aesCipher.doFinal(bToEncrypt);

        IO.writeLine(IO.toHex(bCipherText)); /* Write encrypted data to console */

    }

}
