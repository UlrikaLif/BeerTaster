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
*{
  box-sizing: border-box;
}

#app {
  font-family: Helvetica, Arial, sans-serif;
  text-align: center;
  color: #2c3e50;
  box-sizing: border-box;
}
</style>
