import React, { useState, useEffect } from 'react';
import { Link } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode'; // Updated import for jwt-decode

const NavBar = () => {
    const [user, setUser] = useState(null);

    useEffect(() => {
        authenticate(); // Call authenticate when the component mounts
    }, []); // Empty dependency array means this effect runs once after the initial render

    const authenticate = () => {
        const token = localStorage.getItem('token');
        if (token) {
            try {
                const decoded = jwtDecode(token);
                if (decoded.exp * 1000 > Date.now()) {
                    setUser(decoded);
                } else {
                    localStorage.removeItem('token');
                }
            } catch (err) {
                localStorage.removeItem('token');
            }
        }
    };

    return (
        <div>
            {!user ? (
                <>
                    <Link to="/"> Home </Link>
                    <Link to="/login"> Login </Link>
                    <Link to="/register"> Register </Link>
                </>
                ) : (
                <>
                    <Link to="/protected"> Protected </Link>
                    <Link to="/pokemon-search"> Pokemon-Search </Link>
                </>
            )}
        </div>
    );
};

export default NavBar;
