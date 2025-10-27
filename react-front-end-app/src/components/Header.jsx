// Import Link from router DOM
import { Link } from 'react-router-dom';

// import image 
import BrainIcon from '../assets/BrainIcon.jpg';

export default function Header() {
    return (

        <header>

            <div>
                <img src={BrainIcon} alt="An image of connected lines with dots in the shape of human brain" />
                <h1>Wired to Learn</h1>
            </div>

            <nav>

                <ul>
                    <li><Link to="/">Home</Link></li>
                    <li><Link to="/about">About</Link></li>
                    <li><Link to="/explore">Explore</Link></li>
                    <li><Link to="/comment">Comment</Link></li>
                </ul>

            </nav>

        </header>

    ) 

}