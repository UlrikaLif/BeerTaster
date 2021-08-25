import { createStore } from 'vuex'

const state = {
    allBeers: [],
}


const mutations = {
    setAllBeers(state,beerList){
        state.allBeers = beerList;
        console.log (beerList);
    },
    

}

const actions = {
    async getAllBeersFromDB(store) {
        let beerList = await fetch("/api/beersorts")
        try {
            beerList = await beerList.json()
            console.log('response data?', beerList)
        } catch(error) {
            console.log('Error happened here!')
            console.error(error)
        }
        console.log("action", beerList)
        store.commit ('setAllBeers', beerList)
    },

}


export default createStore({state, mutations, actions})