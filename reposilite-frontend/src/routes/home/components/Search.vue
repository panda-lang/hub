<template>
    <div id="search-wrapper">
        <div class="uk-position-center-right search-overlay">
            <div class="uk-position-center uk-search uk-search-default">
                <span uk-search-icon></span>
                <input class="uk-search-input" type="search" placeholder="Search" v-model="input" @input="searchInput">
            </div>

        </div>
    </div>
</template>

<script>
    //eslint-disable-next-line
    import axios from 'axios';

    export default {
        name: 'Search',
        data() {
            return {
                input: '',
                results: [],
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
                    },
                    {
                        id: 3,
                        name: 'dzikoysk',
                        description: ''
                    },
                    {
                        id: 4,
                        name: 'netsu',
                        description: ''
                    }
                ]

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

    .uk-search {
        background-color: white;
        width: 400px;
        border-radius: 25px;
    }

    .uk-search-input {
        border-radius: 25px;
        border-color: #666666;
    }

    .search-overlay {
        position: relative;
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

    .search-input {
        font-family: 'Titillium Web', sans-serif;
        font-size: 12px;
        color: black;
        background-color: white;
    }
</style>
