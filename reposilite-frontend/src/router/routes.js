import HomeView from '../routes/home/HomeView';
import LoginView from '../routes/login/LoginView';
import RegisterView from '../routes/register/RegisterView';
import DashboardView from '../routes/dashboard/DashboardView'

export const routes = [
    {
        path: '/',
        name: 'HomeView',
        component: HomeView,
        meta: {
            requiresAuth: false
        }
    },
    {
        path: '/login',
        name: 'LoginView',
        component: LoginView,
        meta: {
            requiresAuth: false
        }
    },
    {
        path: '/register',
        name: 'RegisterView',
        component: RegisterView,
        meta: {
            requiresAuth: false
        }
    },
    {
        path: '/dashboard',
        name: 'DashboardView',
        component: DashboardView,
        meta: {
            requiresAuth: false
        }
    }
];