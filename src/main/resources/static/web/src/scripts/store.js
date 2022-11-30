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
           
    },methods: {

        getProducts(api){
            axios.get(api).then(data=>{
                console.log(data)
                this.products = data.data
                this.getCategorys(this.products)
                console.log(this.categorys);
            })
        },getCategorys(array){
            let categorias = []

            array.forEach(element => {
                categorias.push(element.category)
            });

            let categorias1 = new Set(categorias)
            let categorias2 = [...categorias1]
            
            this.categorys = categorias2

        }   
        
    },computed: {
        
    },
}).mount("#app")