// Import React hook
import { useState } from 'react'

// Import reusable components
import CommentForm from "../components/CommentForm"
import CommentList from "../components/CommentList"

export default function CommentPage() {

    // state variable to handle changes in name input field
    const [name, setName] = useState("");

    // state variable to handle changes in text area input field
    const [text, setText] = useState("");

    // state variable to handle changes in comments
    const [comments, setComments] = useState([]);

    // capture changes in name input using state variable
    const handleNameChange = (e) => setName(e.target.value);

    // capture changes in text area input using state variable
    const handleTextChange = (e) => setText(e.target.value);

    // function to handle submit - prevent page from reloading - validate input fields for blanks - add new comment to the comment list - reset input fields
    const handleSubmit = (e) => {
        e.preventDefault();
        if(!name.trim() || !text.trim()) return;

        setComments([{name, text}, ...comments]);
        setName("");
        setText("");
    };

    // function to handle delete - use filter to select all comments except the one that was deleted
    const handleDelete = (index) => {
        setComments(comments.filter((comment, i) => i !== index));
    };

    // function to handle edit - use state variables to initialize name and text for the chosen comment and re-present
    const handleEdit = (index) => {
        const commentToEdit = comments[index];
        setName(commentToEdit.name);
        setText(commentToEdit.text);
        setComments((comments.filter((comment, i) => i !== index)));
    };

    return (

        <section>

            <div>
                <h2>Spill the brain juice!</h2>
            </div>

            {/*
                - use a reusable component, CommentForm 
                -- props to send and receive data
                -- state variables to handle changes to input fields and button
                -- functions to handle any changes 
             */}

            <CommentForm 
                name={name}
                text={text}
                onNameChange={handleNameChange}
                onTextChange={handleTextChange}
                onSubmit={handleSubmit}
            />
            
            {/*
                - use another reusable component, CommentList
                -- props to send and receive data
                -- state variables to handle changes to the buttons
                -- functions to handle those changes
            */}

            <CommentList 
                comments={comments}
                onEdit={handleEdit}
                onDelete={handleDelete}
            />

        </section>

    )

}