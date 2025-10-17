# StudyBuddy

> **A modern web application for university students to find study partners, organize study sessions, and collaborate on coursework.**

[![React](https://img.shields.io/badge/React-18-blue)](https://reactjs.org/)
[![Vite](https://img.shields.io/badge/Vite-4.5-646CFF)](https://vitejs.dev/)
[![Node.js](https://img.shields.io/badge/Node.js-18+-green)](https://nodejs.org/)

## 🌟 Overview

StudyBuddy is a sleek, dark-themed web platform designed to help university students connect with classmates, form study groups, and organize collaborative learning sessions. Built with modern React and featuring a professional user interface.


## ✨ Features

### 🎨 **Modern Dark Theme UI**
- **Professional Design System**: Comprehensive dark theme with gradient accents
- **Responsive Layout**: Mobile-first design that works on all devices
- **Smooth Animations**: Elegant transitions and hover effects
- **Accessibility**: High contrast colors and keyboard navigation support

### 👥 **Student Management**
- **Student Profiles**: Comprehensive profiles with contact info, academic details, and bio
- **Search & Filter**: Real-time search by name, email, or course with advanced filters
- **Course Selection**: Support for 20+ academic majors and programs
- **Availability Tracking**: Set and view student availability schedules
- **Rating System**: Track study session performance and peer ratings

### 📚 **Study Session Browser**
- **Session Discovery**: Browse available study sessions across all subjects
- **Detailed Information**: View session descriptions, schedules, and participant lists
- **Subject Categories**: Organized by academic subjects and difficulty levels
- **Location Tracking**: Campus room assignments and meeting details
- **Participant Management**: See who's joined and available spots

### 🔍 **Smart Features**
- **Advanced Search**: Multi-criteria filtering and sorting options
- **Real-time Updates**: Live data synchronization with instant feedback
- **Demo Mode**: Works offline with comprehensive sample data
- **Cross-platform**: Works in any modern web browser

### 📊 **Dashboard & Analytics**
- **Live Statistics**: Real-time counts of students, sessions, and active groups
- **Progress Tracking**: Monitor your study session participation
- **Academic Overview**: View supported courses and majors
- **Quick Actions**: Fast access to common tasks

## 🚀 Quick Start

### Prerequisites
- **Node.js** 18+ and npm installed
- **Java** 11+ (for backend)
- **Maven** 3.6+ (for backend)
- Modern web browser (Chrome, Firefox, Safari, Edge)

### Installation & Running

#### Option 1: Full Stack (Backend + Frontend)

1. **Clone the repository**
   ```bash
   git clone https://github.com/nimnay/studybuddy.git
   cd studybuddy
   ```

2. **Start both servers** (Windows)
   ```bash
   .\start-fullstack.bat
   ```

3. **Access the application**
   - Frontend: `http://localhost:3000`
   - Backend API: `http://localhost:8080/api`
   - H2 Database Console: `http://localhost:8080/h2-console`

#### Option 2: Frontend Only (Demo Mode)

1. **Clone the repository**
   ```bash
   git clone https://github.com/nimnay/studybuddy.git
   cd studybuddy
   ```

2. **Start frontend only**
   ```bash
   # Windows
   .\start-frontend.bat
   
   # macOS/Linux
   cd frontend
   npm install
   npm run dev
   ```

3. **Open your browser**
   - Navigate to `http://localhost:3000`
   - App runs in demo mode with sample data

#### Option 3: Manual Setup

**Backend:**
```bash
mvn spring-boot:run
```

**Frontend:**
```bash
cd frontend
npm install
npm run dev
```

## 🏗️ Project Structure

```
studybuddy/
├── frontend/                 # React frontend application
│   ├── src/
│   │   ├── components/      # React components (Home, Students, Sessions)
│   │   ├── services/        # API services and mock data
│   │   └── styles/          # CSS files with dark theme
│   ├── package.json         # Frontend dependencies
│   └── vite.config.js       # Vite configuration
├── controller/              # Spring Boot REST API controllers
│   ├── StudentController.java
│   └── SessionController.java
├── models/                  # Java backend data models
│   ├── Student.java
│   ├── StudySession.java
│   └── Availability.java
├── tests/                   # Backend unit tests
├── start-frontend.bat       # Windows start script (frontend only)
├── start-backend.bat        # Windows start script (backend only)
├── start-fullstack.bat      # Windows start script (both servers)
└── README.md                # This file
```

## 🎯 Current Implementation

### **Frontend (Fully Implemented)**
- ✅ Modern React 18 application with Vite
- ✅ Professional dark theme design system
- ✅ Student management with CRUD operations
- ✅ Study session browsing and discovery
- ✅ Comprehensive search and filtering
- ✅ Responsive mobile-friendly design
- ✅ Rich mock data with 12+ students and sessions
- ✅ Backend connection with automatic fallback

### **Backend (Implemented)**
- ✅ Spring Boot 2.7 REST API
- ✅ H2 in-memory database
- ✅ Student and Session controllers
- ✅ CORS configured for frontend
- ✅ RESTful endpoints for CRUD operations
- 📋 User authentication (planned)
- 📋 Real-time notifications (planned)

### **API Endpoints**

**Students:**
- `GET /api/students` - Get all students
- `GET /api/students/{id}` - Get student by ID
- `POST /api/students` - Create new student
- `PUT /api/students/{id}` - Update student
- `DELETE /api/students/{id}` - Delete student

**Study Sessions:**
- `GET /api/sessions` - Get all sessions
- `GET /api/sessions/{id}` - Get session by ID
- `POST /api/sessions` - Create new session
- `PUT /api/sessions/{id}` - Update session
- `DELETE /api/sessions/{id}` - Delete session

## 📱 Usage Guide

### **Adding Students**
1. Click "Add Student" on the Students page
2. Fill in name, email, course, and academic year
3. Add availability time slots
4. Save to create the profile

### **Browsing Study Sessions**
1. Visit the Sessions page to see all available sessions
2. Use filters to find sessions by subject or difficulty
3. View session details including participants and location
4. Sessions show real-time participant counts

### **Search & Discovery**
1. Use the search bar to find students by name, email, or course
2. Apply filters for specific courses or academic years
3. Sort results by various criteria (name, rating, sessions)
4. Click "View Profile" for detailed student information

### **Backend Connection**
- The app automatically detects if the backend is running
- If backend is unavailable, it falls back to demo mode with sample data
- Click "Retry Connection" on the home page to reconnect
- H2 Database Console credentials:
  - JDBC URL: `jdbc:h2:mem:testdb`
  - Username: `sa`
  - Password: (leave blank)

## 🎨 Design Features

- **Color Palette**: Professional dark theme with purple/blue accents
- **Typography**: Clear hierarchy with modern fonts
- **Components**: Reusable card-based design system
- **Animations**: Smooth transitions and micro-interactions
- **Icons**: Emoji-based icons for personality and clarity

## 🛠️ Technologies Used

### **Frontend**
- React 18, JavaScript ES6+, CSS3
- Vite for fast development and building
- React Router for navigation
- Axios for HTTP requests
- Custom CSS with CSS Variables

### **Backend**
- Spring Boot 2.7
- H2 In-memory Database
- Maven for dependency management
- RESTful API architecture
- CORS configuration for cross-origin requests

## 📈 Sample Data

The application includes comprehensive sample data:
- **12 Students** across multiple majors (CS, Math, Physics, Biology, etc.)
- **12 Study Sessions** with detailed descriptions and scheduling
- **Realistic Profiles** with ratings, availability, and academic info
- **Cross-subject Collaboration** showing interdisciplinary learning

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📄 License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## 🔮 Future Enhancements

- Advanced user authentication and authorization
- Real-time messaging between study partners
- Push notifications for session updates
- Calendar integration for scheduling
- Mobile app development (React Native)
- Advanced matching algorithms based on learning styles
- Session recording and note-sharing features
- Integration with university LMS systems

---

**Built with ❤️ for the university community**

*StudyBuddy - Study Smarter, Together*