import React from 'react';
import Home from "./components/Home.js";
import LoginPageWrapper from "./components/LoginPageWrapper.js";
import RegisterPage from "./components/RegisterPage.js";
import LoggedOutNavBar from "./components/LoggedOutNavBar.js";
import ProtectedPage from "./components/ProtectedPage.js";
import PokemonSearch from './components/PokemonSearch.js';
import withAuth from "./api/withAuth.js";
import {BrowserRouter, Routes, Route} from 'react-router-dom';

const ProtectedPageWithAuth = withAuth(ProtectedPage);
const PokemonSearchWithAuth = withAuth(PokemonSearch);

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
                <Route path="/pokemon-search" element={<PokemonSearchWithAuth/>}/>
            </Routes>
        </BrowserRouter>
    );
  }
}

export default App;
