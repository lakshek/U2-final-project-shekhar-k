// define reusable component with destructured props
export default function Button({
    label,
    onClick,
    type = 'button',
}) {
    return (

        <button type={type} onClick={onClick}>
            { label }
        </button>
        
    );
    
}