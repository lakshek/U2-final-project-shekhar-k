// Import ReactMarkDown to format text
import ReactMarkDown from 'react-markdown';

// Import Link from Router DOM
import {Link} from 'react-router-dom';

// Import long texts as variables to be used in the page
import { intentionalText } from '../data/texts';

export default function BeIntentionalPage() {
    return (
        <section>
        
            {/* Page heading */}
            <div>
                <h2>Be Intentional</h2>
            </div>
            
            {/* Intro text. Use MarkDown to format text */}
            <div>
                <ReactMarkDown>{intentionalText}</ReactMarkDown>
            </div>
            
            {/* Navigation to Explore page */}
            <div>
                <Link to="/explore" className="btn-link">Explore to act with purpose</Link>
            </div>

        </section>
    );
}