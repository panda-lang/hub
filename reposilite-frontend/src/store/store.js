/*
 * Copyright (c) 2018-2019 Reposilite Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import Vue from 'vue'
import Vuex from 'vuex'
import Axios from 'axios'
import { ACCESS_TOKEN, USER_DETAILS } from '../constants'

Vue.use(Vuex)

export const store = new Vuex.Store({
	state: {
		token: localStorage.getItem(ACCESS_TOKEN),
		user: undefined
	},

	mutations: {
		SET_USER: (state, user) => {
			state.user = user
		},
		SET_TOKEN: (state, token) => {
			state.token = token
		}
	},

	actions: {
		fetchUser ({ dispatch, state }) {
			if (!state.token) {
				return
			}

			Axios.get(USER_DETAILS, {
				headers: {
					Authorization: `Bearer ${state.token}`
				}
			}).then(response => {
				const user = {
					avatar: this.avatar,
					id: this.identifier,
					name: this.name,
					provider: this.provider,
					providerId: this.providerId,
					username: this.username,
					email: this.email,
					roles: this.roles
				} = response.data

				dispatch('setUser', user)
			}).catch(function (error) {
				dispatch('removeUser')
				console.log(error)
			})
		},
		setUser ({ commit }, user) {
			localStorage.setItem('user', user)
			commit('SET_USER', user)
		},
		removeUser ({ commit }) {
			localStorage.removeItem(ACCESS_TOKEN)
			localStorage.removeItem('user')
			commit('SET_USER', undefined)
		},
		setToken ({ commit }, token) {
			localStorage.setItem(ACCESS_TOKEN, token)
			commit('SET_TOKEN', token)
		},
		removeToken ({ commit }) {
			localStorage.removeItem(ACCESS_TOKEN)
			commit('SET_TOKEN', undefined)
		}
	},

	getters: {
		isAdmin (state) {
			return state.user.roles && state.user.roles
				.map(value => value.name)
				.includes('ADMIN')
		}
	}
})
