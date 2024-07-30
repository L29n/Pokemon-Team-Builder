import React from 'react';
import { pokeAPI } from '../api/pokeAPI';
class Home extends React.Component {

    constructor(props){
        super(props);
        this.state = {
            // sprite: null
        };
    }

    // fetchPokemon = async () => {
    //     try{
    //         const pokemon_name = document.getElementById("pokemonName").value.toLowerCase();
    //         // const response = await fetch(`https://pokeapi.co/api/v2/pokemon/${pokemon_name}`);
    //         const data = await pokeAPI(pokemon_name);
    //         // if(!response.ok) {
    //         //     throw new Error("Could not fetch pokemon");
    //         // }
    //         // const data = await response.json();
    //         console.log(data);
    //         this.setState({sprite: `${data.sprites.front_default}`});
    //     }
    //     catch(error) {
    //         console.error(error);
    //     }
    // };


    render() {
        return(
            <>
                <div>
                    {/* <input type="text" id="pokemonName" placeholder="Enter Pokemon name"/>
                    <button
                        onClick={() => this.fetchPokemon()}
                    >
                        Find Pokemon
                    </button>
                    {this.state.sprite && <img src={this.state.sprite} alt="Pokemon Sprite"/>} */}
                </div>
            </>
        );
    }
}

export default Home;