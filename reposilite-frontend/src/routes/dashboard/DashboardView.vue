<template lang="pug">
    #dashboard-wrapper
        Navbar

        .uk-flex.uk-flex-center
            .uk-grid
                .uk-width-expand
                    .uk-card.uk-card-default.uk-card-body container
                .uk-width-1-3
                    .uk-card.uk-card-default.uk-card-body sidebar
</template>

<script>
    import Navbar from './components/Navbar.vue';

    export default {
        name: 'DashboardView',
        components: {
            Navbar
        }
    }
</script>

<style lang="stylus" scoped>
    #dashboard-wrapper
        height 100vh
        background-color #f7f7f7

    .uk-card
        height 800px

    .uk-width-expand > .uk-card
        width 900px

    .uk-width-1-3 > .uk-card
        width 400px
</style>
