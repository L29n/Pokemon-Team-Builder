export const getAPI = (path) => {
    return fetch(`http://localhost:8080/api/get${path}`, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include',
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Network response was not ok');
        }
        if( typeof response === 'boolean'){
            return response;
        }else{
            return response.json();
        }

    })
    .catch(error => {
        console.error('Error fetching data:', error);
        return;
    });
};
