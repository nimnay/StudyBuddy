import { useState, useEffect } from 'react'
import { sessionService } from '../services/api'
import './Sessions.css'

function Sessions() {
  const [sessions, setSessions] = useState([])
  const [loading, setLoading] = useState(true)
  const [error, setError] = useState(null)
  const [showForm, setShowForm] = useState(false)
  const [formData, setFormData] = useState({
    course: '',
    time: '',
    creator: null,
    participants: []
  })

  useEffect(() => {
    fetchSessions()
  }, [])

  const fetchSessions = async () => {
    try {
      setLoading(true)
      const response = await sessionService.getAllSessions()
      setSessions(response.data)
      setError(null)
    } catch (err) {
      setError('Failed to load sessions. Please try again.')
      console.error(err)
    } finally {
      setLoading(false)
    }
  }

  const handleSubmit = async (e) => {
    e.preventDefault()
    try {
      await sessionService.createSession(formData)
      setShowForm(false)
      setFormData({ course: '', time: '', creator: null, participants: [] })
      fetchSessions()
    } catch (err) {
      setError('Failed to create session. Please try again.')
      console.error(err)
    }
  }

  const handleDelete = async (id) => {
    if (window.confirm('Are you sure you want to delete this session?')) {
      try {
        await sessionService.deleteSession(id)
        fetchSessions()
      } catch (err) {
        setError('Failed to delete session. Please try again.')
        console.error(err)
      }
    }
  }

  if (loading) return <div className="loading">Loading sessions...</div>

  return (
    <div className="sessions">
      <div className="sessions-header">
        <h1>Study Sessions</h1>
        <button className="btn btn-primary" onClick={() => setShowForm(!showForm)}>
          {showForm ? 'Cancel' : '+ Create Session'}
        </button>
      </div>

      {error && <div className="error">{error}</div>}

      {showForm && (
        <div className="card">
          <h2>Create New Study Session</h2>
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label>Course:</label>
              <input
                type="text"
                placeholder="e.g., CPSC 2150"
                value={formData.course}
                onChange={(e) => setFormData({ ...formData, course: e.target.value })}
                required
              />
            </div>
            <div className="form-group">
              <label>Time:</label>
              <input
                type="text"
                placeholder="e.g., Monday 7PM-8PM"
                value={formData.time}
                onChange={(e) => setFormData({ ...formData, time: e.target.value })}
                required
              />
            </div>
            <button type="submit" className="btn btn-success">Create Session</button>
          </form>
        </div>
      )}

      <div className="grid">
        {sessions.length === 0 ? (
          <p className="no-data">No sessions found. Create one to get started!</p>
        ) : (
          sessions.map(session => (
            <div key={session.id} className="session-card card">
              <div className="session-header">
                <h3>📘 {session.course}</h3>
                <span className="session-time">🕐 {session.time}</span>
              </div>
              <div className="session-details">
                <p><strong>Creator:</strong> {session.creator?.name || 'Unknown'}</p>
                <div className="participants">
                  <strong>Participants ({session.participants?.length || 0}/5):</strong>
                  <ul>
                    {session.participants && session.participants.length > 0 ? (
                      session.participants.map((participant, idx) => (
                        <li key={idx}>{participant.name}</li>
                      ))
                    ) : (
                      <li className="no-data">No participants yet</li>
                    )}
                  </ul>
                </div>
              </div>
              <div className="session-actions">
                <button className="btn btn-primary">Join</button>
                <button 
                  className="btn btn-danger" 
                  onClick={() => handleDelete(session.id)}
                >
                  Delete
                </button>
              </div>
            </div>
          ))
        )}
      </div>
    </div>
  )
}

export default Sessions
