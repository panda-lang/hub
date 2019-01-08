<template lang="pug">
    #search-wrapper
        .uk-position-center-right.search-overlay
            .uk-position-center
                autocomplete(input-class='autocomplete__inputs' :source='mocks')
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

<style lang="stylus">
    @font-face {
        font-family: 'Titillium Web';
        url('https://fonts.googleapis.com/css?family=Titillium+Web');
    }

    border-radius()
        -webkit-border-radius arguments
        -moz-border-radius arguments
        border-radius arguments

    .autocomplete__box
        width 380px
        height 50px
        border-radius(25px)

    .autocomplete__inputs
        height 40px
        font 14px 'Titillium Web', sans-serif
        color black
        border none
        vertical-align middle
        border-radius 25px

    .search-overlay
        background-size cover
        background-image url("../../../assets/bg.jpg")
        height 100%
        width 40%
        z-index 1
        @include dark-overlay
        &:after {
            background-color rgba(black, 0.5)
        }


</style>
