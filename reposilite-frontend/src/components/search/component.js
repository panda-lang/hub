import { VueAutosuggest } from 'vue-autosuggest'

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
                placeholder: 'Search'
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
            if (!text) {
                this.filteredOptions = []
                return
            }

            const filteredData = this.suggestions[0].data.filter(option => {
                return option.name.toLowerCase().indexOf(text.toLowerCase()) > -1
            })

            this.filteredOptions = [{ data: filteredData }]
        },
        renderSuggestion(suggestion) {
            const character = suggestion.item
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
            )
        },
        getSuggestionValue(suggestion) {
            return suggestion.item.name
        }
    }
}