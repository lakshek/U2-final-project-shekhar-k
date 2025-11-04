// Import React hook
import { useState, useEffect } from 'react'

import { useNavigate } from 'react-router-dom';

// Import reusable components
import JournalForm from "../components/JournalForm"
import JournalList from "../components/JournalList"

export default function JournalPage() {

    const navigate = useNavigate();

    // Ensure only logged in users can access this page
    const userId = sessionStorage.getItem('userId');
    const userName = sessionStorage.getItem('userName');

    // Redirect if not logged in
    useEffect(() => {
        if (!userId) navigate('/login');
    }, [userId, navigate]);

    // state variable to handle changes in title input field
    const [title, setTitle] = useState("");

    // state variable to handle changes in date input field
    const [date, setDate] = useState("");

    // state variable to handle changes in entry input field
    const [entry, setEntry] = useState("");

    // state variable to handle changes in journals
    const [journals, setJournals] = useState([]);

    // state to track edit mode
    const [editingId, setEditingId] = useState(null);

    const [loading, setLoading] = useState(false);
    const [error, setError] = useState(null);

    // Fetch all journals on page load
    useEffect(() => {
        fetchJournals();
    }, []);

    async function fetchJournals() {
        if (!userId) return;    // exit if not logged in

        setLoading(true);
        setError(null);
        try {
            const response = await fetch(`/api/journals/user/${userId}`);
            // if (!response.ok) throw new Error('Failed to fetch journals.');
            const data = await response.json();

            // If empty array, display a message instead of error
            // if (data.length === 0) {
            //     setJournals([]);    // keep empty list
            // } else {
                setJournals(data);
            // }
            
        } catch (err) {
            setError('Failed to fetch journals.');
        } finally {
            setLoading(false);
        }
    }

    // CREATE a journal
    async function handleSubmit(e) {
        e.preventDefault();
        if (!title.trim() || !date.trim() || !entry.trim()) return;

        const newJournal = { userId: Number(userId), title, date, entry };

        try {
            setLoading(true);
            let response;

            if (editingId) {
                // Update existing journal
                response = await fetch(`/api/journals/${editingId}`, {
                    method: 'PUT',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(newJournal),
                });
            } else {
                // Create new journal
                response = await fetch('/api/journals', {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify(newJournal)
                });
            }

            if (!response.ok) throw new Error('Failed to save journal.');

            const saved = await response.json();

            // If updated, replace the old one; else add new one
            if (editingId) {
                setJournals(journals.map(j => (j.id === editingId ? saved : j)));
            } else {
                setJournals([saved, ...journals]);
            }

            // Reset form after submit
            setTitle('');
            setDate('');
            setEntry('');
            setEditingId(null);

        } catch (err) {
            setError(err.message);
        } finally {
            setLoading(false);
        }
    }

    // DELETE a journal
    async function handleDelete(id) {
        try {
            setLoading(true);
            const response = await fetch(`/api/journals/${id}`, {
                method: 'DELETE',
            });
            if (!response.ok) throw new Error('Failed to delete journal.');

            setJournals(journals.filter(j => j.id !== id));
        } catch (err) {
            setError(err.message);
        } finally {
            setLoading(false);
        }
    }

    // EDIT a journal
    function handleEdit(journal) {
        setEditingId(journal.id);
        setTitle(journal.title);
        setDate(journal.date);
        setEntry(journal.entry);
    }

    return (

        <section>

            <h2>{userName ? `${userName}'s Journal` : 'My Journal'}</h2>

            {error && <p style={{ color: 'red' }}>{error}</p>}
            {loading && <p>Loading...</p>}

            <JournalForm
                title={title}
                date={date}
                entry={entry}
                onTitleChange={e => setTitle(e.target.value)}
                onDateChange={e => setDate(e.target.value)}
                onEntryChange={e => setEntry(e.target.value)}
                onSubmit={handleSubmit}
            />

            <JournalList
                journals={journals}
                onEdit={handleEdit}
                onDelete={handleDelete}
            />
        </section>

    )

}