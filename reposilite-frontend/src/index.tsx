import React from 'react';
import ReactDOM from 'react-dom';

import * as serviceWorker from './serviceWorker';

import App from './pages/App';

ReactDOM.render(<App />, document.getElementById('app'));

serviceWorker.unregister();
