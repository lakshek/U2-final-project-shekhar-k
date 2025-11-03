// Import Link from router DOM
import { Link, useNavigate } from 'react-router-dom';

// import image 
import BrainIcon from '../assets/BrainIcon.jpg';
import { useState } from 'react';

export default function Header() {

    const navigate = useNavigate();
    const userName = localStorage.getItem('userName');
    
    // Toggle menu visibility
    const [menuOpen, setMenuOpen] = useState(false)

    // Handle logout function - blank out local storage and navigate to login page
    function handleLogout() {
        localStorage.removeItem('userName');
        localStorage.removeItem(userId);
        navigate('/login');
    }

    // Toggle menu
    function toggleMenu() {
        setMenuOpen(!menuOpen);
    }

    // Close menu when a navigation link is clicked
    function handleNavClick() {
        setMenuOpen(false);
    }

    return (

        <header>

            <div className="header-top">

                <div className="logo-title">
                    <img src={BrainIcon} alt="An image of connected lines with dots in the shape of human brain" />
                    <h1>Wired2Learn</h1>
                </div>

                {/* Hamburger icaon visible on small screens */}
                <button
                    className="menu-toggle"
                    onClick={toggleMenu}
                    aria-label="Toggle-navigation"    
                >
                    ☰
                </button>

            </div>

            {/* Navigation links */}
            <nav className={menuOpen ? "nav-open" : ""}>

                <ul>
                    <li><Link to="/" onClick={handleNavClick}>Home</Link></li>
                    <li><Link to="/moments" onClick={handleNavClick}>Moments Matter</Link></li>
                    <li><Link to="/intentional" onClick={handleNavClick}>Be Intentional</Link></li>
                    <li><Link to="/explore" onClick={handleNavClick}>Explore</Link></li>
                    <li><Link to="/comment" onClick={handleNavClick}>Comment</Link></li>

                    {/* Conditional rendering for Login/Register or logout */}
                    {!userName ? (
                        <>
                            <li><Link to="/register" onClick={handleNavClick}>Register</Link></li>
                            <li><Link to="/login" onClick={handleNavClick}>Login</Link></li>
                        </>
                    ) : (
                        <li>
                            <button onClick={handleLogout}>Logout ({userName})</button>
                        </li>
                    )}
                </ul>

            </nav>

        </header>

    ); 

}