<template>
  <div>
    <div class="vuelos-list">
      <Vuelos
        v-for="vuelo in vuelos"
        :key="vuelo.id"
        :id="vuelo.id"
        :nombre="vuelo.nombre"
        :origen="vuelo.origen"
        :destino="vuelo.destino"
        :fecha="vuelo.fecha"
        :hora="vuelo.hora"
        :capacidad="vuelo.capacidad"
        :precio="vuelo.price"
      />
    </div>
  </div>
</template>

<script>
import Vuelos from '@/components/Vuelos.vue';
import api from '@/services/api';

export default {
  name: 'VuelosList',
  components: {
    Vuelos
  },
  data() {
    return {
      vuelos: []
    };
  },
  created() {
    this.fetchVuelos();
  },
  methods: {
    async fetchVuelos(){
      try {
        const response = await api.get('/reservas');
        this.vuelos = response.data;
      } catch (error) {
        console.error('Error fetching vuelos', error);
      }
    }
  }
}
</script>

<style scoped>
.btn-list-users {
  background-color: #4CAF50;
  color: white;
  padding: 25px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin-bottom: 20px;
  cursor: pointer;
  border: none;
  border-radius: 4px;
}
.vuelos-list {
  max-width: 1200px;
  margin: 1rem auto 0; 
  padding-top: 1.5rem;
}
</style>