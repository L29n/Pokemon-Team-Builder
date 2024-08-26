import React, { useState, useEffect, useCallback } from 'react';
import { pokeAPI } from '../api/pokeAPI.js';
import { postAPI } from '../api/postAPI.js';
import { jwtDecode } from 'jwt-decode'; // Updated import for jwt-decode

const PokemonSearch = () => {
    const [user, setUser] = useState(null);
    const [pokemonName, setPokemonName] = useState(null);
    const [userInput, setUserInput] = useState('');
    const [sprite, setSprite] = useState(null);

    useEffect(() => {
        // Decode the token and set the user state on component mount
        const token = localStorage.getItem('token');
        if (token) {
            setUser(jwtDecode(token));
        }
    }, []);

    const clearPokemon = useCallback(() => {
        setSprite(null);
        setUserInput('');
    }, []);

    const addPokemon = useCallback(async () => {
        if (user && pokemonName) {
            const pathStr = `/PokemonCollection/addPokemon/${user.USERNAME}/${pokemonName}`;
            const status = await postAPI(null, pathStr);
            if (status === 200) {
                alert(`${pokemonName} has been added to your collection!`);
            } else if (status === 409){
                alert(`${pokemonName} is already in your collection!`);
            } else {
                alert("Error!");
            }
        }
    }, [user, pokemonName]);

    const findPokemon = useCallback(async () => {
        if (userInput) {
            const data = await pokeAPI(userInput);
            setPokemonName(data.name);
            setSprite(data.sprites.front_default);
        }
    }, [userInput]);

    return (
        <div>
            <h1>{user?.USERNAME}'s Pokemon Search</h1>
            <input
            type="text"
            id="pokemonName"
            placeholder="Enter Pokemon name"
            value={userInput}
            onChange={(e) => setUserInput(e.target.value.toLowerCase())}
            />
            <button onClick={findPokemon}>Find Pokemon</button>
            {sprite && <img src={sprite} alt="Pokemon Sprite" />}
            <br />
            <br />
            {sprite && (
                <>
                    <button onClick={addPokemon}>Add Pokemon to Collection</button>
                    <button onClick={clearPokemon}>Clear</button>
                </>
            )}
        </div>
    );
};

export default PokemonSearch;
