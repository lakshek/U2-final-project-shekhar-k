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

            


        </section>
    )
}
