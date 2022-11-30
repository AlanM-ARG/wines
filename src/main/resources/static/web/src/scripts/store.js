const app = Vue.createApp({
    data() {
        return {
            apiProducts: "/api/products",
            products: [],
        }
    },created() {
        console.log("hola");
            this.getProducts(this.apiProducts)
    },methods: {

        getProducts(api){
            axios.get(api).then(response=>{
                console.log(response);
               
            })
        }
        
    },computed: {
        
    },
}).mount("#app")