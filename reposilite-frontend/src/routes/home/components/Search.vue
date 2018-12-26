<template>
    <div id="search-wrapper">
        <div class="uk-position-center-right search-overlay">
            <div class="uk-position-center search">
                <span class="uk-margin-left uk-margin-right" uk-icon="icon: search; ratio: 0.7" />
                <input type="search" placeholder="Search" v-model="input" @input="searchInput">
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        name: 'Search',
        data() {
            return {
                input: '',
                results: []
            }
        },
        methods: {
            searchInput() {
                var mocks = [
                    {
                        id: 0,
                        name: 'Panda',
                        description: 'Panda is a lightweight and powerful programming language written in Java.'
                    },
                    {
                        id: 1,
                        name: 'Light',
                        description: 'Light is English-like programming language built on the core of the Panda Programming Language'
                    },
                    {
                        id: 2,
                        name: 'Reposilite',
                        description: 'Lightweight repository management software mainly dedicated for Maven and Panda-based artifacts'
                    }
                ];

                this.results = mocks;
            }
        }
    }
</script>

<style lang="scss" scoped>
    @import url('https://fonts.googleapis.com/css?family=Titillium+Web');

    @mixin dark-overlay {
        &:after {
            content: "";
            height: 100%;
            width: 100%;
            position: fixed;
            z-index: -1;
        }
    }

    .search {
        background-color: white;
        width: 400px;
        border-radius: 25px;

        input {
            height: 40px;
            width: 320px;
            font-family: 'Titillium Web', sans-serif;
            font-size: 14px;
            color: black;
            border: none;
            background: none;
        }

        input:focus {
            outline: none;
        }
    }

    .search-overlay {
        background-size: cover;
        background-image: url("../../../assets/bg.jpg");
        height: 100%;
        width: 40%;
        z-index: 1;
        @include dark-overlay;
    }

    .search-overlay:after {
        background-color: rgba(black, 0.5);
    }
</style>
