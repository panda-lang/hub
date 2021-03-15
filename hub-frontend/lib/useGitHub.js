import axios from 'axios'

const endpoint = 'https://api.github.com'

const getEndpoint = (path) => {
  return endpoint + path
}

const useGitHub = async function (path) {
  const response = await axios({
    url: getEndpoint(path),
    method: 'get',
  })

  return response.data
}

export { useGitHub, getEndpoint }
