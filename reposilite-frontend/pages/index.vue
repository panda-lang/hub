<template>
    <section class="section">
        <div class="columns is-mobile">
            <card icon="github-circle" title="Free">
                Open source on <a href="https://github.com/buefy/buefy">
                GitHub
            </a>
            </card>

            <card icon="cellphone-link" title="Responsive">
                <b class="has-text-grey">
                    Every
                </b> component is responsive
            </card>

            <card icon="alert-decagram" title="Modern">
                Built with <a href="https://vuejs.org/">
                Vue.js
            </a> and <a href="http://bulma.io/">
                Bulma
            </a>
            </card>

            <card icon="arrange-bring-to-front" title="Lightweight">
                No other internal dependency
            </card>
        </div>
    </section>
</template>

<script>
    import Card from '~/components/Card'

    export default {
        name: 'HomePage',

        components: {
            Card
        }
    }
</script>
