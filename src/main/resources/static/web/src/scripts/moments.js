const app = Vue.createApp({
  data() {
    return {
      url: "http://localhost:8080/api/clients/moments",
      moments: [],
      title: "",
      description: "",
      img: "",
    };
  },
  created() {
    this.getdata();
  },
  methods: {
    getdata() {
      axios.get(this.url).then((data) => {
        this.moments = data.data;
      });
    },
    createMoment() {
      axios
        .post(
          "/api/admin/products/create",
          `img=${this.img}&title=${this.title}&description=${this.description}`
        )
        .then();
    },
  },
});
app.mount("#app");
