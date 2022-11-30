

const { createApp } = Vue



let app = createApp({
    data() {
        return{
           active: 'Time4Wine',
           scrollPosition: null
           
            

        }
    },
    created(){
        


    },
    methods:{

        updateScroll() {
            this.scrollPosition = window.scrollY
          }

       
        
        

    },
    computed:{
        

    },
    mounted() {
    window.addEventListener('scroll', this.updateScroll);
  }

})

app.mount('#app')