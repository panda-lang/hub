import { BACKEND } from './constants'

const API = {
	async fetch (url, options) {
		const fetchUrl = url[0] === '/'
			? `${BACKEND}/api/${url}`
			: url

		const res = await fetch(fetchUrl, options)

		if (!res.ok) {
			const err = new Error(`Cannot fetch resource. Status: ${res.status}`)
			err.status = res.status
			err.response = res
			throw err
		}

		// TODO: Handle files

		return res.json()
	},
	async fetchWithData (url, data, headers = {}, method = 'POST') {
		const options = {
			method,
			headers: {
				'Content-Type': 'application/json',
				...headers
			}
		}

		if (data instanceof FormData && data.values().next().value instanceof File) {
			delete options.headers['Content-Type']
			options.body = data
		} else {
			options.body = JSON.stringify(data)
		}

		return fetch(url, options)
	},

	async get (url, headers) {
		return API.fetch(url, { headers })
	},

	async post (url, data, headers = {}) {
		return API.fetchWithData(url, data, headers)
	},

	async put (url, data, headers = {}) {
		return API.fetchWithData(url, data, headers, 'PUT')
	},

	repositories: {
		async all () {
			return API.get('/repositories')
		}
	},
	repository: {
		async entities (qualifier) {
			return API.get(`/repository/${qualifier}`)
		},
		async maven (path, data, token) {
			return API.put(`/repository/maven/${path}`, data, {
				Authorization: `Bearer ${token}`
			})
		}
	},
	users: {
		async signin (data) {
			return API.post('/users/signin', data)
		},
		async signup (data) {
			return API.post('/users/signup', data)
		}
	}
}

export default API
