import React from 'react';

class LoginPage extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            username: null,
            password: null
        }
    }

    collectUserInfo = () => {
        this.state.username = document.getElementById("username").value;
        this.state.password = document.getElementById("password").value;

        console.log(this.state.username);
        console.log(this.state.password);
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