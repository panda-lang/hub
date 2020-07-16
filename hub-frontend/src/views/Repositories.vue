<!--
  - Copyright (c) 2020 Hub Team of panda-lang organization
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
    <div class="repositories">
        <h5 class="title is-5">Repositories</h5>
        <ul>
            <li v-for="(repository, i) in repositories" :key="i">
                <router-link :to="'/repository/' + repository">&bull; {{ repository }}</router-link>
            </li>
        </ul>
    </div>
</template>

<script>
import API from '../api'

export default {
	name: 'Repositories',
	data: () => ({
		repositories: []
	}),
	async mounted () {
		this.repositories = await API.repositories.all()
	}
}
</script>
