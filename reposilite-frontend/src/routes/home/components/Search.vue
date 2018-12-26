<template>
    <div id="search-wrapper">
        <div class="uk-position-center-right search-overlay">
            <autocomplete class="uk-position-center autocomplete__box" input-class="autocomplete__inputs" :source="mocks"></autocomplete>
        </div>
    </div>
</template>

<script>
    import Autocomplete from 'vuejs-auto-complete';

    export default {
        name: 'Search',
        components: {
            Autocomplete
        },
        data() {
            return {
                input: '',
                mocks: [
                    {
                        id: 0,
                        name: 'Panda',
                        description: 'Panda is a lightweight and powerful programming language written in Java.'
                    },
                    {
                        id: 1,
                        name: 'Light',
                        description: 'Light is English-like programming language built on the core of the Panda Programming Language.'
                    },
                    {
                        id: 2,
                        name: 'Reposilite',
                        description: 'Lightweight repository management software mainly dedicated for Maven and Panda-based artifacts.'
                    },
                    {
                        id: 3,
                        name: 'test 🌈',
                    }
                ]
            }
        },
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

    .autocomplete__box {
        background-color: white;
        border-radius: 25px;
        width: 320px;
        border: 0px;
        outline: none;

    }

    .autocomplete__inputs {
        height: 40px;
        font-family: 'Titillium Web', sans-serif;
        font-size: 14px;
        color: black;
        border: none;
        outline: none;
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
