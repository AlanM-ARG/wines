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
<<<<<<< HEAD:src/main/resources/static/web/scripts/age-verification.js
            localStorage.setItem('Drinking Age', true);
            /* window.location.href = "http://localhost:8080/web/index.html" */
            console.log('se guardo');
=======
            
            window.location.href = "http://localhost:8080/web/index.html"
            
>>>>>>> main:src/main/resources/static/web/src/scripts/age-verification.js
        }

    },
    computed:{
<<<<<<< HEAD:src/main/resources/static/web/scripts/age-verification.js
        cookieChecker(){
            const age = localStorage.getItem('Drinking Age');
            if(age === true){
                /* window.location.href = "http://localhost:8080/web/index.html" */
                return console.log('paso directamente');
            }
        }
=======
        
>>>>>>> main:src/main/resources/static/web/src/scripts/age-verification.js

    },

})

app.mount('#app')

