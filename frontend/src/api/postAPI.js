export const postAPI =(data_object, path)=>{
    return fetch('http://localhost:8080/api/post'+ path,{
        method: 'POST',
        headers:{
            'Content-Type': 'application/json',
        },
        credentials: 'include',
        body: JSON.stringify(data_object),
    }).then((response)=>{
        return response.json();
    });
}