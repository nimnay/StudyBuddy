import React, { useState, useEffect } from 'react';
import { studentService } from '../services/api';
import './Students.css';

function Students() {
  const [students, setStudents] = useState([]);
  const [loading, setLoading] = useState(true);
  const [searchTerm, setSearchTerm] = useState('');
  const [selectedCourse, setSelectedCourse] = useState('');
  const [selectedYear, setSelectedYear] = useState('');
  const [sortBy, setSortBy] = useState('name');
  const [newStudent, setNewStudent] = useState({
    name: '',
    email: '',
    course: '',
    year: '',
    availabilitySlots: []
  });
  const [showForm, setShowForm] = useState(false);
  const [editingStudent, setEditingStudent] = useState(null);
  const [selectedStudent, setSelectedStudent] = useState(null);

  const courses = ['Computer Science', 'Mathematics', 'Physics', 'Engineering', 'Biology', 'Chemistry'];
  const years = [1, 2, 3, 4, 5, 6];

  useEffect(() => {
    loadStudents();
  }, []);

  const loadStudents = async () => {
    try {
      const response = await studentService.getAllStudents();
      setStudents(response.data);
    } catch (error) {
      console.error('Error loading students:', error);
      // Enhanced demo data
      setStudents([
        { 
          id: 1, 
          name: 'Alice Johnson', 
          email: 'alice@university.edu', 
          course: 'Computer Science', 
          year: 3,
          joinedDate: '2023-01-15',
          availabilitySlots: ['Monday 9:00-11:00', 'Wednesday 14:00-16:00'],
          studySessions: 5,
          rating: 4.8
        },
        { 
          id: 2, 
          name: 'Bob Smith', 
          email: 'bob@university.edu', 
          course: 'Mathematics', 
          year: 2,
          joinedDate: '2023-02-20',
          availabilitySlots: ['Tuesday 10:00-12:00', 'Thursday 15:00-17:00'],
          studySessions: 3,
          rating: 4.6
        },
        { 
          id: 3, 
          name: 'Carol Davis', 
          email: 'carol@university.edu', 
          course: 'Physics', 
          year: 4,
          joinedDate: '2023-01-08',
          availabilitySlots: ['Monday 13:00-15:00', 'Friday 09:00-11:00'],
          studySessions: 8,
          rating: 4.9
        },
        { 
          id: 4, 
          name: 'David Wilson', 
          email: 'david@university.edu', 
          course: 'Engineering', 
          year: 1,
          joinedDate: '2023-03-10',
          availabilitySlots: ['Wednesday 11:00-13:00', 'Friday 14:00-16:00'],
          studySessions: 2,
          rating: 4.4
        },
        { 
          id: 5, 
          name: 'Emma Brown', 
          email: 'emma@university.edu', 
          course: 'Biology', 
          year: 3,
          joinedDate: '2023-01-25',
          availabilitySlots: ['Monday 10:00-12:00', 'Thursday 13:00-15:00'],
          studySessions: 6,
          rating: 4.7
        }
      ]);
    } finally {
      setLoading(false);
    }
  };

  const filteredStudents = students
    .filter(student => 
      student.name.toLowerCase().includes(searchTerm.toLowerCase()) ||
      student.email.toLowerCase().includes(searchTerm.toLowerCase()) ||
      student.course.toLowerCase().includes(searchTerm.toLowerCase())
    )
    .filter(student => selectedCourse ? student.course === selectedCourse : true)
    .filter(student => selectedYear ? student.year === parseInt(selectedYear) : true)
    .sort((a, b) => {
      switch (sortBy) {
        case 'name':
          return a.name.localeCompare(b.name);
        case 'course':
          return a.course.localeCompare(b.course);
        case 'year':
          return a.year - b.year;
        case 'rating':
          return (b.rating || 0) - (a.rating || 0);
        case 'sessions':
          return (b.studySessions || 0) - (a.studySessions || 0);
        default:
          return 0;
      }
    });

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      if (editingStudent) {
        const response = await studentService.updateStudent(editingStudent.id, newStudent);
        setStudents(students.map(s => s.id === editingStudent.id ? response.data : s));
        setEditingStudent(null);
      } else {
        const response = await studentService.createStudent(newStudent);
        setStudents([...students, response.data]);
      }
      resetForm();
    } catch (error) {
      console.error('Error saving student:', error);
      // Demo mode
      const studentData = { 
        ...newStudent, 
        id: editingStudent ? editingStudent.id : Date.now(),
        joinedDate: editingStudent ? editingStudent.joinedDate : new Date().toISOString().split('T')[0],
        studySessions: editingStudent ? editingStudent.studySessions : 0,
        rating: editingStudent ? editingStudent.rating : 4.0
      };
      
      if (editingStudent) {
        setStudents(students.map(s => s.id === editingStudent.id ? studentData : s));
        setEditingStudent(null);
      } else {
        setStudents([...students, studentData]);
      }
      resetForm();
    }
  };

  const handleEdit = (student) => {
    setNewStudent({
      name: student.name,
      email: student.email,
      course: student.course,
      year: student.year,
      availabilitySlots: student.availabilitySlots || []
    });
    setEditingStudent(student);
    setShowForm(true);
  };

  const handleDelete = async (id) => {
    if (!window.confirm('Are you sure you want to remove this student?')) return;
    
    try {
      await studentService.deleteStudent(id);
      setStudents(students.filter(s => s.id !== id));
    } catch (error) {
      console.error('Error deleting student:', error);
      setStudents(students.filter(s => s.id !== id));
    }
  };

  const resetForm = () => {
    setNewStudent({ name: '', email: '', course: '', year: '', availabilitySlots: [] });
    setShowForm(false);
    setEditingStudent(null);
  };

  const addAvailabilitySlot = () => {
    setNewStudent({
      ...newStudent,
      availabilitySlots: [...(newStudent.availabilitySlots || []), '']
    });
  };

  const updateAvailabilitySlot = (index, value) => {
    const slots = [...(newStudent.availabilitySlots || [])];
    slots[index] = value;
    setNewStudent({ ...newStudent, availabilitySlots: slots });
  };

  const removeAvailabilitySlot = (index) => {
    const slots = [...(newStudent.availabilitySlots || [])];
    slots.splice(index, 1);
    setNewStudent({ ...newStudent, availabilitySlots: slots });
  };

  if (loading) {
    return (
      <div className="loading-state">
        <div className="loading-spinner"></div>
        <p>Loading students...</p>
      </div>
    );
  }

  return (
    <div className="students">
      {/* Header */}
      <div className="page-header">
        <div className="header-content">
          <div className="header-text">
            <h1>Students</h1>
            <p>Manage student profiles and track study progress</p>
          </div>
          <button 
            className="btn btn-primary"
            onClick={() => setShowForm(!showForm)}
          >
            <span className="icon">👤</span>
            {showForm ? 'Cancel' : 'Add Student'}
          </button>
        </div>
      </div>

      {/* Search and Filters */}
      <div className="filters-section">
        <div className="search-bar">
          <span className="search-icon">🔍</span>
          <input
            type="text"
            placeholder="Search students by name, email, or course..."
            value={searchTerm}
            onChange={(e) => setSearchTerm(e.target.value)}
          />
        </div>
        
        <div className="filter-controls">
          <select
            value={selectedCourse}
            onChange={(e) => setSelectedCourse(e.target.value)}
          >
            <option value="">All Courses</option>
            {courses.map(course => (
              <option key={course} value={course}>{course}</option>
            ))}
          </select>
          
          <select
            value={selectedYear}
            onChange={(e) => setSelectedYear(e.target.value)}
          >
            <option value="">All Years</option>
            {years.map(year => (
              <option key={year} value={year}>Year {year}</option>
            ))}
          </select>
          
          <select
            value={sortBy}
            onChange={(e) => setSortBy(e.target.value)}
          >
            <option value="name">Sort by Name</option>
            <option value="course">Sort by Course</option>
            <option value="year">Sort by Year</option>
            <option value="rating">Sort by Rating</option>
            <option value="sessions">Sort by Sessions</option>
          </select>
        </div>
      </div>

      {/* Form */}
      {showForm && (
        <div className="form-overlay">
          <form onSubmit={handleSubmit} className="student-form">
            <div className="form-header">
              <h3>{editingStudent ? 'Edit Student' : 'Add New Student'}</h3>
              <button type="button" className="close-btn" onClick={resetForm}>×</button>
            </div>
            
            <div className="form-grid">
              <div className="form-group">
                <label>Full Name</label>
                <input
                  type="text"
                  value={newStudent.name}
                  onChange={(e) => setNewStudent({...newStudent, name: e.target.value})}
                  placeholder="Enter student's full name"
                  required
                />
              </div>
              
              <div className="form-group">
                <label>Email Address</label>
                <input
                  type="email"
                  value={newStudent.email}
                  onChange={(e) => setNewStudent({...newStudent, email: e.target.value})}
                  placeholder="student@university.edu"
                  required
                />
              </div>
              
              <div className="form-group">
                <label>Course/Major</label>
                <select
                  value={newStudent.course}
                  onChange={(e) => setNewStudent({...newStudent, course: e.target.value})}
                  required
                >
                  <option value="">Select a course</option>
                  {courses.map(course => (
                    <option key={course} value={course}>{course}</option>
                  ))}
                </select>
              </div>
              
              <div className="form-group">
                <label>Academic Year</label>
                <select
                  value={newStudent.year}
                  onChange={(e) => setNewStudent({...newStudent, year: e.target.value})}
                  required
                >
                  <option value="">Select year</option>
                  {years.map(year => (
                    <option key={year} value={year}>Year {year}</option>
                  ))}
                </select>
              </div>
            </div>

            <div className="availability-section">
              <div className="section-header">
                <label>Availability Slots</label>
                <button type="button" onClick={addAvailabilitySlot} className="btn btn-outline">
                  + Add Slot
                </button>
              </div>
              
              {(newStudent.availabilitySlots || []).map((slot, index) => (
                <div key={index} className="availability-slot">
                  <input
                    type="text"
                    value={slot}
                    onChange={(e) => updateAvailabilitySlot(index, e.target.value)}
                    placeholder="e.g., Monday 9:00-11:00"
                  />
                  <button
                    type="button"
                    onClick={() => removeAvailabilitySlot(index)}
                    className="remove-slot-btn"
                  >
                    ×
                  </button>
                </div>
              ))}
            </div>
            
            <div className="form-actions">
              <button type="button" onClick={resetForm} className="btn btn-secondary">
                Cancel
              </button>
              <button type="submit" className="btn btn-primary">
                {editingStudent ? 'Update Student' : 'Add Student'}
              </button>
            </div>
          </form>
        </div>
      )}

      {/* Results Summary */}
      <div className="results-summary">
        <p>Showing {filteredStudents.length} of {students.length} students</p>
      </div>

      {/* Students Grid */}
      <div className="students-grid">
        {filteredStudents.map(student => (
          <div key={student.id} className="student-card">
            <div className="card-header">
              <div className="student-avatar">
                {student.name.split(' ').map(n => n[0]).join('').toUpperCase()}
              </div>
              <div className="student-basic-info">
                <h3>{student.name}</h3>
                <p className="student-email">{student.email}</p>
              </div>
              <div className="card-actions">
                <button onClick={() => handleEdit(student)} className="action-btn edit-btn">
                  ✏️
                </button>
                <button onClick={() => handleDelete(student.id)} className="action-btn delete-btn">
                  🗑️
                </button>
              </div>
            </div>
            
            <div className="student-details">
              <div className="detail-row">
                <span className="label">Course:</span>
                <span className="value">{student.course}</span>
              </div>
              <div className="detail-row">
                <span className="label">Year:</span>
                <span className="value">Year {student.year}</span>
              </div>
              {student.rating && (
                <div className="detail-row">
                  <span className="label">Rating:</span>
                  <span className="value rating">
                    ⭐ {student.rating.toFixed(1)}
                  </span>
                </div>
              )}
              {student.studySessions !== undefined && (
                <div className="detail-row">
                  <span className="label">Sessions:</span>
                  <span className="value">{student.studySessions} completed</span>
                </div>
              )}
            </div>
            
            {student.availabilitySlots && student.availabilitySlots.length > 0 && (
              <div className="availability-preview">
                <h4>Available Times:</h4>
                <div className="time-slots">
                  {student.availabilitySlots.slice(0, 2).map((slot, index) => (
                    <span key={index} className="time-slot">{slot}</span>
                  ))}
                  {student.availabilitySlots.length > 2 && (
                    <span className="more-slots">+{student.availabilitySlots.length - 2} more</span>
                  )}
                </div>
              </div>
            )}
            
            <div className="card-footer">
              <button 
                className="btn btn-outline"
                onClick={() => setSelectedStudent(student)}
              >
                View Profile
              </button>
            </div>
          </div>
        ))}
      </div>

      {/* Empty State */}
      {filteredStudents.length === 0 && (
        <div className="empty-state">
          <div className="empty-icon">👥</div>
          <h3>No students found</h3>
          <p>
            {students.length === 0 
              ? "Add your first student to get started with study groups!" 
              : "Try adjusting your search or filter criteria."
            }
          </p>
          {students.length === 0 && (
            <button onClick={() => setShowForm(true)} className="btn btn-primary">
              Add First Student
            </button>
          )}
        </div>
      )}

      {/* Student Profile Modal */}
      {selectedStudent && (
        <div className="modal-overlay" onClick={() => setSelectedStudent(null)}>
          <div className="student-profile-modal" onClick={(e) => e.stopPropagation()}>
            <div className="modal-header">
              <h2>{selectedStudent.name}</h2>
              <button onClick={() => setSelectedStudent(null)} className="close-btn">×</button>
            </div>
            <div className="modal-content">
              <div className="profile-section">
                <h3>Contact Information</h3>
                <p><strong>Email:</strong> {selectedStudent.email}</p>
                <p><strong>Course:</strong> {selectedStudent.course}</p>
                <p><strong>Academic Year:</strong> Year {selectedStudent.year}</p>
                {selectedStudent.joinedDate && (
                  <p><strong>Joined:</strong> {new Date(selectedStudent.joinedDate).toLocaleDateString()}</p>
                )}
              </div>
              
              {selectedStudent.availabilitySlots && selectedStudent.availabilitySlots.length > 0 && (
                <div className="profile-section">
                  <h3>Availability Schedule</h3>
                  <div className="availability-list">
                    {selectedStudent.availabilitySlots.map((slot, index) => (
                      <div key={index} className="availability-item">{slot}</div>
                    ))}
                  </div>
                </div>
              )}
              
              <div className="profile-section">
                <h3>Study Statistics</h3>
                <div className="stats-row">
                  {selectedStudent.studySessions !== undefined && (
                    <div className="stat-item">
                      <span className="stat-value">{selectedStudent.studySessions}</span>
                      <span className="stat-label">Sessions Completed</span>
                    </div>
                  )}
                  {selectedStudent.rating && (
                    <div className="stat-item">
                      <span className="stat-value">⭐ {selectedStudent.rating.toFixed(1)}</span>
                      <span className="stat-label">Average Rating</span>
                    </div>
                  )}
                </div>
              </div>
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default Students;
