const { createApp } = Vue

let app = createApp({
    data() {
        return {
            active: 'Log In',
            email: '',
            password: '',
            firstName: '',
            lastName: '',
            url: ''
        }
    },
    created() {
            this.alert()
    },
    methods: {
        login() {
            axios.post(axios.post('/api/login', `email=${this.email}&password=${this.password}`)
                .then(() => console.log("index"))
                .catch((error) => console.log(error)))
        },
        register() {
            axios.post('/api/clients/create', `firstName=${this.firstName}&lastName=${this.lastName}&email=${this.email}&password=${this.password}&img=aaa`)
                .then(() => Swal.fire('Please confirm your email!', '', 'warning'))
                .catch(error => console.error(error))
        },
        alert() {
            let urlParams = new URLSearchParams(window.location.search)
            let value = urlParams.get('confirmed')
            if (value == 'true') {
                Swal.fire('Email Confirmed!', '', 'success')
            }
        },
    },
    computed: {
    },
})
app.mount('#app')