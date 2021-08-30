<template>
  <nav>
    <div v-if="!loggedIn">
      <a class="nav-link" href="/">Startsida</a>

      <a class="nav-link" href="/login">Logga in</a>
      
    </div>

    <div v-else>
      <a class="nav-link" href="/user-page">Min Sida</a>

      <a class="nav-link" href="/logout" @click="test">Logga ut</a>
      
    </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar",

  computed:{
          loggedIn(){
              return this.$store.state.loggedIn;
          }
  },
  methods:{
    test(){
      this.$store.commit('setLoggedIn', false)
      this.$router.push('/')
    }
  }
};
</script>

<style scoped>
a {
  font-weight: 300;
  font-family: "Playfair Display", serif;
  font-size: 25px;
}

nav {
  -webkit-box-shadow: 0 8px 6px -6px rgb(124, 124, 124);
  -moz-box-shadow: 0 8px 6px -6px rgb(153, 153, 153);
  box-shadow: 0 8px 6px -6px rgb(153, 153, 153);
}

img {
  margin-right: 5px;
}

.nav-link {
  text-decoration: none;
  color: rgb(245, 183, 13);
  font-size: 30px;
  margin-right: 30px;
}

.nav-link:hover {
  color: #00bfa5;
}
</style>
