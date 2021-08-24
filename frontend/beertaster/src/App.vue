<template>
  <header>
    <Topbar></Topbar>
    <Navbar></Navbar>
    <router-view/>
  
  </header>  
</template>

<script setup>
import Topbar from './components/Topbar.vue'
import Navbar from './components/Navbar.vue'

</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
