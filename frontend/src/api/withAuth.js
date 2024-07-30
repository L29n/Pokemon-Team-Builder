import React, { Component } from 'react';
import { Navigate } from 'react-router-dom';
import { jwtDecode } from 'jwt-decode';

export default function withAuth(WrappedComponent) {
    return class extends Component {
        constructor(props) {
            super(props);

            this.state = {
                isAuthenticated: false,
                user: null,
                loading: true,
            };
        }

        componentDidMount() {
            const token = localStorage.getItem('token');
            if (token) {
                try {
                    const decoded = jwtDecode(token);
                    if (decoded.exp * 1000 > Date.now()) {
                        this.setState({ isAuthenticated: true, user: decoded, loading: false });
                    } else {
                        localStorage.removeItem('token');
                        this.setState({ loading: false });
                    }
                } catch (err) {
                    localStorage.removeItem('token');
                    this.setState({ loading: false });
                }
            } else {
                this.setState({ loading: false });
            }
        }

        render() {
            const { isAuthenticated, user, loading } = this.state;

            if (loading) {
                return <div>Loading...</div>;
            }

            if (!isAuthenticated) {
                return <Navigate to="/login" />;
            }

            return <WrappedComponent {...this.props} user={user} />;
        }
    };
}
