import HomeComponent from "../routes/home/HomeView";
import LoginComponent from "../routes/login/LoginView";

export const routes = [
    {
        path: "/",
        name: "HomeView",
        component: HomeComponent,
        meta: {
            requiresAuth: false
        }
    },
    {
        path: "/login",
        name: "LoginView",
        component: LoginComponent,
        meta: {
            requiresAuth: false
        }
    }
];