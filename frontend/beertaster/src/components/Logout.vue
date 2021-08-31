<template>
    <div>
        <h3> Du är nu utloggad - Tack för besöket!</h3>

    </div>

</template>

<script>
export default {
name: "Logout",

data(){
    return {

    }
},

computed:{

},

methods: {

    emptyUserData(){
        // After the user is logged out certain variables in store needs to be emptied
        // so they are not accessable for users that is not logged in

        this.$store.commit('setCurrentUser', {});
        this.$store.commit('setCurrentBeer', {});
        this.$store.commit('setLoggedIn', false);
        this.$store.commit('setMyGrades', []);
        this.$store.commit('setCurrentBeerGrades', [])

    },

},

mounted(){
    this.emptyUserData();

},





}
</script>

<style>

</style>