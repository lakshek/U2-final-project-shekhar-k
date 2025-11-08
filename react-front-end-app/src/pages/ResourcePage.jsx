import { useState, useEffect } from "react";

export default function ResourcePage() {

    const [resources, setResources] = useState([]);
    const [loading, setLoading] = useState(false);
    const [error, setError] = useState("");
    const [currentPage, setCurrentPage] = useState(1);
    const itemsPerPage = 3;

    useEffect(() => {
        async function fetchResources() {
            setLoading(true);
            try {
                const response = await fetch("/api/resources");
                const data = await response.json();
                setResources(data);
            } catch (err) {
                setError("Error loading resources.");
            } finally {
                setLoading(false);
            }
        }
        fetchResources();
    }, []);

    // Pagination
    const start = (currentPage - 1) * itemsPerPage;
    const end = start + itemsPerPage;
    const visibleResources = resources.slice(start, end);

    const handleNext = () => {
        if (end < resources.length) {
            setCurrentPage(currentPage + 1);
        }
    };

    const handlePrevious = () => {
        if (currentPage > 1) {
            setCurrentPage(currentPage - 1);
        }
    };

    return (

        <section>
            <h2>Learning Resources</h2>

            {loading && <p>Loading...</p>}
            {error && <p style={{color: "red"}}>{error}</p>}

            <div>
                {visibleResources.map((res) => (
                    <div key={res.id}>
                        <h3>{res.title}</h3>
                        <p>{res.description}</p>
                        <a
                            href={res.url}
                            target="_blank"
                            rel="noopener noreferrer"
                            className="btn-link"
                        >
                            Visit Resource
                        </a>
                    </div>
                ))}
            </div>

            {/* Pagination buttons */}

            <div className="pagination">
                <button onClick={handlePrevious} disabled={currentPage === 1}>
                    ◀ Previous
                </button>
                <span>Page {currentPage}</span>
                <button onClick={handleNext} disabled={end >= resources.length}>
                    Next ▶
                </button>

            </div>

        </section>

    );

}