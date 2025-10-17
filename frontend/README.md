# StudyBuddy Frontend

Modern React-based frontend for the StudyBuddy application.

## Tech Stack

- **React 18** - UI framework
- **Vite** - Build tool and dev server
- **React Router** - Client-side routing
- **Axios** - HTTP client for API calls
- **CSS3** - Styling

## Getting Started

### Prerequisites

- Node.js 16+ and npm

### Installation

1. Navigate to the frontend directory:
   ```bash
   cd frontend
   ```

2. Install dependencies:
   ```bash
   npm install
   ```

3. Start the development server:
   ```bash
   npm run dev
   ```

4. Open your browser to [http://localhost:3000](http://localhost:3000)

## Available Scripts

- `npm run dev` - Start development server
- `npm run build` - Build for production
- `npm run preview` - Preview production build
- `npm run lint` - Run ESLint

## Project Structure

```
frontend/
├── src/
│   ├── components/     # React components
│   │   ├── Navbar.jsx
│   │   ├── Home.jsx
│   │   ├── Students.jsx
│   │   └── Sessions.jsx
│   ├── services/       # API service layer
│   │   └── api.js
│   ├── App.jsx         # Main app component
│   ├── App.css         # App styles
│   ├── index.css       # Global styles
│   └── main.jsx        # Entry point
├── index.html
├── package.json
└── vite.config.js
```

## Features

- Browse and create student profiles
- View and create study sessions
- Responsive design
- Modern UI with smooth animations
- RESTful API integration

## API Integration

The frontend connects to the Spring Boot backend at `http://localhost:8080/api`.

Make sure the backend server is running before using the frontend.

## Building for Production

```bash
npm run build
```

The built files will be in the `dist/` directory.
