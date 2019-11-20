<!--
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

<script>
export default {
    render: (createElement) => createElement('h5', "Redirecting..."),
    methods: {
        obtainUrlParameter() {
            let url = window.location.search
            return url.includes("?token=") === false ? undefined : url.replace("?token=", "")
        }
    },
    mounted() {
        let token = this.obtainUrlParameter('token')

        if (token !== undefined) {
            localStorage.setItem('access_token', token)
            this.$parent.$parent.fetchUser()
            this.$notify.success('Successfully logged in')
        } else {
            this.$notify.error('An error occurred while trying to signin')
        }

        this.$router.push('/')
    }
}
</script>