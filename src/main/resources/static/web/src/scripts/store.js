const app = Vue.createApp({
  data() {
    return {
      apiProducts: "/api/products",
      products: [],
      filteredProducts: [],
      categorys: [],
      categoryFilter: "",
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
    }



  },
  computed: {
    productFilter(){

        if(this.categoryFilter.length && this.categoryFilter != "ALL"){

            this.filteredProducts = this.products.filter( product => product.category == this.categoryFilter)


        }else{
            this.filteredProducts = this.products
        }
    },
  },
}).mount("#app");
