
export async function registerUser({ name, email, password }) {
    const payload = { name, email, password, role : 'User' };

    try {
        const response = await fetch('/api/users', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });
        if(!response.ok) {
            const err = await response.json().catch(() => ({message: response.statusText}));
            throw new Error(err.message || 'Registration failed');
        }
        return await response.json();
    } catch (err) {
        throw err;
    }
}

export async function loginUser ({ email, password }) {
    const payload = { email, password };

    try {
        const response = await fetch('/api/users/login', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(payload)
        });
        if(!response.ok) {
            const err = await response.json().catch(() => ({message: response.statusText}));
            throw new Error(err.message || 'Login failed');
        }
        return await response.json();
    } catch (err) {
        throw err;
    }
}