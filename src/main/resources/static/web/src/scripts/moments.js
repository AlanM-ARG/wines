const { createApp } = Vue
createApp({
    data() {
        return {
            title: "",
            description: "",
        }
    },
    created() {

    },
    methods: {
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