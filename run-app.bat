@echo off
setlocal enabledelayedexpansion

REM Build the project
echo Building the project...
call mvn -DskipTests clean compile

if %ERRORLEVEL% NEQ 0 (
    echo Build failed!
    exit /b 1
)

REM Run the application
echo Starting application...

REM Get JavaFX JAR path and set module path
for /r "%USERPROFILE%\.m2\repository\org\openjfx" %%A in (javafx-*.jar) do (
    set "JAVAFX_JARS=!JAVAFX_JARS!;%%A"
)

REM Find all JARs needed
setlocal
set CLASSPATH=target\classes
for /r "%USERPROFILE%\.m2\repository" %%A in (*.jar) do (
    set "CLASSPATH=!CLASSPATH!;%%A"
)

java -cp "!CLASSPATH!" com.App

endlocal
