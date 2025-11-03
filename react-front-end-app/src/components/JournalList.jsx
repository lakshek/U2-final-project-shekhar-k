// import reusable component
import Button from './Button'

// define reusable component with destructured props
export default function JournalList({ journals, onEdit, onDelete }) {
    return (

        <div>

            <h3>Your reflections...</h3>

            {/* display a message to comment if there are no comments. Otherwise, use .map() method to iterate through and display existing comments as unordered list with edit and delete buttonsfor each */}
            {journals.length === 0 ? (
                <p>No entries yet - start journaling today!</p>
            ) : (
                <ul className='journal-ul'>

                    {journals.map(j => (

                        <li key={j.id} className='journal-li'>
                            <strong>{j.title}</strong> - {j.date}
                            <p>{j.entry}</p>
                            <Button label="Edit" onClick={() => onEdit(j)} />
                            <Button label="Delete" onClick={() => onDelete(j.id)} />
                        </li>

                    ))}

                </ul>

            )}

        </div>

    );

}