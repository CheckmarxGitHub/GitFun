/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE256_Plaintext_Storage_of_Password__fromFile_53b.java
Label Definition File: CWE256_Plaintext_Storage_of_Password.label.xml
Template File: sources-sinks-53b.tmpl.java
*/
/*
 * @description
 * CWE: 256 Plaintext Storage of a Password.  Read the password from a Properties file or a regular file.  In the good case, read the file from the console.
 * BadSource: fromFile Read data from a file (named C:\data.txt)
 * GoodSource: Read data from the console using readLine
 * Sinks: basic
 *    GoodSink: Use decrypted data as password to connect to DB
 *    BadSink : Use data as password to connect to DB
 * Flow Variant: 53 Data flow: data passed as an argument from one method through two others to a fourth; all four functions are in different classes in the same package
 *
 * */

package testcases.CWE256_Plaintext_Storage_of_Password;

import testcasesupport.*;

import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.security.GeneralSecurityException;
import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.sql.SQLException;

public class CWE256_Plaintext_Storage_of_Password__fromFile_53b
{

    public void bad_sink(String data ) throws Throwable
    {
        (new CWE256_Plaintext_Storage_of_Password__fromFile_53c()).bad_sink(data );
    }

    /* goodG2B() - use goodsource and badsink */
    public void goodG2B_sink(String data ) throws Throwable
    {
        (new CWE256_Plaintext_Storage_of_Password__fromFile_53c()).goodG2B_sink(data );
    }

    /* goodB2G() - use badsource and goodsink */
    public void goodB2G_sink(String data ) throws Throwable
    {
        (new CWE256_Plaintext_Storage_of_Password__fromFile_53c()).goodB2G_sink(data );
    }
}
