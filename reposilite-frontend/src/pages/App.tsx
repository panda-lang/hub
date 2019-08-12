import React from 'react';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import HomeView from './home/home.view';

const App: React.FC = () => {
    return (
        <Router>
            <Switch>
                <Route exact path='/' component={HomeView} />
            </Switch>
        </Router>
    );
}

export default App;
