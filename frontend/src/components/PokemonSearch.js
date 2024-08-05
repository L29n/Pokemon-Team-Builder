import React, { Component } from 'react';
import { pokeAPI } from '../api/pokeAPI';
import { postAPI } from '../api/postAPI';
// import jwtDecode from 'jwt-decode';
class PokemonSearch extends Component {
    constructor(props){
        super(props)
        // real
        //const jwtDecode = require('jwt-decode');
        this.state = {
            //test
            user: JSON.parse(localStorage.getItem('token')),
            // real 
            // user: jwtDecode(localStorage.getItem('token')),
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
        console.log(user.username, pokemonName);
        // const newCollection = {
        //     local_user_id: user.username,
        //     pokemon_id: pokemonName
        // };
        let pathStr = `/PokemonCollection/addPokemon/${user.username}/${pokemonName}`;
        // let pokemonExists = await getAPI();
            // console.log("Pokemon is already in your collection!");
            let response = await postAPI(null,pathStr);
            if(response == null){
                alert(pokemonName + " has been added to your collection!");
            }
            // alert(pokemonName + " has been added to your collection!");
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
        //current testing
        const tempUser ={
            username: "testUser1"
        };
        localStorage.setItem("token", JSON.stringify(tempUser));
        //Real implementation
        //const token = localStorage.getItem('token');
        // const currentUser = jwtDecode(token);
    }
    render() {
        const{user,sprite} = this.state;
        return (
            <div>
                {sprite == null?(
                    <div>
                    <h1> {user.username}'s Pokemon Search </h1>
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
                        <h1> {user.username}'s Pokemon Search </h1>
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
