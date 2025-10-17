@echo off
echo ========================================
echo   StudyBuddy - Starting Backend Server
echo ========================================
echo.

REM Check if Maven is available
where mvn >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo Maven is not installed or not in PATH.
    echo.
    echo Please install Maven from: https://maven.apache.org/download.cgi
    echo Or use the Maven wrapper: mvnw.cmd
    echo.
    pause
    exit /b 1
)

echo Starting Spring Boot backend on port 8080...
echo Backend API will be available at: http://localhost:8080/api
echo H2 Console will be available at: http://localhost:8080/h2-console
echo.

call mvn spring-boot:run

pause
