import router from "../router";

export const userService = {
    login,
    logout
};

function login(username, password) {
    let options = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify({username, password})
    };

    return fetch("http://localhost:3000/api/authenticate", options)
        .then(handleResponse)
        .then(data => {
            if (data) {
                data.token = window.btoa(username + ":" + password);
                localStorage.setItem("current_user", JSON.stringify(data));
            }

            return data;
        })
        .catch(error => Promise.reject(error));
}

function logout() {
    localStorage.removeItem("current_user");
}

function handleResponse(response) {
    return response.text()
        .then(text => {
            let data = text && JSON.parse(text);

            if (!response.ok) {
                if (response.status === 401) {
                    logout();
                    router.push("/login");
                }

                return Promise.reject((data && data.error) || response.statusText);
            }

            return data;
        });
}

