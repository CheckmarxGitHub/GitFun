/*
 * @description A helper class for CWE586_Explicit_Call_to_Finalize*.java
 * 
 * */
 
package testcases.CWE586_Explicit_Call_to_Finalize;

import testcasesupport.IO;

public class CWE586_Explicit_Call_to_Finalize__TestObject 
{
    /* The finalize method of built-in Java objects are hidden, so a 
     * custom object is used instead. Alternative to extend an object 
     * like FileInputStream and invoke the finalize() method from within
     * by overriding the close() method. e.g. super.finalize()
     */
    private String msg;
    
    public CWE586_Explicit_Call_to_Finalize__TestObject() 
    {
        this.msg = new String("hello world");
    }
    
    public void sayHello() 
    {
        IO.writeLine(this.msg);
    }
    
    protected void finalize() 
    {
        try
        {
            super.finalize();
        }
        catch(Throwable e)
        {
            IO.writeLine("Error finalizing");
        }
        
        IO.writeLine("finalizing TestObject");
    }
}
