@echo off
echo ========================================
echo   StudyBuddy - Full Stack Application
echo ========================================
echo.
echo This will start both the backend and frontend servers.
echo.
echo Backend: http://localhost:8080/api
echo Frontend: http://localhost:3000
echo.

REM Check for Maven
where mvn >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo WARNING: Maven not found. Backend will not start.
    echo Install Maven from: https://maven.apache.org/download.cgi
    echo.
    echo Starting frontend only in DEMO MODE...
    timeout /t 3
    start cmd /k "cd /d %~dp0frontend && npm install && npm run dev"
    exit /b 0
)

REM Check for Node.js
where node >nul 2>&1
if %ERRORLEVEL% NEQ 0 (
    echo ERROR: Node.js is not installed.
    echo Please install Node.js from: https://nodejs.org/
    pause
    exit /b 1
)

echo Starting Backend Server...
start "StudyBuddy Backend" cmd /k "cd /d %~dp0 && mvn spring-boot:run"

echo Waiting for backend to start...
timeout /t 10

echo Starting Frontend Application...
start "StudyBuddy Frontend" cmd /k "cd /d %~dp0frontend && npm install && npm run dev"

echo.
echo ========================================
echo   Both servers are starting!
echo ========================================
echo.
echo Backend API: http://localhost:8080/api
echo H2 Console: http://localhost:8080/h2-console
echo Frontend: http://localhost:3000
echo.
echo Press any key to close this window...
pause >nul
