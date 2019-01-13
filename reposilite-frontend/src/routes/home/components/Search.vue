<template lang="pug">
    #search-wrapper
        .uk-position-center-right.search-overlay
            .uk-position-center
                vue-autosuggest(:suggestions="filteredOptions" :render-suggestion="renderSuggestion" :get-suggestion-value="getSuggestionValue" :input-props="inputProps")
</template>

<script>
    import { VueAutosuggest } from 'vue-autosuggest';

    export default {
        name: 'Search',
        components: {
            VueAutosuggest
        },
        data() {
            return {
                selected: '',
                filteredOptions: [],
                inputProps: {
                    id: 'autosuggest__input',
                    onInputChange: this.onInputChange,
                    placeholder:'Search'
                },
                suggestions: [
                    {
                        data: [
                            { id: 1, name: 'Reposilite', avatar: 'https://www.mymiraclebaby.com.sg/wp-content/uploads/2016/02/Janod-%E2%80%93-Clown-Letter-Rrrr.jpg' },
                            { id: 2, name: 'Panda', avatar: 'https://s3.eu-central-1.amazonaws.com/zooparc/assets/pandas/panda_huan_huan_400x400_002.jpg' },
                            { id: 3, name: 'Light', avatar: 'https://elektro-hurt.com/img/products/12/21/6/1.jpg' },
                            { id: 4, name: 'test', avatar: 'https://5.allegroimg.com/s400/033dee/178c624243209e8aba52e1963745' }
                        ]
                    }
                ]
            }
        },
        methods: {
            onInputChange(text) {
                if (text === null) {
                    return;
                }

                const filteredData = this.suggestions[0].data.filter(option => {
                    return option.name.toLowerCase().indexOf(text.toLowerCase()) > -1;
                });

                this.filteredOptions = [{ data: filteredData }];
            },
            renderSuggestion(suggestion) {
                const character = suggestion.item;
                return (
                    <div
                        style={{
                        display: "flex",
                        alignItems: "center"
                    }}>
                        <img
                            style={{
                                width: "25px",
                                height: "25px",
                                borderRadius: "15px",
                                marginRight: "10px"
                            }}
                            src={ character.avatar }
                        />
                        <span style={{ color: "navyblue" }}>{character.name}</span>
                    </div>
                );
            },
            getSuggestionValue(suggestion) {
                return suggestion.item.name;
            }
        }
    }
</script>

<style lang="stylus">
    @import url('https://fonts.googleapis.com/css?family=Titillium+Web')

    border-radius()
        -webkit-border-radius arguments
        -moz-border-radius arguments
        border-radius arguments

    dark-overlay()
        &:after
            content ""
            width 100%
            height auto
            position absolute
            z-index -1
            top 0
            right 0
            left 0
            bottom 0

    #autosuggest
        position relative
        filter drop-shadow(0 0 10px black)

    #autosuggest__input
        outline none
        border none
        border-radius(0px)
        position relative
        display block
        padding 10px
        width 380px
        font-size 14px
        font-family 'Titillium Web', sans-serif
        &.autosuggest__input-open
            border-bottom-left-radius 0
            border-bottom-right-radius 0

    .autosuggest__results-container
        font-size 14px
        font-family'Titillium Web', sans-serif
        position absolute
        top 100%
        width 100%
        overflow hidden
        ::-webkit-scrollbar
            display none
        ::-webkit-scrollbar-track-piece
            background-color: transparent
            -webkit-border-radius: 6px

    .autosuggest__results
        margin 0
        z-index 10000001
        width 100%
        border 1px solid #e0e0e0
        border-radius 0 0 4px 4px
        background white
        padding 0px
        max-height 400px
        overflow-y scroll
        ul
            list-style none
            padding-left 0
            margin 0

	.autosuggest__results_item
        cursor pointer
        padding 15px

    .autosuggest__results_title
        color gray
        font-size 11px
        margin-left 0
        padding 15px 13px 5px
        border-top 1px solid lightgray


    .autosuggest__results_item:active,
    .autosuggest__results_item:hover,
    .autosuggest__results_item:focus,
    .autosuggest__results_item.autosuggest__results_item-highlighted
        background-color #f7f7f7

    .search-overlay
        background-size cover
        background-image url("../../../assets/bg.jpg")
        height 100%
        width 40%
        z-index 1
        dark-overlay()
        &:after
            background-color rgba(0, 0, 0, 0.5)
</style>
