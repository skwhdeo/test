@echo off
echo "loop start with param" %1 %2 %3
:loop
set /p MYNAME=""
echo echo=%MYNAME%
IF %MYNAME%==end (
  goto EOF
)
goto loop
:EOF