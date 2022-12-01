const { createApp } = Vue


let app = createApp({
    data() {
        return{
            
            
            




        }
    },
    created(){
        


    },

    methods:{
        drinkingAgeYes(){
            localStorage.setItem('Drinking Age', true);
            /* window.location.href = "http://localhost:8080/web/index.html" */
            console.log('se guardo');
        }

    },
    computed:{
        cookieChecker(){
            const age = localStorage.getItem('Drinking Age');
            if(age === true){
                /* window.location.href = "http://localhost:8080/web/index.html" */
                return console.log('paso directamente');
            }
        }

    },

})

app.mount('#app')

