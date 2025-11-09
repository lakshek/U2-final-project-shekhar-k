// Import React hook
import { useState } from 'react'

// Import reusable component to render details about the selected topic
import TopicCard from '../components/TopicCard'

// Import topics data from data folder
import { topics } from '../data/topics.js'

export default function ExplorePage() {

    const [chosen, setChosen] = useState("")

    {/* Use .find() method to find the key and convert to a Number (since id is a number) before getting the topic details */}
    const topic = topics.find(topic => topic.id === Number(chosen));

    return (
        
        <section>

            <div>            
            
                <h2>Explore.. Learn.. Be Intentional</h2>
                
                {/* Use state variable to capture topic selection and .map() method to display the topic chosen */}
                <select value={chosen} onChange={e => setChosen(e.target.value)} >
                    <option value="">Your choice matters — go ahead and pick one... 👇</option>
                    {topics.map(topic => (
                        <option key={topic.id} value={topic.id} >{topic.name}</option>
                    ))}
                </select>

            </div>

            {/* Use a spread operator to pass the chosen topic's object as props and use reusable component to render the details of the topic */}
            {/* Animation to display a topic card if a topic is chosen */}
            { topic && (

                <div className='fade-in-element' key={chosen}>
                    <TopicCard {...topic} />
                </div>

            )}

        </section>

    )

}