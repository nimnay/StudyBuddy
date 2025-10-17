@echo off
echo ========================================
echo   StudyBuddy - Starting Frontend
echo ========================================
echo.
echo Installing dependencies (if needed)...
cd /d "%~dp0frontend"

if not exist "node_modules\" (
    echo Installing npm packages...
    call npm install
) else (
    echo Dependencies already installed.
)

echo.
echo Starting development server...
echo Frontend will be available at: http://localhost:3000
echo.

call npm run dev

pause
