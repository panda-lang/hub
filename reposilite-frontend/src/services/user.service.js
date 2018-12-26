import router from '../router';

export const userService = {
    login,
    logout,
    register
};

function login(username, password) {
    let options = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({username, password})
    };

    return fetch('http://localhost:3000/api/authenticate', options)
        .then(handleResponse)
        .then(data => {
            if (data) {
                data.token = window.btoa(username + ':' + password);
                localStorage.setItem('current_user', JSON.stringify(data));
            }

            return data;
        })
        .catch(error => Promise.reject(error));
}

function logout() {
    localStorage.removeItem('current_user');
}

function register(username, displayName, password, confirmPassword, email, confirmEmail) {
    let options = {
        method: 'POST',
        headers: {'Content-Type': 'application/json'},
        body: JSON.stringify({ username, displayName, password, confirmPassword, email, confirmEmail })
    };

    return fetch('http://localhost:3000/api/registration', options)
        .then(response => {
            return response.text()
                .then(text => {
                    let data = text && JSON.parse(text);

                    if (response.status !== 201) {
                        return Promise.reject((data && data.error) || response.statusText || response.status);
                    }

                    login(username, password);
                    return data;
                })
        });
}

function handleResponse(response) {
    return response.text()
        .then(text => {
            let data = text && JSON.parse(text);

            if (!response.ok) {
                if (response.status === 401) {
                    logout();
                    router.push('/login');
                }

                return Promise.reject((data && data.error) || response.statusText);
            }

            return data;
        });
}

