const app = Vue.createApp({
    data() {
        return {
            apiProducts: "/api/products"
        }
    },created() {
            
    },methods: {

        getProducts(api){
            axios.get(api).then(data=>{
                
            })
        }
        
    },computed: {
        
    },
})