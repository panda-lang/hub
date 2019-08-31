const fastify = require('fastify')()

fastify.register(require('point-of-view'), {
    engine: {
        ejs: require('pug')
    }
})

fastify.get('/', (req, reply) => {
    reply.view('/templates/index.pug', { text: 'text' })
})

fastify.listen(3000, err => {
    if (err) throw err
    console.log(`server listening on ${fastify.server.address().port}`)
})