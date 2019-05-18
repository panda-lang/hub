module.exports = {
    type: 'select',
    name: 'variant',
    message: 'Select the services to launch',
    choices: [
        { title: 'Reposilite Backend (server)', value: 'frontend' },
        { title: 'Reposilite Backend (server) + Frontend (website)', value: 'full' }
    ],
    initial: 1
}