const app = Vue.createApp({
  data() {
    return {
      apiProducts: "/api/products",
      products: [],
      filteredProducts: [],
      categorys: [],
      filterData: {
        category: "",
        name:"",
        priceMax: 0
      }
    };
  },
  created() {
    this.getProducts(this.apiProducts);
    console.log("funciona");
  },
  methods: {
    getProducts(api) {
      axios.get(api).then((data) => {
        console.log(data);
        this.products = data.data;
        this.filteredProducts = this.products
        this.getCategorys(this.products);
        console.log(this.categorys);
      });
    },
    getCategorys(array) {
      let categorias = [];

      array.forEach((element) => {
        categorias.push(element.category);
      });

      let categorias1 = new Set(categorias);
      let categorias2 = [...categorias1];

      this.categorys = categorias2;
    },
    getVariertys(array) {
      let categorias = [];

      array.forEach((element) => {
        categorias.push(element.category);
      });

      let categorias1 = new Set(categorias);
      let categorias2 = [...categorias1];

      this.categorys = categorias2;
    },
    wine(wineCategory) {
      if (
        wineCategory == "WHITE" ||
        wineCategory == "RED" ||
        wineCategory == "ROSE"
      ) {
        return wineCategory + " WINE";
      } else return wineCategory;
    },filterCategory(array){

        let filteredProducts = []

        if(this.filterData.category.length && this.filterData.category != "ALL"){

           filteredProducts = array.filter( product => product.category == this.filterData.category)

           return filteredProducts

        }else{
            filteredProducts = this.products
            return filteredProducts
        }

        

    },filterName(array){
        let filteredProducts = []

        if(this.filterData.name.length){

            filteredProducts = array.filter( product => product.name.toLowerCase().contains((this.filterData.name.toLowerCase())) )

            return filteredProducts 

        }else{
            filteredProducts = array
            return filteredProducts 
        }
 
        
    },filterPrice(array){
        let filteredProducts = []
        if(this.filterData.priceMax >0){
            filteredProducts = array.filter( producto => {producto.price >= this.filterData.priceMin && producto.price <= this.filterData.priceMax})

        }else if(this.filterData.priceMax <=0){
            filteredProducts = array
        }

        return filteredProducts 
    }



  },
  computed: {

    filterFinal(){

        if(this.filterData.category.length || this.filterData.name.length || this.filterData.priceMax.length){
            
            this.filteredProducts =  this.filterName(this.filterCategory(this.products))
        }
        
    }
   
  },
}).mount("#app");
