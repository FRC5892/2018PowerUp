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
echo "public class $1 extends DynamicAuton {" >> $1.java
echo "" >> $1.java
echo "    @Override" >> $1.java
echo "    protected Command buildCommand(char pos, String gameData) {" >> $1.java
echo "        return new $1CG(pos, gameData);" >> $1.java
echo "    }" >> $1.java
echo "" >> $1.java
echo "    private class $1CG extends CommandGroup {" >> $1.java
echo "        $1CG(char pos, String gameData) {" >> $1.java
echo "" >> $1.java
echo "        }" >> $1.java
echo "    }" >> $1.java
echo "}" >> $1.java

