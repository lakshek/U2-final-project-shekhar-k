// import reusable component 
import Button from './Button'

// define reusable component with destructured props
export default function JournalForm({
    title,
    date,
    entry,
    onTitleChange,
    onDateChange,
    onEntryChange,
    onSubmit,
}) {
    return (

        <form onSubmit={onSubmit}>
        
            <label htmlFor='title'>Title:</label>
            <input
                id='title'
                type='text'
                value={title}
                placeholder='Enter your journal title...'
                onChange={onTitleChange}
                required
            />

            <label htmlFor='date'>Date:</label>
            <input
                id='date'
                type='date'
                value={date}
                onChange={onDateChange}
                required
            />
        
            <label htmlFor='entry'>Your thoughts:</label>
            <input
                id='entry'
                value={entry}
                placeholder='Meaningful reflections matter...'
                onChange={onEntryChange}
                required
            />

            <Button type="submit" label="Save your thoughts!" />
        
        </form>

    )

}