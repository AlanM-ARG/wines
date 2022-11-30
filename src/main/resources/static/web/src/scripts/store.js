const app = Vue.createApp({
    data() {
        return {
            apiProducts: "/api/products",
            products: [],
            categorys: []
        }
    },created() {
            this.getProducts(this.apiProducts)
            console.log("funciona");
            this.getCategorys(this.products)
            console.log(categorys);
    },methods: {

        getProducts(api){
            axios.get(api).then(data=>{
                console.log(data)
                this.products = data.data
            })
        },getCategorys(array){

            let categorias = []

            array.forEach(element => {
                categorias.push(element.category)
            });

           

        }   
        
    },computed: {
        
    },
}).mount("#app")