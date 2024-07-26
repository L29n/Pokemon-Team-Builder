import React from 'react';
import Requests from '../api/Requests.js'

class RegisterPage extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            username: null,
            password: null,
            email: null,
            password_match: true
        };
    }

    requests = new Requests();

    collectUserInfo = async () => {
        const username = document.getElementById("username").value;
        const password = document.getElementById("password").value;
        const passwordConfirm = document.getElementById("password_confirm").value;
        const email = document.getElementById("email").value.toLowerCase();
        const password_match = password === passwordConfirm;

        this.setState({
            username: username,
            password: password,
            password_match: password_match,
            email: email
        }, async () => {
            console.log(this.state.username);
            console.log(this.state.password);
            console.log(this.state.password_match);
            console.log(this.state.email);

            if (this.state.password_match) {
                const register_status_json = await this.requests.register_request(this.state.username, this.state.password, this.state.email);
                console.log(register_status_json);
            } else {
                console.log("Passwords do not match.");
            }
        });
    }



    render() {
        return(
            <>
                <h1>Register Page</h1>
                <ul>
                    <li><input type="text" id="username" placeholder="Enter your username"/></li>
                    <li><input type="password" id="password" placeholder="Enter your password"/></li>
                    <li><input type="password" id="password_confirm" placeholder="Enter your password again"/></li>
                    <li><input type="text" id="email" placeholder="Enter your email address"/></li>
                    <li><button onClick={()=>{this.collectUserInfo()}}>Register</button> </li>
                </ul>
            </>
        );
    }
}

export default RegisterPage;
