/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE789_Uncontrolled_Mem_Alloc__random_19.java
Label Definition File: CWE789_Uncontrolled_Mem_Alloc.int.label.xml
Template File: sources-sink-19.tmpl.java
*/
/*
* @description
* CWE: 789 Uncontrolled Memory Allocation
* BadSource: random Set data to a random value
* GoodSource: A hardcoded non-zero, non-min, non-max, even number
* BadSink: HashMap Create a HashMap using data as the initial size
* Flow Variant: 19 Control flow: Dead code after an if(true) return
*
* */

package testcases.CWE789_Uncontrolled_Mem_Alloc;

import testcasesupport.*;

import javax.servlet.http.*;

import java.security.SecureRandom;
import java.util.logging.Logger;

import java.util.HashMap;

public class CWE789_Uncontrolled_Mem_Alloc__random_19 extends AbstractTestCase
{

    /* uses badsource and badsink */
    public void bad() throws Throwable
    {
        int data;
        {

            Logger log_bad = Logger.getLogger("local-logger");

            SecureRandom r = new SecureRandom();
            data = r.nextInt();

            /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
            HashMap list = new HashMap(data);

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

            /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
            HashMap list = new HashMap(data);

        }
    }

    /* goodG2B() - use goodsource and badsink by moving BadSource and BadSink to after return */
    private void goodG2B() throws Throwable
    {
        int data;
        {

            java.util.logging.Logger log_good = java.util.logging.Logger.getLogger("local-logger");

            /* FIX: Use a hardcoded number that won't cause underflow, overflow,
                    divide by zero, or loss-of-precision issues */
            data = 2;

            /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
            HashMap list = new HashMap(data);

        }

        if(true) return; /* INCIDENTAL: CWE 571 Expression is Always True.
		  We need the "if(true)" because the Java Language Spec requires that
		  unreachable code generate a compiler error */

        /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {

            Logger log_bad = Logger.getLogger("local-logger");

            SecureRandom r = new SecureRandom();
            data = r.nextInt();

            /* POTENTIAL FLAW: Create a HashMap using data as the initial size.  data may be very large, creating memory issues */
            HashMap list = new HashMap(data);

        }
    }

    public void good() throws Throwable
    {
        goodG2B();
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
