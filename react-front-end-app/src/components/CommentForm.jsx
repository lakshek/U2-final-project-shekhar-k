// import reusable component 
import Button from './Button'

// define reusable component with destructured props
export default function CommentForm({
    name,
    text,
    onNameChange,
    onTextChange,
    onSubmit
}) {
    return (

        <form onSubmit={onSubmit}>
        
            <label htmlFor='name'>Name thyself, mighty thinker!</label>
                <input
                    id="name"
                    type="text"
                    value={name}
                    placeholder="Let's get acquainted..."
                    onChange={onNameChange}
                    required
            />
        
            <label htmlFor='comment'>Spill the cognitive beans...</label>
                <textarea
                    id="comment"
                    value={text}
                    placeholder="Got thoughts? Unleash them here!"
                    onChange={onTextChange}
                    required
            />
        
            <Button type="submit" label="Launch the brainwave!" />
        
        </form>

    )

}