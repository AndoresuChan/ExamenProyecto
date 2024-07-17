<template>
  <div class="vuelos">
    <div class="vuelos-details">
      <h2> Nombre: {{ nombre }} </h2>
      <p class="precio">$ {{ precio }}</p>
      <p>{{ origen }} - {{ destino }}</p>
      <p>{{ fecha }} </p>
      <p>{{ hora }} hrs</p>
      <p>{{ capacidad }} Asientos disponibles</p>
    </div>
  </div>
</template>

<script>
export default {
name: 'Vuelos',
props: {
  id: {
    type: Number,
    required: true
  },
  nombre: {
    type: String,
    required: true
  },
  origen: {
    type: String,
    required: true
  },
  destino: {
    type: String,
    required: true
  },
  fecha: {
    type: String,
    required: true
  },
  hora: {
    type: String,
    required: true
  },
  capacidad: {
    type: String,
    required: true
  },
  precio: {
    type: String,
    required: true
  },
},
methods: {
}
};
</script>

<style scoped>
.vuelos {
display: flex;
align-items: center;
border: 1px solid #ccc;
margin-bottom: 10px;
background-color: #7887D3;
padding: 10px;
border-radius: 10px;
overflow: hidden;
}

.vuelos-details {
flex-grow: 1;
display: flex;
flex-direction: column;
}

.vuelos-details h2 {
margin: 0.5;
font-size: 1.2rem;
background-color: #474D8C;
color: white;
padding: 6px;
border-radius: 5px;
}

.precio {
font-size: 1.1rem;
font-weight: bold;
color: white;
background-color: #474D8C;
padding: 5px;
border-radius: 5px;
align-self: flex-start;
}

.detail-button {
background-color: #4CAF50;
color: white;
border: none;
padding: 5px;
cursor: pointer;
border-radius: 5px;
width: 10%;
transition: all 0.5s ease;
}

.detail-button:hover {
background-color: #45a049;
transform: scale(1.01);
}
</style>