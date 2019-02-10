import LandingView from '../views/landing/home/HomeView';
import LoginView from '../views/login/LoginView';
import RegisterView from '../views/register/RegisterView';
import DashboardView from '../views/dashboard/home/HomeView'

export const routes = [
    {
        path: '/',
        name: 'LandingView',
        component: LandingView,
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