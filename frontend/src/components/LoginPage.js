import React from 'react';
import Requests from '../api/Requests.js'

class LoginPage extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            username: null,
            password: null
        }
    }

    requests = new Requests();


    collectUserInfo = async () => {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;

        this.setState({
            username: username,
            password: password
        }, async () => {
            // This callback function runs after the state has been updated
            console.log(this.state.username);
            console.log(this.state.password);

            const login_status_json = await this.requests.login_request(this.state.username, this.state.password);
            console.log(login_status_json);
        });

    }

    render() {
        return(
            <div>
                <h1>Login Page</h1>
                <input type="text" id="username" placeholder="Enter your username"/>
                <input type="password" id="password" placeholder="Enter your password"/>
                <button onClick={() => {this.collectUserInfo()}}>Login</button>
            </div>
        );
    }
}

export default LoginPage;