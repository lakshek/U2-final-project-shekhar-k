import { useState } from 'react'
import { HashRouter as Router, Routes, Route, HashRouter } from 'react-router-dom'

// import components
import Header from './components/Header'
import Footer from './components/Footer'
import HomePage from './pages/HomePage'
import AboutPage from './pages/AboutPage'
import ExplorePage from './pages/ExplorePage'
import CommentPage from './pages/CommentPage'

// import CSS 
import './App.css'

// import responsive CSS
import './Responsive.css'
import MomentsMatterPage from './pages/MomentsMatterPage'

export default function App() {

  return (

      <HashRouter>
        <Header />
          <main>
            <Routes>
              <Route path="/" element={<HomePage />} />
              <Route path="/about" element={<AboutPage />} />
              <Route path="/moments-matter" element={<MomentsMatterPage />} />
              <Route path="/explore" element={<ExplorePage />} />
              <Route path="/comment" element={<CommentPage />} />
            </Routes>
          </main>
        <Footer />
      </HashRouter>

  )

}

