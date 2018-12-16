export function authHeader() {
    let user = JSON.parse(localStorage.getItem("current_user"));
    let token = user.token;

    if (user && token) {
        return {"Authorization": "Basic" + token};
    }

    return {};
}