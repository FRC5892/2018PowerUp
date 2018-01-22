import sys, os

BATCH_TEMPLATE = """@echo off
if [%1]==[] goto noargs
if exist %1.{ext:s} goto exists
{body:s}
goto :eof
:noargs
echo usage: %0 ^<filename^>
exit /B 1
:exists
echo The file already exists!
exit /B 1
"""

BASH_TEMPLATE = """#!/bin/bash

if [ -z $1 ]
then
  echo "usage: $0 <filename>"
  exit 1
fi

if [ -e $1.{ext:s} ]
then
  echo The file already exists!
  exit 1
fi

{body:s}
"""

def main(infile, outfile, ext):
    with open(infile, 'r') as inff:
        input = inff.readlines()
    tbody = ""
    for line in input:
        tbody += "echo {0:s} >> %1.{1:s}\n".format(line.rstrip(), ext)
    tbody = tbody.replace("&name", "%1")
    with open(outfile + ".bat", 'w') as batchout:
        batchout.write(BATCH_TEMPLATE.format(ext=ext, body=tbody).replace("echo  >>", "echo[ >>"))
    with open(outfile + ".sh", 'w') as bashout:
        bbody = tbody.replace("'", "\\'").replace('"', '\\"').replace("%1", "$1")
        bashout.write(BASH_TEMPLATE.format(ext=ext, body=bbody))
    os.chmod(outfile + ".sh", 0o777)

if __name__ == "__main__":
    try:
        main(*sys.argv[1:])
    except TypeError:
        print("usage: " + sys.argv[0] + " <inputfile> <outputfile> <extension>")