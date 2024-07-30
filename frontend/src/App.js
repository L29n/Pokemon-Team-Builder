import React from 'react';
import Home from "./components/Home.js";
import LoginPageWrapper from "./components/LoginPageWrapper.js";
import RegisterPage from "./components/RegisterPage.js";
import LoggedOutNavBar from "./components/LoggedOutNavBar.js";
import ProtectedPage from "./components/ProtectedPage.js";
import withAuth from "./api/withAuth.js";
import {BrowserRouter, Routes, Route} from 'react-router-dom';

const ProtectedPageWithAuth = withAuth(ProtectedPage);

class App extends React.Component {
  render() {
    return(
        <BrowserRouter>
            <LoggedOutNavBar/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/login" element={<LoginPageWrapper/>}/>
                <Route path="/register" element={<RegisterPage/>}/>
                <Route path="/protected" element={<ProtectedPageWithAuth/>} />
            </Routes>
        </BrowserRouter>
    );
  }
}

export default App;
