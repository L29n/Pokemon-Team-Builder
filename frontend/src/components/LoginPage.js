import React from 'react';
import Requests from '../api/Requests.js';

class LoginPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            username: '',
            password: '',
            error: ''
        };

        this.collectUserInfo = this.collectUserInfo.bind(this);
    }

    requests = new Requests();

    async collectUserInfo() {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        this.setState({ username, password });

        try {
            const login_status_json = await this.requests.login_request(username, password);
            console.log(login_status_json);
            if (login_status_json.jwt) {
                localStorage.setItem('token', login_status_json.jwt);
                console.log("hi");
                this.props.navigate('/protected');
            } else {
                this.setState({ error: 'Invalid login credentials' });
            }
        } catch (error) {
            this.setState({ error: 'An error occurred during login' });
        }
    }

    render() {
        return (
            <div>
                <h1>Login Page</h1>
                <input type="text" id="username" placeholder="Enter your username"/>
                <input type="password" id="password" placeholder="Enter your password"/>
                <button onClick={this.collectUserInfo}>Login</button>
                {this.state.error && <p>{this.state.error}</p>}
            </div>
        );
    }
}

export default LoginPage;
