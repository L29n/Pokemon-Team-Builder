import React from 'react';
import Home from "./components/Home.js";
import LoginPage from "./components/LoginPage.js";
import RegisterPage from "./components/RegisterPage.js";
import NavBar from "./components/NavBar.js"
import {BrowserRouter, Routes, Route} from 'react-router-dom';

class App extends React.Component {
  render() {
    return(
        <BrowserRouter>
            <NavBar/>
            <Routes>
                <Route path="/" element={<Home/>}/>
                <Route path="/login" element={<LoginPage/>}/>
                <Route path="/register" element={<RegisterPage/>}/>
            </Routes>
        </BrowserRouter>
    );
  }
}

export default App;
