<template>
    <div class="reserva-list-container">
      <button @click="showAddReservaModal = true" class="add-reserva-button">Agregar Reserva</button>
      
      <div v-if="showAddReservaModal" class="modal">
        <div class="modal-content">
          <span class="close" @click="showAddReservaModal = false">&times;</span>
          <h2>Agregar Reserva</h2>
          <form @submit.prevent="submitReserva">
            <div class="form-group">
              <label for="nombre">Nombre:</label>
              <input type="text" id="nombre" v-model="newReserva.nombre" required>
            </div>
            <div class="form-group">
              <label for="precio">Precio:</label>
              <input type="number" id="precio" v-model="newReserva.precio" required>
            </div>
            <div class="form-group">
              <label for="origen">Origen:</label>
              <input type="text" id="origen" v-model="newReserva.origen" required>
            </div>
            <div class="form-group">
              <label for="destino">Destino:</label>
              <input type="text" id="destino" v-model="newReserva.destino" required>
            </div>
            <div class="form-group">
              <label for="fecha">Fecha:</label>
              <input type="date" id="fecha" v-model="newReserva.fecha" required>
            </div>
            <button type="submit">Agregar</button>
          </form>
        </div>
      </div>
  
      <div class="reserva-list">
        <ReservaItem
          v-for="reserva in reservas"
          :key="reserva.id"
          :id="reserva.id"
          :nombre="reserva.nombre"
          :precio="reserva.precio"
          :origen="reserva.origen"
          :destino="reserva.destino"
          :fecha="reserva.fecha"
        />
      </div>
    </div>
  </template>
  
  <script>
  import ReservaItem from '@/components/Vuelos.vue';
  import api from '@/services/api'; 
  
  export default {
    name: 'ReservaList',
    components: {
      ReservaItem
    },
    data() {
      return {
        reservas: [],
        showAddReservaModal: false,
        newReserva: {
          nombre: '',
          precio: '',
          origen: '',
          destino: '',
          fecha: ''
        }
      };
    },
    created() {
      this.fetchReservas();
    },
    methods: {
      async fetchReservas() {
        try {
          const response = await api.get('/reservas');
          this.reservas = response.data;
        } catch (error) {
          console.error('Error fetching reservas:', error);
        }
      },
      async submitReserva() {
        try {
          const response = await api.post('/reservas', this.newReserva);
          this.reservas.push(response.data);
          this.showAddReservaModal = false;
          this.newReserva = {
            nombre: '',
            precio: '',
            origen: '',
            destino: '',
            fecha: ''
          };
        } catch (error) {
          console.error('Error adding reserva:', error);
        }
      }
    }
  };
  </script>
  
  <style scoped>
  .reserva-list-container {
    display: flex;
    flex-direction: column;
    align-items: center;
    padding: 20px;
    margin-top: 50px; 
  }
  
  .add-reserva-button {
    background-color: #4CAF50; 
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    margin-bottom: 20px;
    cursor: pointer;
    border: none;
    border-radius: 4px;
  }
  
  .reserva-list {
    max-width: 1200px;
    margin: 0 auto;
    padding-top: 1.5rem;
  }
  
  .modal {
    display: flex;
    justify-content: center;
    align-items: center;
    position: fixed;
    z-index: 1;
    left: 0;
    top: 0;
    width: 100%;
    height: 100%;
    overflow: auto;
    background-color: rgb(0, 0, 0);
    background-color: rgba(0, 0, 0, 0.4);
  }
  
  .modal-content {
    background-color: #fefefe;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
    max-width: 500px;
    border-radius: 10px;
  }
  
  .close {
    color: #aaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
  }
  
  .close:hover,
  .close:focus {
    color: black;
    text-decoration: none;
    cursor: pointer;
  }
  
  .form-group {
    margin-bottom: 15px;
  }
  
  .form-group label {
    display: block;
    margin-bottom: 5px;
  }
  
  .form-group input,
  .form-group textarea {
    width: 100%;
    padding: 8px;
    box-sizing: border-box;
  }
  
  .form-group textarea {
    resize: vertical;
    height: 100px;
  }
  </style>