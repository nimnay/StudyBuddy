# StudyBuddy

> **A modern web application for university students to find study partners, organize study sessions, and collaborate on coursework.**

[![React](https://img.shields.io/badge/React-18-blue)](https://reactjs.org/)
[![Vite](https://img.shields.io/badge/Vite-4.5-646CFF)](https://vitejs.dev/)
[![Node.js](https://img.shields.io/badge/Node.js-18+-green)](https://nodejs.org/)

## 🌟 Overview

StudyBuddy is a sleek, dark-themed web platform designed to help university students connect with classmates, form study groups, and organize collaborative learning sessions. Built with modern React and featuring a professional user interface.

![StudyBuddy Preview](https://via.placeholder.com/800x400/1a1a2e/ffffff?text=StudyBuddy+Dark+Theme)

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
- Modern web browser (Chrome, Firefox, Safari, Edge)

### Installation & Running

1. **Clone the repository**
   ```bash
   git clone https://github.com/nimnay/studybuddy.git
   cd studybuddy
   ```

2. **Start the application**
   ```bash
   # Windows
   .\start-frontend.bat
   
   # macOS/Linux
   cd frontend
   npm install
   npm run dev
   ```

3. **Open your browser**
   - Navigate to `http://localhost:3000` (or the port shown in terminal)
   - The app runs in demo mode with sample data

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
├── models/                   # Java backend models (future integration)
├── start-frontend.bat       # Windows start script
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

### **Backend (Future Development)**
- 📋 Java Spring Boot REST API (planned)
- 📋 Database integration (planned)
- 📋 User authentication (planned)
- 📋 Real-time notifications (planned)

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

## 🎨 Design Features

- **Color Palette**: Professional dark theme with purple/blue accents
- **Typography**: Clear hierarchy with modern fonts
- **Components**: Reusable card-based design system
- **Animations**: Smooth transitions and micro-interactions
- **Icons**: Emoji-based icons for personality and clarity

## 🛠️ Technologies Used

- **Frontend**: React 18, JavaScript ES6+, CSS3
- **Build Tool**: Vite for fast development and building
- **Router**: React Router for navigation
- **Styling**: Custom CSS with CSS Variables
- **Development**: Hot reload, ESLint, modern tooling

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

- Backend API integration with Java Spring Boot
- User authentication and authorization
- Real-time messaging and notifications
- Calendar integration for scheduling
- Mobile app development
- Advanced matching algorithms

---

**Built with ❤️ for the university community**

*StudyBuddy - Study Smarter, Together*