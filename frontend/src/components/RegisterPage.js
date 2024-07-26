import React from 'react';

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

    collectUserInfo = () => {

        this.state.username = document.getElementById("username").value;
        // Note: probably want to make this transaction more secure. Maybe hash before storing in state? How does the service get run
        this.state.password = document.getElementById("password").value;
        this.state.password_match = (document.getElementById("password_confirm").value == this.state.password);
        this.state.email = document.getElementById("email").value.toLowerCase();

        console.log(this.state.username);
        console.log(this.state.password);
        console.log(this.state.password_match);
        console.log(this.state.email);
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
