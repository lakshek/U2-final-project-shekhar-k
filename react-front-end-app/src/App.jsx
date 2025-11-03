import { useState } from 'react'
import { HashRouter as Router, Routes, Route, HashRouter } from 'react-router-dom'

// import components
import Header from './components/Header'
import Footer from './components/Footer'
import HomePage from './pages/HomePage'
import MomentsMatterPage from './pages/MomentsMatterPage'
import BeIntentionalPage from './pages/BeIntentionalPage'
import ExplorePage from './pages/ExplorePage'
import CommentPage from './pages/JournalPage'
import RegisterPage from './pages/RegisterPage'
import LoginPage from './pages/LoginPage'

// import CSS 
import './App.css'

// import responsive CSS
import './Responsive.css'

export default function App() {

  return (

      <HashRouter>
        <Header />
          <main>
            <Routes>
              <Route path="/" element={<HomePage />} />
              <Route path="/moments" element={<MomentsMatterPage />} />
              <Route path="intentional" element={<BeIntentionalPage />} />
              <Route path="/explore" element={<ExplorePage />} />
              <Route path="/journal" element={<CommentPage />} />
              <Route path="/register" element={<RegisterPage />} />
              <Route path="/login" element={<LoginPage />} />
            </Routes>
          </main>
        <Footer />
      </HashRouter>

  )

}

