import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';

const EditEvent = () => {
    const { id } = useParams();
    const [event, setEvent] = useState({});
    const [error, setError] = useState(null);
    const [isLoading, setIsLoading] = useState(true);

    const username = localStorage.getItem('username') || '';
    const password = localStorage.getItem('password') || '';
    const basicAuth = btoa(`${username}:${password}`);

    useEffect(() => {
        const fetchEvent = async () => {
            try {
                const response = await axios.get(`http://localhost:8080/event/${id}`, {
                    headers: {
                        Authorization: `Basic ${basicAuth}`
                    }
                });
                setEvent(response.data);
                setIsLoading(false);
            } catch (error) {
                setError(error.message);
                setIsLoading(false);
            }
        };

        fetchEvent();
    }, [id]);

    const handleFormSubmit = async (e) => {
        e.preventDefault();
        try {
            await axios.put(`http://localhost:8080/event/${id}`, event, {
                headers: {
                    Authorization: `Basic ${basicAuth}`
                }
            });
            window.location.href = '/events'; // Redirect to the events page after successful submission
        } catch (error) {
            setError(error.message);
        }
    };

    if (isLoading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>Error: {error}</div>;
    }

    return (
        <div>
            <h2>Edit Event</h2>
            <form onSubmit={handleFormSubmit}>
                <label>Event Name:</label>
                <input type="text" value={event.eventname} onChange={(e) => setEvent({ ...event, eventname: e.target.value })} />
                <br/>
                <label>Address:</label>
                <input type="text" value={event.address} onChange={(e) => setEvent({ ...event, address: e.target.value })} />
                <br/>
                <label>Showtime:</label>
                <input type="datetime-local" value={event.showtime} onChange={(e) => setEvent({ ...event, showtime: e.target.value })} />
                <br/>
                <label>Description:</label>
                <textarea value={event.description} onChange={(e) => setEvent({ ...event, description: e.target.value })} />
                <br/>
                <label>Max Tickets:</label>
                <input type="number" value={event.maxtickets} onChange={(e) => setEvent({ ...event, maxtickets: parseInt(e.target.value) })} />
                <br/>
                <label>Duration:</label>
                <input type="number" value={event.duration} onChange={(e) => setEvent({ ...event, duration: parseInt(e.target.value) })} />
                <br/>
                <button type="submit">Save Changes</button>
            </form>
        </div>
    );
};

export default EditEvent;