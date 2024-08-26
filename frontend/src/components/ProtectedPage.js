import React from 'react';

const ProtectedPage = ({ user }) => {
    console.log(user);

    return (
        <div>
            <h2>Protected Page</h2>
            {user && <p>Welcome, {user.USERNAME}</p>}
            <p>This page is only accessible to authenticated users.</p>
        </div>
    );
};

export default ProtectedPage;
