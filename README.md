# Coding Challenge

### Server - Backend

<details open="open">
   <ul>
      <li><a href="http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html">JDK</a> - Java™ Platform, Standard Edition Development Kit</li>
   </ul>
</details>

### Others

<details open="open">
   <ul>
      <li><a href="https://git-scm.com/">git</a> - Free and Open-Source distributed version control system</li>
   </ul>
</details>

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing
purposes.

## Installing

#### Running the application with IDE

There are several ways to run a Java application on your local machine. One way is to execute the `main` method
in the `com.company.Main` class from your IDE.

* Download the zip or clone the Git repository.
* Unzip the zip file (if you downloaded one)
* Open Intellij
    * File -> Open -> Navigate to the folder where you unzipped the zip
    * Select the project
*  Click on Run -> Edit Configurations --> pass the arguments in HH:MM format
   (even if input is 1, user needs to input 01)
* Right Click on the Main.java file and Run Application
* Pass the config to get the output in the format **MM HH script_path**

#### Running the application with Executable JAR

Run the jar by double-clicking on it
or by using the command

```shell
$ git clone https://github.com/ppagote/Lyst.git
$ cd Lyst/out/artifacts/Lyst_jar
$ java -jar Lyst.jar <args>

  where args is HH:MM format (even if input is 1,
   user needs to input 01)
$ Pass the config to get the output in the format **MM HH script_path**
```

To shut down the jar, follow the below mentioned steps on a Windows machine.

* In command prompt execute the **jcmd** command to print a list of all running Java processes
* **Task kill /PID PROCESS_ID_OF_RUNNING_APP /F** execute this command by replacing the **PROCESS_ID_OF_RUNNING_APP**
  with the actual process id of the running jar found out from executing the previous command
* Press Ctrl+C

<!-- CONTACT -->

## Contact

Pranav Pagote - pranav1990.pagote@gmail.com

Project Link: [https://github.com/ppagote/Lyst](https://github.com/ppagote/Lyst.git)