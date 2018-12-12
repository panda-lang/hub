import HomeComponent from "../routes/home/HomeView";

export const routes = [{
    path: '/',
    name: 'HomeView',
    component: HomeComponent,
    meta: {
        requiresAuth: false
    }
}];