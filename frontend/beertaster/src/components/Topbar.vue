<template>
  <div class="header">
    
      <img src="../assets/logoBT.png" alt="BeerTaster logo" />
      
      <router-link class="nav-link" to="/admin">ADMIN</router-link>
              
    
    
  </div>
</template>

<script>
export default {
  name: "Topbar",
};
</script>

<style scoped>

* {
  box-sizing: border-box;
  background-color: rgba(255, 201, 14);
  margin: 0px;
  
}
div{
  text-align: center;
  height: 15vh;
}

.nav-link{
  float:right;
  margin-top: 5vh;
  margin-right: 3vw;
  text-decoration: none;
  color:black;
}

img {
  margin-right: 5px;
  height:100%;
}

</style>
