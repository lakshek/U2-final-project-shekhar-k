// Import Link from router DOM
import { Link } from 'react-router-dom'

// Import React hooks
import { useState, useRef } from 'react'

// Import images and video used in HomePage
import DancingNeuron from '../assets/DancingNeuron.gif'
import BrainIO from '../assets/BrainIO.jpg'
import BrainPower from '../assets/BrainPower.mp4'

// Import long texts as variables to be used in HomePage
import { homeExtendedText, homeIntroText1, homeIntroText2 } from '../data/texts'

// Use React's Markdown component to format and retain the long texts imported from texts.js
import ReactMarkdown from 'react-markdown'


export default function HomePage() {

    // state variable to display the expanded text
    const [expanded, setExpanded] = useState(false);

    // state variable to display the video
    const [showVideo, setShowVideo] = useState(false);

    // state variable to handle video ending
    const [videoEnded, setVideoEnded] = useState(false);

    // Ref hook to access the video DOM element directly
    const videoRef = useRef(null);

    // function to handle showing the expanded text
    const showExpandedText = () => {
        setExpanded(true);
    };

    // function to handle displaying and playing the video automatically
    const handlePlayVideo = () => {

        setShowVideo(true);

        // wait for the video to load before playing
        setTimeout(() => {
            videoRef.current?.play();
        }, 100);
        
    };

    return (

        <section>

            <div>

                {/* Intro section with text, images, and a button to show extended text */}
                <h2>Hi, I'm Nu (like “new”), Nu Ron.</h2>
                <img src={DancingNeuron} alt="A neuron gif swinging the body side-to-side" className='dancing-neuron-img' />

                {/* Use React Markdown for text formatting */}
                <ReactMarkdown>{ homeIntroText1 }</ReactMarkdown>

                <img src={BrainIO} alt='A human head silouette with brain getting input from one side and sending output on the other side' className='brain-io-img' />
                
                {/* Use React Markdown for text formatting */}
                <ReactMarkdown>{ homeIntroText2 }</ReactMarkdown>

                {/* Use state variable and logical operator to control button's visibility */}
                {!expanded && <button onClick={showExpandedText} >Wanna know more?</button> }

            </div>

            {expanded && (

                <div>

                    {/* Use React Markdown for text formatting */}
                    <ReactMarkdown>{ homeExtendedText }</ReactMarkdown>

                    {/* Use state variable to display "Curious?" button until it is clicked */}
                    {/* If the button is clicked, display and play the video automatically */}
                    {!showVideo && (<button onClick={handlePlayVideo} >Curious?</button>)}

                    {showVideo && (
                        <>
                            <video 
                                ref={videoRef}
                                src={BrainPower}
                                controls
                                onEnded={() => setVideoEnded(true)}
                            >
                                Your browser does not support the video
                            </video>

                            <p>Source: Brain Power video created by Tiffany Shlain and Let It Ripple Studio</p>
                        </>
                    )}

                    {/* Use state variable to display the link only after the video ends */}
                    {videoEnded && (
                        <Link to="/explore" className='btn-link'>Keep That Curiosity Firing!</Link>
                    )}

                </div>

            )}

        </section>

    )

}