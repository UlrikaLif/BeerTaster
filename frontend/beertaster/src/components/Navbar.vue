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
  background-color: black;
  padding: 15px 0px;
}

img {
  margin-right: 5px;
}

.nav-link {
  text-decoration: none;
  color: rgb(255, 201, 14);
  font-size: 30px;
  margin-right: 5vw;
}

.nav-link:hover {
  color: whitesmoke;
}
</style>
