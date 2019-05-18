module.exports = {
    type: 'select',
    name: 'variant',
    message: 'Select the services to launch',
    choices: [
        { title: 'Reposilite Backend (server)', value: 'backend' },
        { title: 'Reposilite Frontend (website)', value: 'frontend' },
        { title: 'Reposilite Backend (server) + Frontend (website)', value: 'backend + frontend' }
    ],
    initial: 2
}