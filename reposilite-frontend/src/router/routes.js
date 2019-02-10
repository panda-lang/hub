import HomeView from '../routes/home/HomeView';
import LoginView from '../routes/login/LoginView';
import RegisterView from '../routes/register/RegisterView';
import DashboardView from '../routes/dashboard/DashboardView'

const route = (path, component, data = {}, meta = {}) => ({
    path, component, name: component.name, ...data, meta
})

export const routes = [
    route('/', HomeView),
    route('/login', LoginView),
    route('/register', RegisterView),
    route('/dashboard', DashboardView),
];
