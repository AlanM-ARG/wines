const app = Vue.createApp({
    data() {
        return {
            apiProducts: "/api/products",
            products: [],
        }
    },created() {
            this.getProducts(this.apiProducts)
    },methods: {

        getProducts(api){
            axios.get(api).then(data=>{
                this.products = data.data
            })
        }
        
    },computed: {
        
    },
})