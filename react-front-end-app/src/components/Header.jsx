// Import Link from router DOM
import { NavLink, useNavigate } from 'react-router-dom';
import Button from './Button';

// import image 
import BrainIcon from '../assets/BrainIcon.jpg';
import { useState, useEffect } from 'react';

export default function Header() {

    const navigate = useNavigate();
        
    // Toggle menu visibility
    const [userName, setUserName] = useState(sessionStorage.getItem('userName'));
    const [menuOpen, setMenuOpen] = useState(false);

    // Sync state with localStorage in case it changes elsewhere
    useEffect(() => {
        // Handle login/register updates (custom event)
        const updateUser = () => {
            setUserName(sessionStorage.getItem('userName'));
        };
        window.addEventListener('userChange', updateUser);

        // Automatically logout when tab/window closes
        const handleUnload = () => {
            sessionStorage.clear();
        };
        window.addEventListener('beforeunload', handleUnload);

        // Ensure menu is closed when header loads
        setMenuOpen(false);

        return () => {
            window.removeEventListener('userChange', updateUser);
            window.removeEventListener('beforeunload', handleUnload);
        };
    }, []);

    // Handle logout function - blank out local storage and navigate to login page
    function handleLogout() {
        sessionStorage.removeItem('userName');
        sessionStorage.removeItem('userId');
        setUserName(null);
        setMenuOpen(false);
        navigate('/login');
    }

    // Toggle menu
    function toggleMenu() {
        setMenuOpen(prev => !prev);
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
                    <li><NavLink to="/" onClick={handleNavClick}>Home</NavLink></li>
                    <li><NavLink to="/moments" onClick={handleNavClick}>Moments Matter</NavLink></li>
                    <li><NavLink to="/intentional" onClick={handleNavClick}>Be Intentional</NavLink></li>
                    <li><NavLink to="/explore" onClick={handleNavClick}>Explore</NavLink></li>
                    <li><NavLink to="/journal" onClick={handleNavClick}>Comment</NavLink></li>

                    {/* Conditional rendering for Login/Register or logout */}
                    {!userName ? (
                        <>
                            <li><NavLink to="/register" onClick={handleNavClick}>Register</NavLink></li>
                            <li><NavLink to="/login" onClick={handleNavClick}>Login</NavLink></li>
                        </>
                    ) : (
                        <li>
                            <Button
                                type = "button"
                                onClick={handleLogout}
                                label = {`Logout (${userName})`}
                            />
                        </li>
                    )}
                </ul>

            </nav>

        </header>

    ); 

}