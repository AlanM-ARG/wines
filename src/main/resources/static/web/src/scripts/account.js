const { createApp } = Vue


let app = createApp({
    data() {
        return{
            url:'http://localhost:8080/api/clients/favs',
            url2:'http://localhost:8080/api/clients/current',
            active: 'Profile',
            favs: [],
            client: [],
            editMode: false,
            newPassword: '',
            changeImage:'',
            
            
            
            




        }
    },
    created(){
        this.loadData(this.url)
        this.loadData2(this.url2)


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
        changePassword(){
            axios.patch('/api/clients/current/changePassword',`password=${this.newPassword}`).then(this.editMode = false)
        },
        



    },
    computed:{
        

    },

})

app.mount('#app')

