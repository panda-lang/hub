import axios from 'axios'
import hubConfiguration from '../hub.config'

const getEndpoint = function (path) {
  return hubConfiguration.api + path
}

const useClient = async function (path, token, options) {
  const response = await axios({
    url: getEndpoint(path),
    method: 'get',
    headers: {
      Authorization: `Bearer ${token}`,
    },
    ...options,
  })

  return response.data
}

export { useClient, getEndpoint }
