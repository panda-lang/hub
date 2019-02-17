import HomeView from '@/views/landing/home/HomeView'
import ErrorView from '@/views/landing/error/ErrorView'
import LoginView from '@/views/login/LoginView'
import RegisterView from '@/views/register/RegisterView'
import DashboardView from '@/views/dashboard/DashboardLayout'

const route = (path, component, data = {}, meta = {}) => ({
    path, component, name: component.name, ...data, meta
})

export const routes = [
    route('/', HomeView),
    route('*', ErrorView),
    route('/login', LoginView),
    route('/register', RegisterView),
    route('/dashboard', DashboardView)
]