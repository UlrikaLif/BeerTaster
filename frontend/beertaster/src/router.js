import { createRouter, createWebHistory } from 'vue-router'

import Main from './components/Main.vue'


// Routes to components
const routes = [
    {
        path: '/',
        name: 'home',
        component: Main
    },
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router