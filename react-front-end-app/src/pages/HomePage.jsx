// Import Link from router DOM
import { Link } from 'react-router-dom'

// Import image used in HomePage
import BabyBrain from '../assets/BabyBrain.jpg'

// Import long texts as variables to be used in HomePage
import { homeText } from '../data/texts'

// Use React's Markdown component to format and retain the long texts imported from texts.js
import ReactMarkdown from 'react-markdown'


export default function HomePage() {

    return (

        <section>

            <div>
                {/* Page heading and image */}
                <h2>Thank you for visiting this site - intentionally</h2>

                <img
                    src={BabyBrain}
                    alt="baby's face with the brain surrounded by bubbles of different activities"
                    className='babybrain-img'
                />
           
            </div>

            {/* Intro text. Use React Markdown for text formatting */}
            <div>
                <ReactMarkdown>{ homeText }</ReactMarkdown>        
            </div>

            <div>
                {/* Navigation button to Moments Matter page */}
                <Link to="/moments" className='btn-link'>
                    Moments Matter                
                </Link>

                {/* Navigation button to Be Intentional page */}
                <Link to="intentional" className='btn-link'>
                    Be Intentional
                </Link>
            </div>

        </section>

    )

}