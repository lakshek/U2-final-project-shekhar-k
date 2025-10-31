// import React hook
import { useState } from "react";

// import Link from Roouter DOM
import { Link } from "react-router-dom";

// import ReactMarkDown to format text
import ReactMarkDown from 'react-markdown';

// import image used in Moments Matter page

// import long texts as variables used in Moments Matter page
import { momentsIntroText, momentsExtendedText } from "../data/texts";

export default function MomentsMatterPage() {

    // State variable to control whether expanded text is shown
    const [showExpanded, setShowExpanded] = useState(false);

    // Function to handle button click
    const handleShowExpanded = () => {
        setShowExpanded(true);
    }

    return (
        <section>

            {/* Page heading and image */}
            <div>
                <h2>Every Moment Matters</h2>
            </div>

            {/* Intro text. Use MarkDown to format text */}
            <div>
                <ReactMarkDown>{momentsIntroText}</ReactMarkDown>
            </div>

            {/* Show the button only if the extended text is not visible */}
            {!showExpanded && (
                <button onClick={handleShowExpanded}>
                    Why moments matter... biologically speaking
                </button>
            )}

            {/* Display expanded text when the button is clicked */}
            {showExpanded && (
                <div>
                    <ReactMarkDown>{momentsExtendedText}</ReactMarkDown>

                    {/* navigation to Be Intentional page */}
                    <Link to="/be-intentional" className="btn-link">
                        Be Intentional
                    </Link>
                </div>
            )}

        </section>
    )
}
