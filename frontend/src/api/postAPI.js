export const postAPI = (data_object, path) => {
    const url = 'http://localhost:8080/api/post' + path;
    const options = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        credentials: 'include',
    };

    if (data_object != null) {
        options.body = JSON.stringify(data_object);
    }

    return fetch(url, options)
        .then((response) => {
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const contentType = response.headers.get("content-type");
            if (contentType && contentType.indexOf("application/json") !== -1) {
                return response.json();
            } else {
                console.log("Response is not JSON");
                return null;
            }
        })
        .catch((error) => {
            console.error('Error:', error);
            return null;
        });
};