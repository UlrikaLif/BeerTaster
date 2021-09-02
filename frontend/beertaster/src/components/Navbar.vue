<template>
  <nav>
    <div v-if="!loggedIn">
      <router-link class="nav-link" to="/">Startsida</router-link>

      <router-link class="nav-link" to="/about">Om oss</router-link>

      <router-link class="nav-link" to="/login">Logga in</router-link>
      
    </div>

    <div v-else>
      <router-link class="nav-link" to="/user-page">Min Sida</router-link>

      <router-link class="nav-link" to="/about">Om oss</router-link>

      <router-link class="nav-link" to="/logout">Logga ut</router-link>
      
    </div>

    
 
  </nav>
</template>

<script>
export default {
  name: "Navbar",

  computed:{
    loggedIn(){
      return this.$store.state.loggedIn;
    },

   
 
  },
  methods:{
    
  }
};
</script>

<style scoped>

a {
  font-weight: 300;
  font-family: "Playfair Display", serif;
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
  margin-right: 5vw;
}

.nav-link:hover {
  color: #00bfa5;
}
</style>
