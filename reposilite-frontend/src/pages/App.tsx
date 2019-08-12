import React from 'react';

import { Typography } from 'antd';

const { Title } = Typography;

const App: React.FC = () => {
    return (
        <div className="App">
            <header className="App-header">
                <Title level={2}>Reposilite</Title>
            </header>
        </div>
    );
}

export default App;
