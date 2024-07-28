import React from 'react';
import { Link } from 'react-router-dom';

class NavBar extends React.Component {

    constructor(props) {
        super(props);
    }

    render() {
        return(
            <div>
                <Link to="/"> Home </Link>
                <Link to="/login"> Login </Link>
                <Link to="/register"> Register </Link>
            </div>
        )
    }
}

export default NavBar;
