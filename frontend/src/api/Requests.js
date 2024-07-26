

class Requests {

    // Post Requests

    // Login Post
    async login_request(username, password) {
        try{
            const response = await fetch('http://localhost:8080/api/post/login', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password }),
            });
            if(!response.ok) {
                throw new Error(`HTTP error. Status: ${response.status}`);
            }
            const data = await response.json();
            return data; // Return the parsed JSON data
        }
        catch(error) {
            console.error(error);
            return { success: false, error: error.message };
        }
    }

    // Register Post
    async register_request(username, password, email) {
        try {
            const response = await fetch('http://localhost:8080/api/post/register', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json',
                },
                body: JSON.stringify({ username, password, email }),
            });
            if(!response.ok) {
                throw new Error(`HTTP error. Status: ${response.status}`);
            }
            const data = await response.json();
            return data;
        }
        catch(error) {
            console.error(error);
            return { success: false, error: error.message };
        }
    }


}

export default Requests;