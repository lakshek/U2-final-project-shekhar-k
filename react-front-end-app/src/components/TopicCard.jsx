// use React's Markdown component to format long texts
import ReactMarkdown from 'react-markdown'

// define reusable component with destructured props
export default function TopicCard({ name, desc, img }) {
    return (

        <div className="topic-card">

            <img src={img} className="topic-img" alt={"${name} illustration"}/>

            <h3>{ name }</h3>

            {/* use React's Markdown component to format long text */}
            <ReactMarkdown>{ desc }</ReactMarkdown>
            
        </div>

    )

}