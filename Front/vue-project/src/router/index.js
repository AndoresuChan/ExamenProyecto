import { createRouter, createWebHistory } from 'vue-router';

import VuelosList from '../components/views/VuelosList.vue';
import VuelosListAdmin from '../components/views/VuelosListAdmin.vue';

const routes = [
    {
        path: '/',
        Name: 'VuelosList',
        component: VuelosList
    },
    {
        path: '/admin',
        Name: 'VuelosListAdmin',
        component: VuelosListAdmin
    }
];

export const router = createRouter({
    history: createWebHistory(),
    routes
  });
    
  export default router;