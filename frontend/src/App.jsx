import { Routes, Route } from 'react-router-dom'
import Navbar from './components/Navbar'
import Home from './components/Home'
import Students from './components/Students'
import Sessions from './components/Sessions'
import './App.css'

function App() {
  return (
    <div className="App">
      <Navbar />
      <div className="container">
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/students" element={<Students />} />
          <Route path="/sessions" element={<Sessions />} />
        </Routes>
      </div>
    </div>
  )
}

export default App
