import { Link } from 'react-router-dom'
import { useState, useEffect } from 'react'
import { studentService, sessionService, getBackendStatus, retryBackendConnection } from '../services/api'
import './Home.css'

function Home() {
  const [demoMode, setDemoMode] = useState(false)
  const [stats, setStats] = useState({
    totalStudents: 0,
    totalSessions: 0,
    activeSessions: 0
  })
  const [loading, setLoading] = useState(true)

  useEffect(() => {
    // Check if backend is available and fetch stats
    const fetchStats = async () => {
      try {
        const [studentsRes, sessionsRes] = await Promise.all([
          studentService.getAllStudents(),
          sessionService.getAllSessions()
        ])
        
        setStats({
          totalStudents: studentsRes.data.length,
          totalSessions: sessionsRes.data.length,
          activeSessions: sessionsRes.data.filter(s => s.participants?.length > 1).length
        })
      } catch (error) {
        setDemoMode(true)
        // Set demo stats
        setStats({
          totalStudents: 3,
          totalSessions: 2,
          activeSessions: 1
        })
      } finally {
        setLoading(false)
      }
    }

    fetchStats()
  }, [])

  const features = [
    {
      icon: '👥',
      title: 'Find Study Partners',
      description: 'Connect with classmates who share your courses and academic interests',
      action: 'Browse Students',
      link: '/students',
      color: 'from-blue-500 to-cyan-500'
    },
    {
      icon: '📅',
      title: 'Schedule Sessions',
      description: 'Create and join study sessions with intelligent time conflict detection',
      action: 'View Sessions',
      link: '/sessions',
      color: 'from-purple-500 to-pink-500'
    },
    {
      icon: '🎯',
      title: 'Smart Matching',
      description: 'Get personalized session recommendations based on your availability',
      action: 'Create Profile',
      link: '/profile',
      color: 'from-green-500 to-emerald-500'
    }
  ]

  const quickActions = [
    { icon: '➕', label: 'Create Session', link: '/sessions?action=create', primary: true },
    { icon: '🔍', label: 'Find Students', link: '/students' },
    { icon: '📊', label: 'View Stats', link: '#stats' },
  ]

  const handleRetryBackend = async () => {
    const connected = await retryBackendConnection();
    if (connected) {
      setDemoMode(false);
      fetchStats(); // Refresh stats from backend
    }
  };

  return (
    <div className="home">
      {demoMode && (
        <div className="demo-banner animate-slide-in">
          <div className="demo-content">
            <span className="demo-icon">🚀</span>
            <div>
              <strong>Demo Mode Active</strong>
              <p>Backend not available - showcasing with sample data. Start backend with: start-backend.bat</p>
            </div>
            <button onClick={handleRetryBackend} className="demo-link" style={{ cursor: 'pointer' }}>
              Retry Connection →
            </button>
          </div>
        </div>
      )}

      <div className="hero-section">
        <div className="hero-content animate-fade-in">
          <div className="hero-badge">
            <span className="status-indicator"></span>
            Study Smarter, Together
          </div>
          <h1 className="hero-title">
            Welcome to <span className="gradient-text">StudyBuddy</span>
          </h1>
          <p className="hero-subtitle">
            The intelligent platform that connects students, organizes study groups, 
            and maximizes your academic success through collaborative learning.
          </p>
          
          <div className="hero-actions">
            {quickActions.map((action, index) => (
              <Link
                key={index}
                to={action.link}
                className={`btn ${action.primary ? 'btn-primary btn-lg' : 'btn-secondary'}`}
              >
                <span>{action.icon}</span>
                {action.label}
              </Link>
            ))}
          </div>
        </div>

        <div className="hero-stats" id="stats">
          <div className="stats-grid">
            <div className="stat-card">
              <div className="stat-value">{loading ? '...' : stats.totalStudents}</div>
              <div className="stat-label">Active Students</div>
            </div>
            <div className="stat-card">
              <div className="stat-value">{loading ? '...' : stats.totalSessions}</div>
              <div className="stat-label">Study Sessions</div>
            </div>
            <div className="stat-card">
              <div className="stat-value">{loading ? '...' : stats.activeSessions}</div>
              <div className="stat-label">Active Groups</div>
            </div>
          </div>
        </div>
      </div>

      <div className="features-section">
        <div className="section-header">
          <h2>Powerful Features</h2>
          <p>Everything you need to succeed academically</p>
        </div>

        <div className="features-grid">
          {features.map((feature, index) => (
            <div key={index} className="feature-card animate-slide-in" style={{ animationDelay: `${index * 0.1}s` }}>
              <div className={`feature-icon bg-gradient-to-r ${feature.color}`}>
                {feature.icon}
              </div>
              <div className="feature-content">
                <h3>{feature.title}</h3>
                <p>{feature.description}</p>
                <Link to={feature.link} className="feature-action">
                  {feature.action} →
                </Link>
              </div>
            </div>
          ))}
        </div>
      </div>

      <div className="majors-section">
        <div className="section-header">
          <h2>Supported Academic Programs</h2>
          <p>Join students from 20+ major fields of study</p>
        </div>

        <div className="majors-grid">
          {[
            { code: 'CPSC', name: 'Computer Science', icon: '💻' },
            { code: 'MATH', name: 'Mathematics', icon: '📊' },
            { code: 'PHYS', name: 'Physics', icon: '⚛️' },
            { code: 'BIO', name: 'Biology', icon: '🧬' },
            { code: 'CHEM', name: 'Chemistry', icon: '🧪' },
            { code: 'ENG', name: 'Engineering', icon: '⚙️' }
          ].map((major, index) => (
            <div key={index} className="major-chip">
              <span className="major-icon">{major.icon}</span>
              <div>
                <div className="major-code">{major.code}</div>
                <div className="major-name">{major.name}</div>
              </div>
            </div>
          ))}
        </div>
      </div>

      <div className="cta-section">
        <div className="cta-card">
          <div className="cta-content">
            <h2>Ready to Start Studying?</h2>
            <p>Join thousands of students who are already collaborating and achieving better results.</p>
            <div className="cta-actions">
              <Link to="/students" className="btn btn-primary btn-lg">
                Get Started →
              </Link>
              <Link to="/sessions" className="btn btn-secondary">
                Browse Sessions
              </Link>
            </div>
          </div>
          <div className="cta-visual">
            <div className="floating-card">
              <div className="card-header">
                <div className="card-avatar">👤</div>
                <div>
                  <div className="card-title">Study Group</div>
                  <div className="card-subtitle">CPSC 2150 • 3 members</div>
                </div>
              </div>
              <div className="card-status">
                <span className="status-online">● Online</span>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  )
}

export default Home
