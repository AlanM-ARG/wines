const app = Vue.createApp({
    data(){
        return{
            url: `/api/products/`,
            id: (new URLSearchParams(location.search)).get("id"),
            wine: [],
            wines: [],
        }
    },
    created(){
        this.getdata()
        this.allWinesData()
        
    },
    methods:{
        getdata(){
            axios.get(this.url + this.id)
            .then(data => {
                this.wine = data.data
                console.log(this.wine)
            })
        },
        allWinesData(){
            axios.get("/api/products")
            .then(data =>{
                this.wines = data.data
                console.log(this.wines)
            })
        },
        modificarSaldo(saldo){
            return new Intl.NumberFormat('en-US', { style: 'currency', currency: 'USD' }).format(saldo);
        },
    }
})
app.mount("#app")