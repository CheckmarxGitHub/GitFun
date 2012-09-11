/* TEMPLATE GENERATED TESTCASE FILE
Filename: CWE379_File_Creation_in_Insecure_Dir__basic_15.java
Label Definition File: CWE379_File_Creation_in_Insecure_Dir__basic.label.xml
Template File: point-flaw-15.tmpl.java
*/
/*
* @description
* CWE: 379 File Creation in Insecure Directory
* Sinks: perm
*    GoodSink: securely create dir
*    BadSink : permissions never set on dir
* Flow Variant: 15 Control flow: switch(7)
*
* */

package testcases.CWE379_File_Creation_in_Insecure_Dir;

import testcasesupport.*;

import javax.servlet.http.*;
import java.io.*;

public class CWE379_File_Creation_in_Insecure_Dir__basic_15 extends AbstractTestCase
{

    public void bad() throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\insecureDir"; /* may have to be changed depending on script */
            /* POSSIBLE FLAW: potentially insecure directory permissions */
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }
            try
            {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\basic\\insecureDir";
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }
            /* FIX: explicitly set directory permissions */
            dir.setExecutable(false, true);
            dir.setReadable(true);
            dir.setWritable(false, true);
            try
            {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }
        }
        break;
        }
    }

    /* good1() change the switch to switch(8) */
    private void good1() throws Throwable
    {
        switch(8)
        {
        case 7:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\insecureDir"; /* may have to be changed depending on script */
            /* POSSIBLE FLAW: potentially insecure directory permissions */
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }
            try
            {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }
        }
        break;
        default:
        {
            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\basic\\insecureDir";
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }
            /* FIX: explicitly set directory permissions */
            dir.setExecutable(false, true);
            dir.setReadable(true);
            dir.setWritable(false, true);
            try
            {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }
        }
        break;
        }
    }

    /* good2() reverses the blocks in the switch  */
    private void good2() throws Throwable
    {
        switch(7)
        {
        case 7:
        {
            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\basic\\insecureDir";
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }
            /* FIX: explicitly set directory permissions */
            dir.setExecutable(false, true);
            dir.setReadable(true);
            dir.setWritable(false, true);
            try
            {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }
        }
        break;
        default:
            /* INCIDENTAL: CWE 561 Dead Code, the code below will never run */
        {
            String fn = ".\\src\\testcases\\CWE379_File_Creation_in_Insecure_Dir\\insecureDir"; /* may have to be changed depending on script */
            /* POSSIBLE FLAW: potentially insecure directory permissions */
            File dir = new File(fn);
            if( dir.exists() )
            {
                IO.writeLine("Directory already exists");
                if( dir.delete() )
                {
                    IO.writeLine("Directory deleted");
                }
                else
                {
                    return;
                }
            }
            if( !dir.getParentFile().canWrite() )
            {
                IO.writeLine("Cannot write to parent dir");
            }
            try
            {
                boolean success = dir.mkdir();
                if( success )
                {
                    IO.writeLine("Directory created");
                    File file = new File(dir.getAbsolutePath() + "\\newFile.txt");
                    file.createNewFile();
                }
            }
            catch ( Exception e )
            {
                System.out.println(e.getMessage());
            }
        }
        break;
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
