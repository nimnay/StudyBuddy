import axios from 'axios';
import { mockStudents, mockSessions } from './mockData.js';

const API_BASE_URL = 'http://localhost:8080/api';

const api = axios.create({
  baseURL: API_BASE_URL,
  headers: {
    'Content-Type': 'application/json',
  },
  timeout: 5000, // 5 second timeout
});

// Flag to track if backend is available
let backendAvailable = true;

// Helper function to handle API calls with fallback to mock data
const apiCall = async (apiFunction, mockData) => {
  if (!backendAvailable) {
    console.log('🔄 Using mock data (backend not available)');
    return { data: mockData };
  }
  
  try {
    const result = await apiFunction();
    return result;
  } catch (error) {
    console.warn('⚠️ Backend unavailable, falling back to mock data');
    backendAvailable = false;
    return { data: mockData };
  }
};

// Student API calls
export const studentService = {
  getAllStudents: () => apiCall(() => api.get('/students'), mockStudents),
  getStudentById: (id) => apiCall(() => api.get(`/students/${id}`), mockStudents.find(s => s.id == id)),
  createStudent: (student) => {
    if (!backendAvailable) {
      const newStudent = { ...student, id: Date.now() };
      mockStudents.push(newStudent);
      console.log('✅ Student added to mock data');
      return Promise.resolve({ data: newStudent });
    }
    return api.post('/students', student);
  },
  updateStudent: (id, student) => apiCall(() => api.put(`/students/${id}`, student), student),
  deleteStudent: (id) => {
    if (!backendAvailable) {
      const index = mockStudents.findIndex(s => s.id == id);
      if (index > -1) mockStudents.splice(index, 1);
      console.log('🗑️ Student removed from mock data');
      return Promise.resolve({ data: {} });
    }
    return api.delete(`/students/${id}`);
  },
  searchByMajor: (major) => apiCall(
    () => api.get(`/students/search?major=${major}`), 
    mockStudents.filter(s => s.major.toLowerCase().includes(major.toLowerCase()))
  ),
};

// Session API calls
export const sessionService = {
  getAllSessions: () => apiCall(() => api.get('/sessions'), mockSessions),
  getSessionById: (id) => apiCall(() => api.get(`/sessions/${id}`), mockSessions.find(s => s.id == id)),
  createSession: (session) => {
    if (!backendAvailable) {
      const newSession = { ...session, id: Date.now(), participants: [session.creator] };
      mockSessions.push(newSession);
      console.log('✅ Session added to mock data');
      return Promise.resolve({ data: newSession });
    }
    return api.post('/sessions', session);
  },
  updateSession: (id, session) => apiCall(() => api.put(`/sessions/${id}`, session), session),
  deleteSession: (id) => {
    if (!backendAvailable) {
      const index = mockSessions.findIndex(s => s.id == id);
      if (index > -1) mockSessions.splice(index, 1);
      console.log('🗑️ Session removed from mock data');
      return Promise.resolve({ data: {} });
    }
    return api.delete(`/sessions/${id}`);
  },
  searchByCourse: (course) => apiCall(
    () => api.get(`/sessions/search?course=${course}`),
    mockSessions.filter(s => s.course.toLowerCase().includes(course.toLowerCase()))
  ),
};

export default api;
