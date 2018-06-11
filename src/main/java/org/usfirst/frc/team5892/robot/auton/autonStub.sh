#!/bin/bash

if [ -z $1 ]
then
  echo "usage: $0 <filename>"
  exit 1
fi

if [ -e $1.java ]
then
  echo The file already exists!
  exit 1
fi

echo "package org.usfirst.frc.team5892.robot.auton;" >> $1.java
echo "" >> $1.java
echo "import edu.wpi.first.wpilibj.command.Command;" >> $1.java
echo "import edu.wpi.first.wpilibj.command.CommandGroup;" >> $1.java
echo "" >> $1.java
echo "public class $1 implements AutonBuilder {" >> $1.java
echo "" >> $1.java
echo "    @Override" >> $1.java
echo "    public boolean isCompatible(char pos) {" >> $1.java
echo "        return true;" >> $1.java
echo "    }" >> $1.java
echo "" >> $1.java
echo "    @Override" >> $1.java
echo "    public Command buildAuto(String fieldData) {" >> $1.java
echo "        CommandGroup ret = new CommandGroup();" >> $1.java
echo "" >> $1.java
echo "" >> $1.java
echo "" >> $1.java
echo "        return ret;" >> $1.java
echo "    }" >> $1.java
echo "}" >> $1.java

