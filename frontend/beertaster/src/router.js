import { createRouter, createWebHistory } from 'vue-router'

import Home from '/src/components/Home.vue'
import CreateGrade from '/src/components/create-grade.vue'
import ViewGrade from '/src/components/view-grades.vue'


// Routes to components
const routes = [
    {
        path: '/',
        name: 'home',
        component: Home
    },
    {
        path: '/create-grade',
        name: 'create-grade',
        component: CreateGrade
    },
    {
        path: '/view-grade',
        name: 'view-grade',
        component: ViewGrade
    },

]

const router = createRouter({
    history: createWebHistory(),
    routes
})

export default router