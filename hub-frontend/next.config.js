module.exports = {
  async rewrites() {
    return [
      {
        source: '/xxx',
        destination: '/',
      },
    ]
  },
}