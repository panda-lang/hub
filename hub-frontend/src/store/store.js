/*
 * Copyright (c) 2020 Hub Team of panda-lang organization
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

import { ACCESS_TOKEN } from '../constants'
import API from '@/api'

Vue.use(Vuex)

export const store = new Vuex.Store({
	state: {
		token: localStorage.getItem(ACCESS_TOKEN),
		user: undefined
	},

	mutations: {
		user (state, user) {
			state.user = user
		},
		token (state, token) {
			state.token = token
		}
	},

	actions: {
		async fetchUser ({ dispatch, state }) {
			if (!state.token) {
				return
			}

			try {
				const user = await API.users.me(state.token)
				dispatch('setUser', {
					...user,
					get id () {
						return this.identifier
					}
				})
			} catch (err) {
				dispatch('removeUser')
				console.log(err)
			}
		},

		setUser ({ commit }, user) {
			localStorage.setItem('user', user)
			commit('user', user)
		},

		removeUser ({ commit }) {
			localStorage.removeItem(ACCESS_TOKEN)
			localStorage.removeItem('user')
			commit('user', undefined)
		},

		setToken ({ commit }, token) {
			localStorage.setItem(ACCESS_TOKEN, token)
			commit('token', token)
		},

		removeToken ({ commit }) {
			localStorage.removeItem(ACCESS_TOKEN)
			commit('token', undefined)
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
