// Import Link from router DOM
import { Link } from 'react-router-dom'

// Import images used in AboutPage
import Neuron from '../assets/Neuron.gif'
import NeuralConnections from '../assets/NeuralConnections.jpg'

// Import reusable component to render each data row in the table
import TableRow from '../components/TableRow'

// Import long texts and table contents as variables from data folder 
import { milestones } from '../data/milestones'
import { aboutText } from '../data/texts'

// Use React's Markdown component to format and retain the long texts imported from texts.js
import ReactMarkdown from 'react-markdown'


export default function AboutPage() {

    return (

        <section>

            <div>
            
                <img src={Neuron} alt="A neuron gif showing a signal traveling through the axon and spreading in dendrites" className='neuron-img'/>

                {/* Use React Markdown for text formatting */}
                <ReactMarkdown>{ aboutText }</ReactMarkdown>
                
                <img src={NeuralConnections} alt="Synapse density evolving over time during early childhood and at adulthood" className='neural-connections-img'/>
            
            </div>

            <table>

                <caption>🧠 Baby Brain Development: <br />The Greatest Hits (Nu Ron Edition)</caption>
                <thead>
                    <tr>
                        <th className='narrow-col' >Age</th>
                        <th>What's Going On in the brain?</th>
                    </tr>
                </thead>
                
                {/* Use .map() method to iterate through each object in milestones array and reusable TableRow component to render by passing the necessary information as props */}
                <tbody>
                    {milestones.map((item, index) => (
                        <TableRow key={index} age={item.age} milestone={item.milestone} />
                    ))}
                </tbody>

            </table>
            
            <Link to="/explore" className='btn-link' >Poke Around My Brain Some More</Link>

        </section>

    )

}