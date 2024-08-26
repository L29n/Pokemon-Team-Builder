import React, { useState } from 'react';
import Requests from '../api/Requests.js';

const RegisterPage = () => {
    const [username, setUsername] = useState('');
    const [password, setPassword] = useState('');
    const [passwordConfirm, setPasswordConfirm] = useState('');
    const [email, setEmail] = useState('');
    const [passwordMatch, setPasswordMatch] = useState(true);
    const [error, setError] = useState('');

    const requests = new Requests();

    const collectUserInfo = async () => {
        const passwordMatch = password === passwordConfirm;

        setPasswordMatch(passwordMatch);

        if (passwordMatch) {
            try {
                const registerStatusJson = await requests.register_request(username, password, email);
                console.log(registerStatusJson);
            } catch (error) {
                setError('An error occurred during registration');
            }
        } else {
            setError('Passwords do not match.');
        }
    };

    return (
        <>
            <h1>Register Page</h1>
            <ul>
                <li><input type="text" placeholder="Enter your username" value={username} onChange={(e) => setUsername(e.target.value)} /></li>
                <li><input type="password" placeholder="Enter your password" value={password} onChange={(e) => setPassword(e.target.value)} /></li>
                <li><input type="password" placeholder="Enter your password again" value={passwordConfirm} onChange={(e) => setPasswordConfirm(e.target.value)} /></li>
                <li><input type="text" placeholder="Enter your email address" value={email} onChange={(e) => setEmail(e.target.value)} /></li>
                <li><button onClick={collectUserInfo}>Register</button></li>
            </ul>
            {error && <p>{error}</p>}
        </>
    );
};

export default RegisterPage;
