export const pokeAPI = (pokemon_name) =>{
    return fetch(`https://pokeapi.co/api/v2/pokemon/${pokemon_name}`)
    .then(response =>{
        if(!response.ok) {
            throw new Error("Could not fetch pokemon");
        }
      return response.json();

    }).catch(error => {
        console.error('Error fetching data:', error);
        throw error;
    });

};