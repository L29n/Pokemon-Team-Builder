import React, { useState, useCallback } from 'react';

const Home = () => {
    const [sprite, setSprite] = useState(null);

    // Use useCallback to memoize the fetchPokemon function
    const fetchPokemon = useCallback(async () => {
        try {
            const pokemonName = document.getElementById("pokemonName").value.toLowerCase();
            const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemonName}`);
            if (!response.ok) {
                throw new Error("Could not fetch pokemon");
            }
            const data = await response.json();
            setSprite(data.sprites.front_default);
        } catch (error) {
            console.error(error);
        }
    }, []);

    return (
        <>
            <div>
                <input type="text" id="pokemonName" placeholder="Enter Pokemon name"/>
                <button onClick={fetchPokemon}>
                    Find Pokemon
                </button>
                {sprite && <img src={sprite} alt="Pokemon Sprite"/>}
            </div>
        </>
    );
};

export default Home;
