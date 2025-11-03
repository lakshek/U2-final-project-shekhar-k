import { useState } from "react";
import Button from "../components/Button";
import { useNavigate } from "react-router-dom";

export default function LoginPage() {

    // Declare useState variables
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const [loading, setLoading] = useState("");
    const navigate = useNavigate();

    async function handleSubmit(e) {
        e.preventDefault();
        setError('');
        if(!email || !password) {
            setError("Please enter email and password.");
            return;
        }

        setLoading(true);

        try {
            const user = await loginUser({ email, password });

            // Save necessary fields for personalization
            localStorage.setItem('userName', user.name);
            localStorage.setItem('userId', user.id);
            navigate('/journal');
        } catch (err) {
            setError(err.message || 'Login failed.');
        } finally {
            setLoading(false);
        }

    }

    return (
        <div className="auth-form">
            <h2>Login</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Email
                    <input type="email" value={email} onChange={e => setEmail(e.target.value)} />
                </label>
                <label>
                    Password
                    <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
                </label>
                {error && <div style={{color: 'red'}}>{error}</div> }
                <button type="submit" disabled={loading}>
                    {loading ? 'Signing in...' : 'Sign-in'}
                </button>
            </form>
        </div>
    )
    
}