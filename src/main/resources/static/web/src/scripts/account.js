const { createApp } = Vue


let app = createApp({
    data() {
        return{
            url:'http://localhost:8080/api/clients/favs',
            url2:'http://localhost:8080/api/clients/current',
            url3:'http://localhost:8080/api/clientcurrent/purchaseorder',
            active: 'Profile',
            favs: [],
            client: [],
            orders: [],
            editMode: false,
            newPassword: '',
            changeImage:'',
            
            
            
            




        }
    },
    created(){
        this.loadData(this.url)
        this.loadData2(this.url2)
        this.loadData3(this.url3)

    },

    methods:{
        loadData(url){
            axios.get(url)

            .then((data) => {

                this.favs = data.data
                console.log(this.favs);
            })
        },
        loadData2(url){
            axios.get(url)

            .then((data) => {

                this.client = data.data
                console.log(this.client);
            })
        },
        loadData3(url){
            axios.get(url)

            .then((data) => {

                this.orders = data.data
                console.log(this.orders);
            })
        },
        changePassword(){
            axios.patch('/api/clients/current/changePassword',`password=${this.newPassword}`).then(this.editMode = false)
        },
        loadData3(url){
            axios.get(url)

            .then((data) => {

                this.order = data.data
                console.log(this.order);
            })
        }
        



    },
    computed:{
        

    },

})

app.mount('#app')

