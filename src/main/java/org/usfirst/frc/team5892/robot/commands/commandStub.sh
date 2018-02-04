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

echo "package org.usfirst.frc.team5892.robot.commands;" >> $1.java
echo "" >> $1.java
echo "import edu.wpi.first.wpilibj.command.Command;" >> $1.java
echo "" >> $1.java
echo "public class $1 extends Command {" >> $1.java
echo "" >> $1.java
echo "    @Override" >> $1.java
echo "    protected void execute() {" >> $1.java
echo "" >> $1.java
echo "    }" >> $1.java
echo "" >> $1.java
echo "    @Override" >> $1.java
echo "    protected boolean isFinished() {" >> $1.java
echo "        return true;" >> $1.java
echo "    }" >> $1.java
echo "}" >> $1.java

