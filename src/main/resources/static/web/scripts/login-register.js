const { createApp } = Vue
createApp({
    data() {
        return {
            active: 'Log In',
            email: '',
            password: '',
            firstName: '',
            lastName: '',
            url: '',
            title: '',
            description: '',
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
            axios.post('/api/clients/create', `firstName=${this.firstName}&lastName=${this.lastName}&email=${this.email}&password=${this.password}`)
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
        createMoment() {
            let form = document.querySelector('#createMoment')
            let formData = new FormData(form)
            formData.append('upload_preset', 'r16u29xq')
            axios.post('https://api.cloudinary.com/v1_1/dlfic0owc/image/upload', formData)
                .then(response => {
                    axios.post("/api/clients/moments", "img=" + response.data.secure_url + "&title=" + this.title + "&description=" + this.description)
                        .then(() => Swal.fire('Uploaded!', '', 'success'))
                })
                .catch(err => console.error(err))
        }
    },
    computed: {
    },
})
.mount('#app')