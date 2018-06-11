@echo off
if [%1]==[] goto noargs
if exist %1.java goto exists
echo package org.usfirst.frc.team5892.robot.auton;>> %1.java
echo[>> %1.java
echo import edu.wpi.first.wpilibj.command.Command;>> %1.java
echo import edu.wpi.first.wpilibj.command.CommandGroup;>> %1.java
echo[>> %1.java
echo public class %1 extends DynamicAuton {>> %1.java
echo[>> %1.java
echo     @Override>> %1.java
echo     public boolean isCompatible(char pos) {>> %1.java
echo         return true;>> %1.java
echo     }>> %1.java
echo[>> %1.java
echo     @Override>> %1.java
echo     public Command buildAuto(String fieldData) {>> %1.java
echo         CommandGroup ret = new CommandGroup();>> %1.java
echo[>> %1.java
echo[>> %1.java
echo[>> %1.java
echo         return ret;>> %1.java
echo     }>> %1.java
echo }>> %1.java

goto :eof
:noargs
echo usage: %0 ^<filename^>
exit /B 1
:exists
echo The file already exists!
exit /B 1
