@echo off
if [%1]==[] goto noargs
if exist %1.java goto exists
echo package org.usfirst.frc.team5892.robot.commands;>> %1.java
echo[>> %1.java
echo import edu.wpi.first.wpilibj.command.Command;>> %1.java
echo[>> %1.java
echo public class %1 extends Command {>> %1.java
echo[>> %1.java
echo     @Override>> %1.java
echo     protected void execute() {>> %1.java
echo[>> %1.java
echo     }>> %1.java
echo[>> %1.java
echo     @Override>> %1.java
echo     protected boolean isFinished() {>> %1.java
echo         return true;>> %1.java
echo     }>> %1.java
echo }>> %1.java

goto :eof
:noargs
echo usage: %0 ^<filename^>
exit /B 1
:exists
echo The file already exists!
exit /B 1
