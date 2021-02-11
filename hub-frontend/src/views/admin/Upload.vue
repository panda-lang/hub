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
    <div class="admin-upload columns is-centered">
        <form class="column is-centered" ref="form" @submit.prevent="uploadFiles">
            <b-field>
                <h1 class="subtitle">Upload artifact</h1>
            </b-field>

            <b-field>
                <b-input v-model="path" placeholder="Path" required></b-input>
            </b-field>

            <b-field>
                <h4>Select files to upload</h4>
            </b-field>

            <b-field>
                <b-upload v-model="dropFiles" multiple drag-drop>
                    <section class="section">
                        <div class="content has-text-centered">
                            <p><b-icon icon="upload" size="is-large"></b-icon></p>
                            <p>Drop your files here or click to upload</p>
                        </div>
                    </section>
                </b-upload>
            </b-field>

            <div class="tags">
                <span v-for="(file, index) in dropFiles" :key="index" class="tag is-primary" >
                    {{file.name}}
                    <button class="delete is-small" type="button" @click="deleteDropFile(index)"></button>
                </span>
            </div>

            <b-field class="file">
                <button class="button is-primary" type="submit">
                    <b-icon icon="upload"></b-icon>
                    <span>Click to upload</span>
                </button>
            </b-field>
        </form>
    </div>
</template>

<script>
import API from '../../api'

export default {
	name: 'Upload',
	data: () => ({
		path: '',
		dropFiles: []
	}),
	methods: {
		deleteDropFile (index) {
			this.dropFiles.splice(index, 1)
		},
		uploadFiles () {
			const accessToken = localStorage.getItem('access_token')

			this.dropFiles.forEach(async file => {
				const formData = new FormData()
				formData.append('file', file)

				try {
					await API.repository.maven(`/${this.path}`, formData, accessToken)
					this.$notify.success('Successfully uploaded artifact!')
				} catch (err) {
					// TODO: Get error reason
					this.$notify.error('Cannot upload artifact')
				}
			})
		}
	}
}
</script>

<style lang="sass">
.admin-upload
  text-align: center
.admin-upload form
  max-width: 350px
.file .button
  width: 350px
</style>
