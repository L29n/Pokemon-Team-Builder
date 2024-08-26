import React from 'react';
import { BrowserRouter, Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import LoginPage from './components/LoginPage';
import RegisterPage from './components/RegisterPage';
import NavBar from './components/NavBar';
import ProtectedPage from './components/ProtectedPage';
import PokemonSearch from './components/PokemonSearch';
import withAuth from './api/withAuth';

// Wrapping components with authentication HOC
const ProtectedPageWithAuth = withAuth(ProtectedPage);
const PokemonSearchWithAuth = withAuth(PokemonSearch);

const App = () => {
    return (
        <BrowserRouter>
            <NavBar />
            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/login" element={<LoginPage />} />
                <Route path="/register" element={<RegisterPage />} />
                <Route path="/protected" element={<ProtectedPageWithAuth />} />
                <Route path="/pokemon-search" element={<PokemonSearchWithAuth />} />
            </Routes>
        </BrowserRouter>
    );
};

export default App;
