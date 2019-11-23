<<!--
  - Copyright (c) 2018-2019 Reposilite Team
  -
  - Licensed under the Apache License, Version 2.0 (the "License");
  - you may not use this file except in compliance with the License.
  - You may obtain a copy of the License at
  -
  -     http://www.apache.org/licenses/LICENSE-2.0
  -
  - Unless required by applicable law or agreed to in writing, software
  - distributed under the License is distributed on an "AS IS" BASIS,
  - WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
  - See the License for the specific language governing permissions and
  - limitations under the License.
  -->

<template>
    <div class="repository">
        <h5 class="title is-5">Repository - {{ toFormattedPath(qualifier) }}</h5>
        <ul v-if="!error">
            <li v-for="entity in entities">
                <router-link :to="'/repository/' + (qualifier ? qualifier + '/' : '') + entity" @click="updateEntities">&bull; {{ entity }}</router-link>
            </li>
        </ul>
        <p v-else>{{ error }}</p>

        <template v-if="qualifier">
            <br>
            <router-link :to="'/repository/' + getParentPath()">&longleftarrow; back</router-link>
        </template>
    </div>
</template>

<script>
import { BACKEND } from '../constants'

export default {
	data: () => ({
		entities: [],
		qualifier: undefined,
		error: undefined
	}),
	watch: {
		$route () {
			this.updateEntities()
		}
	},
	methods: {
		updateEntities () {
			this.qualifier = this.$route.params['qualifier']
			const url = BACKEND + '/api/repository/' + this.qualifier
			console.log(url)

			this.$http.get(url)
				.then(response => {
					if (!response.headers['content-type'].includes('application/json')) {
						require('js-file-download')(response.data, this.qualifier.split('\\').pop().split('/').pop())
						return
					}

					return (this.entities = response.data)
				})
				.catch(error => {
					if (error.response.status === 404) {
						this.error = 'Empty directory'
					} else {
						(this.error = error.response.status)
					}
				})
		},
		toFormattedPath (path) {
			const firstOccuranceIndex = path.search(/\//) + 1
			const secondOccuranceIndex = firstOccuranceIndex + path.slice(firstOccuranceIndex).search(/\//) + 1
			return path.substr(0, secondOccuranceIndex).replace(/\//g, ' :: ') + path.slice(secondOccuranceIndex).replace(/\//g, '.')
		},
		getParentPath () {
			const elements = this.qualifier.split('/')
			elements.pop()
			return elements.join('/')
		}
	},
	created () {
		this.updateEntities()
	}
}
</script>
