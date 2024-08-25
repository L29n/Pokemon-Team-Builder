import React, { Component } from 'react';
import { pokeAPI } from '../api/pokeAPI.js';
import { postAPI } from '../api/postAPI.js';
import { jwtDecode } from 'jwt-decode';

class PokemonSearch extends Component {
    constructor(props){
        super(props)
        this.state = {
            user: jwtDecode(localStorage.getItem('token')),
            pokemonName: null,
            userInput: null,
            sprite: null
        }
        this.findPokemon = this.findPokemon.bind(this);
        this.setUserInput = this.setUserInput.bind(this);
        this.addPokemon = this.addPokemon.bind(this);
        this.clearPokemon = this.clearPokemon.bind(this);
    }
    clearPokemon(){
        this.setState({sprite: null});
        const inputElement = document.getElementById("pokemonName");
        if (inputElement) {
            inputElement.value = '';
        }
        this.setState({ userInput: null });
    }
    async addPokemon(){
        const{user, pokemonName} = this.state;
        console.log(user.USERNAME, pokemonName);
        let pathStr = `/PokemonCollection/addPokemon/${user.USERNAME}/${pokemonName}`;
        let response = await postAPI(null,pathStr);
        if(response !== null){
            alert(pokemonName + " has been added to your collection!");
        }else{
            alert("Error!");
        }
    }
    setUserInput(currentInput){
        this.setState({userInput:currentInput.target.value.toLowerCase()});
    }
    async findPokemon(){
        const{userInput} = this.state;
        const data = await pokeAPI(userInput);
        this.setState({pokemonName: `${data.name}`});
        this.setState({sprite: `${data.sprites.front_default}`});
    }
    componentDidMount(){
        console.log(jwtDecode(localStorage.getItem("token")));
    }
    render() {
        const{user,sprite} = this.state;
        return (
            <div>
                {sprite == null?(
                    <div>
                        <h1> {user.USERNAME}'s Pokemon Search </h1>
                        <input type="text" id="pokemonName" placeholder="Enter Pokemon name" onChange={this.setUserInput}/>
                            <button onClick={this.findPokemon}>
                                Find Pokemon
                            </button>
                        {this.state.sprite && <img src={this.state.sprite} alt="Pokemon Sprite"/>}
                        <br/>
                        <br/>
                    </div>
                )
                :(
                    <div>
                        <h1> {user.USERNAME}'s Pokemon Search </h1>
                        <input type="text" id="pokemonName" placeholder="Enter Pokemon name" onChange={this.setUserInput}/>
                            <button onClick={this.findPokemon}>
                                Find Pokemon
                            </button>
                        {this.state.sprite && <img src={sprite} alt="Pokemon Sprite"/>}
                        <br/>
                        <br/>
                        <button onClick={this.addPokemon}> Add Pokemon to Collection</button>
                        <button onClick = {this.clearPokemon}>Clear</button>
                    </div>
                )}
            </div>
        );
    }
}

export default PokemonSearch;