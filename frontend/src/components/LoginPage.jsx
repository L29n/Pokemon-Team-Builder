import React, { useState } from 'react';
import Requests from '../api/Requests.js';
import { useNavigate } from 'react-router-dom';

const LoginPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [error, setError] = useState('');

    // Use useNavigate hook to programmatically navigate
    const navigate = useNavigate();
    const requests = new Requests();

    const collectUserInfo = async () => {
        try {
            const login_status_json = await requests.login_request(username, password);
            console.log(login_status_json);
            if (login_status_json.jwt) {
                localStorage.setItem('token', login_status_json.jwt);
                console.log("hi");
                navigate('/protected'); // Navigate to the protected route
            } else {
                setError('Invalid login credentials');
            }
        } catch (error) {
            setError('An error occurred during login');
        }
    };

    return (
       <div>
            <h1>Login Page</h1>
            <input
            type="text"
            value={username}
            onChange={(e) => setUsername(e.target.value)}
            placeholder="Enter your username"
            />
            <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Enter your password"
            />
            <button onClick={collectUserInfo}>Login</button>
            {error && <p>{error}</p>}
        </div>
    );
};

export default LoginPage;
