const app = Vue.createApp({
    data() {
        return {
            apiProducts: "/api/products",
            products: [],
        }
    },created() {
            this.getProducts(this.apiProducts)
            console.log("funciona");
    },methods: {

        getProducts(api){
            axios.get(api).then(data=>{
                console.log(data)
                this.products = data.data
            })
        }
        
    },computed: {
        
    },
}).mount("#app")