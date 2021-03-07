const dev = process && (!process.env.NODE_ENV || process.env.NODE_ENV === 'development')

export default {
  api: dev ? 'http://localhost:8080' : 'hub.api.panda-lang.org'
}