Test Cases
December 2010 Release for Java

This archive contains test cases intended for use by organizations and 
individuals that wish to study software assurance tools, such as static 
source code and binary analysis tools.

--------------------
What are test cases?
--------------------
Test cases are pieces of buildable code that can be used to study software 
assurance tools.  A test case targets exactly one type of flaw, but other, 
unrelated flaws may be incidentally present.  For example, the test case 
"CWE476_NULL_Pointer_Dereference__String_01" targets only a NULL Pointer 
Dereference flaw.  In addition to the construct containing the target flaw, 
each test case contains one or more non-flawed constructs that perform a 
function similar to the flawed construct.  

A test case may be contained entirely in one source code file or may be split 
between multiple files.  Below are some examples of test cases and the files 
associated with them.

Test case CWE476_NULL_Pointer_Dereference__String_01 consists of one file: 
CWE476_NULL_Pointer_Dereference__String_01.java

Test case CWE476_NULL_Pointer_Dereference__String_51 consists of two files: 
CWE476_NULL_Pointer_Dereference__String_51a.java and 
CWE476_NULL_Pointer_Dereference__String_51b.java

Test case CWE476_NULL_Pointer_Dereference__String_54 consists of five files: 
CWE476_NULL_Pointer_Dereference__String_54a.java, 
CWE476_NULL_Pointer_Dereference__String_54b.java, 
CWE476_NULL_Pointer_Dereference__String_54c.java, 
CWE476_NULL_Pointer_Dereference__String_54d.java, and 
CWE476_NULL_Pointer_Dereference__String_54e.java

Test case CWE563_Unused_Variable__unused_public_member_value_01 consists of 
two files: 
CWE563_Unused_Variable__unused_public_member_value_01_bad.java and 
CWE563_Unused_Variable__unused_public_member_value_01_good1.java

----------------------
Test case organization
----------------------
The test cases use the Common Weakness Enumeration (CWE) as a basis for the 
test case names and organization.  The test cases strive to use the most 
specific CWE entry for the target flaw.  

A test case is identified by three components in its name: 

 - The number and a possibly shortened CWE name of the target flaw.  This 
section of the test case name is ended with a double underscore ("__").
 - The functional variant name: A word or phrase that differentiates this test 
case from other test cases for this CWE.  This provides a way of separating a 
single CWE into multiple, more specific flaw types.  If the test case is a 
Java Servlet, the string "Servlet" will appear in the functional variant name.
 - The flow variant number: A two digit number that indicates the type of data 
or control flow in which the target flaw is placed.  Test cases with the same 
flow variant number have the same type of data or control flow.  Flow variant 
"01" indicates the simplest form of the flaw with no data or control flow 
logic.

Most of the test cases in this set were generated using source files and tools 
created by the team.  All of the test cases with a flow variant other than "01" 
and most of the "01" test cases were generated.  Generated test cases contain 
a comment in the first line which indicates that they were generated.

-------------
Prerequisites
-------------
Development and testing for this release of the test cases was done on the 
Microsoft Windows platform.  Other than the test case involving the use of the 
Java Native Interface (CWE 111), the test cases should work on other 
platforms.

Test cases were developed using the Oracle Java Development Kit (JDK) version 
6.  Libraries used by the test cases are included in this archive in the "lib" 
directory.  Other versions of the JDK and the libraries may work with the test 
cases.

The build files included in this archive use Apache Ant.  Development and 
testing was done using Ant version 1.8.1, but other versions may work.

The test case distribution also contains Python scripts.  Development and 
testing of those scripts was done using Python 3.1.2 for Windows, but other 
versions of Python 3 may work.

----------------------------------------
How to compile or analyze the test cases
----------------------------------------
There are two ways to compile or analyze these test cases: as a whole or as a 
separate .war for each Common Weakness Enumeration (CWE) entry.  Due to the 
number of files and the number of lines of code contained in these test cases, 
some software analysis tools may not be able to analyze the entirety of these 
test cases as a single unit.

To compile or analyze the test cases as a whole:

The test cases can be compiled into a single (large) .war file named 
"testcases.war" by running "ant" in the top level directory in this archive.  
This type of build can be used as a basis for analyzing the test cases as a 
whole by following instructions in the documentation for the tool being used.

To compile or analyze the test cases per CWE:

The test cases can also be compiled so that a separate .war file is generated 
for each CWE.  For an individual CWE, this is accomplished by running "ant" in 
the directory for that CWE (such in the directory "src\testcases\ 
CWE476_NULL_Pointer_Dereference\") which will create the file 
"Testcases_per_CWE.war".

NOTE: You may see the following output from the Java compiler:
[javac] Note: Some input files use or override a deprecated API.
[javac] Note: Recompile with -Xlint:deprecation for details.

These warnings can be ignored.

In order to automate the process of compiling the test cases in each CWE 
directory, the script "run_analysis_example_tool.py" can be used.  This script 
will go to each CWE directory and run "ant" (which must be in the path) to 
compile those test cases.  This script can also be used as the basis for a 
script to automate performing analysis on the test cases in each directory.  
The comments in the script provide an example of how this can be accomplished.

---------------
Desired results
---------------
When a software analysis tool is run on a test case, the desired result is for 
the tool to report one flaw of the target type.  That reported flaw should be 
in a method with the word "bad" in its name (such as bad() or  bad_sink()).  A 
correct report of this type is considered a "True Positive".  If the tool does 
not report a flaw of the target type in a "bad" method in a test case, it is 
considered a "False Negative".

It is also desired that the tool NOT report any flaws of the target type in a 
method with the word "good" in its name.  An incorrect report of this type is 
considered a "False Positive".

Because test cases may or may not contain flaws of non-target types, reports 
of flaws other than the target type are typically ignored when studying a 
tool.

-----------------------------------------------------------
How to update build files if changes are made to test cases
-----------------------------------------------------------
This archive contains two scripts that can be used to update the build files 
if changes are made to the set of test cases to be analyzed.  Using the test 
cases as distributed or after edits are made to existing test case files do 
NOT require the use of these scripts.  These scripts are only needed if test 
case files are deleted from the set or new test cases are added.  If new test 
cases are added to the test case set, care should be taken to follow the 
conventions and structure of existing test cases in order to prevent errors in 
these scripts or in compilation. 

update_Main_java_ServletMain_java_and_web_xml.py – Running this script will 
update files that are used when all of the test cases are compiled into a 
single .war file.

create_per_cwe_files.py – Running this script will update the files in each 
CWE directory that allow for building that CWE's test cases into a separate 
.war file.

