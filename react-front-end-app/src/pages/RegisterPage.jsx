import { useState } from "react";
import Button from "../components/Button";
import { useNavigate } from "react-router-dom";
import { registerUser } from "../api/auth";


export default function RegisterPage() {

    // Declare useState variables
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const [error, setError] = useState("");
    const [loading, setLoading] = useState(false);
    const navigate = useNavigate();

    async function handleSubmit(e) {
        e.preventDefault();
        if(!name || !email || !password) {
            setError("Please fill in all the fields.");
            return;
        }

        setLoading(true);

        try {
            const user = await registerUser({ name, email, password });
            
            // Save necessary fields for personalization
            sessionStorage.setItem('userName', user.name);
            sessionStorage.setItem('userId', user.id);

            // Notify header instantly
            window.dispatchEvent(new Event('userName'));

            // Navigate to Home page
            navigate("/login");
        } catch (err) {
            setError(err.message || "Registration failed");
        } finally {
            setLoading(false);
        }
    }

    return (
        <div className="auth-form">
            <h2>Register</h2>
            <form onSubmit={handleSubmit}>
                <label>
                    Name
                    <input value={name} onChange={e => setName(e.target.value)} />
                </label>
                <label>
                    Email
                    <input type="email" value={email} onChange={e => setEmail(e.target.value)} />
                </label>
                <label>
                    Password
                    <input type="password" value={password} onChange={e => setPassword(e.target.value)} />
                </label>
                {error && <div style={{color: "red"}}>{error}</div>}
                <button type="submit" disabled={loading}>
                    {loading ? "Registering..." : "Register"}
                </button>
            </form>
        </div>
    );
}