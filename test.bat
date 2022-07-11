@echo off
echo "loop start"
:loop
set /p MYNAME=""
echo echo=%MYNAME%
IF %MYNAME%==end (
  goto EOF
)
goto loop
:EOF