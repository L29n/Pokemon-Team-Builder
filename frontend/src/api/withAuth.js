import React, { useState, useEffect } from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode';

const withAuth = (WrappedComponent) => {
    const AuthHOC = (props) => {
        const [isAuthenticated, setIsAuthenticated] = useState(false);
        const [user, setUser] = useState(null);
        const [loading, setLoading] = useState(true);
        const navigate = useNavigate();

        useEffect(() => {
            const token = localStorage.getItem('token');
            if (token) {
                try {
                    const decoded = jwtDecode(token);
                    if (decoded.exp * 1000 > Date.now()) {
                        setIsAuthenticated(true);
                        setUser(decoded);
                    } else {
                        localStorage.removeItem('token');
                    }
                } catch (err) {
                    localStorage.removeItem('token');
                }
            }
            setLoading(false);
        }, []);

        if (loading) {
        return <div>Loading...</div>;
}

if (!isAuthenticated) {
navigate('/login');
return null; // Return null to avoid rendering the wrapped component
}

return <WrappedComponent {...props} user={user} />;
};

return AuthHOC;
};

export default withAuth;
