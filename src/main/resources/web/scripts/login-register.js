

const { createApp } = Vue


let app = createApp({
    data() {
        return{
           active: 'Log In',
           email: '',
           password: '',
           firstName: '',
           lastName: '',
           url: ''
            

        }
    },
    created(){
        this.alert()


    },
    methods:{

    login(){
        axios.post(axios.post('/api/login',`email=${this.email}&password=${this.password}`)
        .then(response => window.location.href = "http://localhost:8080/web/index.html")
        .catch((error)=>  console.log(error)))
    },
    register(){
        axios.post('/api/clients',`firstName=${this.firstName}&lastName=${this.lastName}&email=${this.email}&password=${this.password}`)
        .then(response => this.signIn())
        .catch((error)=> this.errorRegister = true)
    },
        alert(){
            if (window.location.search == '?confirmed') {
                Swal.fire('Email Confirmed!', '', 'success')
                .then(()=> window.location.search = '')
            }
        }
       
        
        

    },
    computed:{
        

    },

})

app.mount('#app')