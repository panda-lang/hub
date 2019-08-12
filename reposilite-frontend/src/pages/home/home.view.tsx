import React from 'react';

import { Typography } from 'antd';

const { Title } = Typography;

const HomeView: React.FC = () => {
    return (
        <div className='Home'>
            <header className='Home-header'>
                <Title level={2}>Reposilite</Title>
            </header>
        </div>
    );
}

export default HomeView;
