import { createRouter, createWebHistory } from 'vue-router'

import Home from '/src/components/Home.vue'


// Routes to components
const routes = [
    {
        path: '/',
        name: 'home',
        component: Home
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router