<template lang="pug">
    #home-wrapper
        // Description
        .uk-position-large.uk-position-center-left.uk-padding-large
            h1 Reposilite
            h2 Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
            br
            button(href="#" class="github-button uk-box-shadow-large") Sign in using Github

        // Search
        Search
</template>

<script>
    import Search from './components/Search.vue';

    export default {
        name: 'HomeView',
        components: {
            Search
        }
    }
</script>

<style lang="stylus" scoped>
    @import url('https://fonts.googleapis.com/css?family=Titillium+Web')
    @import url('https://fonts.googleapis.com/css?family=Raleway')
    @import url('https://fonts.googleapis.com/css?family=Rubik')

    #home-wrapper
        background-color #2c3e50

    h1
        color #e6e6e6;
        font-size 14
        font-family 'Titillium Web', sans-serif
        font-weight bold

    h2
        color #999999
        font-size 14px
        font-family 'Raleway', sans-serif
        font-weight medium
        max-width 500px

    .github-button
        width 320px
        height 45px
        color white
        font-size 12px
        font-family 'Rubik', sans-serif
        text-transform uppercase
        letter-spacing 2px
        background linear-gradient(135deg, #e91653 0%, #1c7586 100%)
        border none
        border-radius 25px
        cursor pointer
</style>
