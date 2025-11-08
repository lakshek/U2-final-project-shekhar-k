// Import React hook
import { useState } from "react";

// Import Link from Router DOM
import { Link } from "react-router-dom";

// Import ReactMarkDown to format text
import ReactMarkDown from 'react-markdown';

// Import image used in Moments Matter page
import Neuron from '../assets/Neuron.gif' 
import NeuralConnections from '../assets/NeuralConnections.jpg'

// Import long texts as variables used in Moments Matter page
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

                <img
                    src={Neuron}
                    alt="Neuron image showing signals moving from axon to dendrites"
                    className='neuron-img'
                />
                
            </div>

            {/* Intro text. Use MarkDown to format text */}
            <div>
                <ReactMarkDown>{momentsIntroText}</ReactMarkDown>
            </div>

            {/* Show the button only if the extended text is not visible */}
            {!showExpanded && (
                <button onClick={handleShowExpanded}>
                    What's going on in the brain...
                </button>
            )}

            {/* Display expanded text when the button is clicked */}
            {showExpanded && (
                <div>
                    <ReactMarkDown>{momentsExtendedText}</ReactMarkDown>

                    <img
                        src={NeuralConnections}
                        alt="Image showing neural connections in the first two years of life"
                        className='neural-connections-img'
                    />

                    <br></br>

                    {/* navigation to Be Intentional page */}
                    <Link to="/intentional" className="btn-link">
                        How to Make Every Moment Matter
                    </Link>
                </div>
            )}

        </section>
    )
}
