import useSWR from "swr"
import axios from 'axios'
import hubConfiguration from '../hub.config'
import { useAuth } from "../components/AuthProvider"

const fetcher = (url, options) => axios
  .get(url, options)
  .then(response => response.data)

export default async function useClient(path, token, options) {
  // return useSWR([url, requestOptions], fetcher)
  const response = await axios({
    url: hubConfiguration.api + path,
    method: 'get',
    headers: {
      Authorization: `Bearer ${token}`,
    },
    ...options
  })

  return response.data
}