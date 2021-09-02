<template>
  <div>
      <h3>Om projektet</h3>

      <p>
        Detta projekt är skapat som en del i kursen "Objektorienterad programmering, Avancerad". 
        Där skulle vi under tre veckor skapa en egen applikation, där vi arbetade vidare på de 
        tekniker som vi lärt oss tidigare under utbildningen.
      </p>

      <p>
        BeerTaster är en digital ölbok där ölprovare, och andra öldrickare, kan få tips på öl inom olika kategorier och 
        från olika länder. De har också möjlighet att själv skriva omdömen och ge betyg för att kunna 
        gå tillbaka till senare.
      </p>

      <p>
        I den första versionen kan man endast se sina egna omdömen.
        Men jag hoppas ändå att den kan vara till glädje för någon.
      </p>


  </div>
</template>

<script>
export default {
    name: "About",

    data(){
        return{

        }
    },

    methods:{

    },
}
</script>

<style scoped>

div{
    width: 70vw;
    text-align: left;
    margin: 10vh auto;
}

</style>