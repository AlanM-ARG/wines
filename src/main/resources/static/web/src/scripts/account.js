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
<<<<<<< HEAD:src/main/resources/static/web/scripts/account.js
=======
            changeImage:'',
>>>>>>> main:src/main/resources/static/web/src/scripts/account.js
            
            
            
            




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
<<<<<<< HEAD:src/main/resources/static/web/scripts/account.js
=======
        
>>>>>>> main:src/main/resources/static/web/src/scripts/account.js



    },
    computed:{
        

    },

})

app.mount('#app')

