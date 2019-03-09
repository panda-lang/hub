import Search from '@/components/search/Search'

export default {
    name: 'Navbar',
    components: {
        Search
    },
    data() {
        return {
            userAvatar: 'https://store.playstation.com/store/api/chihiro/00_09_000/container/US/en/99/UP2538-CUSA05620_00-AV00000000000118//image?_version=00_09_000&platform=chihiro&w=720&h=720&bg_color=000000&opacity=100',
            username: 'awesome user 🐢'
        }
    }
}