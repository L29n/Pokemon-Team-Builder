import React from 'react';
import { useNavigate } from 'react-router-dom';
import LoginPage from './LoginPage';

const LoginPageWrapper = (props) => {
    const navigate = useNavigate();
    return <LoginPage {...props} navigate={navigate} />;
};

export default LoginPageWrapper;