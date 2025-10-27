// import reusable component
import Button from './Button'

// define reusable component with destructured props
export default function CommentList({ comments, onEdit, onDelete }) {
    return (

        <div>

            <h3>Synapses Are Firing! ⚡️ Here's What Others Said...</h3>

            {/* display a message to comment if there are no comments. Otherwise, use .map() method to iterate through and display existing comments as unordered list with edit and delete buttonsfor each */}
            {comments.length === 0 ? (
                <p>Not a single synaptic whisper... Be the first!</p>
            ) : (
                <ul className='comment-ul' >

                    {comments.map((comment, index) => (

                        <li key={index} className='comment-li'>
                            <strong>{comment.name}</strong>
                            <p>{comment.text}</p>
                            <Button label="EDIT like a dendrite does" onClick={() => onEdit(index)} />
                            <Button label="ERASE from brain history" onClick={() => onDelete(index)} />
                        </li>

                    ))}

                </ul>

            )}

        </div>

    )

}