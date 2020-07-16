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
import Router from 'vue-router'

Vue.use(Router)

export const router = new Router({
	mode: 'history',
	base: process.env.BASE_URL,
	routes: [
		{
			path: '/',
			name: 'Home',
			component: () => import('./views/Home.vue')
		},
		{
			path: '/about',
			name: 'About',
			component: () => import('./views/About.vue')
		},
		{
			path: '/login',
			name: 'Login',
			component: () => import('./views/Login.vue')
		},
		{
			path: '/news',
			name: 'News',
			component: () => import('./views/News.vue')
		},
		{
			path: '/register',
			name: 'Register',
			component: () => import('./views/Register.vue')
		},
		{
			path: '/oauth2/redirect',
			name: 'Redirect',
			component: () => import('./views/OAuth2.vue')
		},
		{
			path: '/repositories',
			name: 'Repositories',
			component: () => import('./views/Repositories.vue')
		},
		{
			path: '/repository',
			name: 'Repositories Redirect',
			redirect: '/repositories'
		},
		{
			path: '/repository/:qualifier(.*)',
			name: 'Repository',
			component: () => import('./views/Repository.vue')
		},
		{
			path: '/admin',
			component: () => import('./views/Admin.vue'),

			children: [
				{
					path: '',
					name: 'Admin Dashboard',
					component: () => import('./views/admin/Dashboard.vue')
				},
				{
					path: 'upload',
					name: 'Admin Upload',
					component: () => import('./views/admin/Upload.vue')
				}
			]
		},
		{
			path: '*',
			name: 'Page Not Found',
			component: () => import('./views/PageNotFound.vue')
		}
	]
})
