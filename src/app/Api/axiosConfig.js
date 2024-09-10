// axiosConfig.js
import axios from 'axios';

// Crear una instancia de Axios con la configuración deseada
const axiosInstance = axios.create({
  baseURL: 'http://localhost:8080/api',  // URL base para todas las peticiones
  timeout: 10000,  // Tiempo máximo de espera en milisegundos
  headers: {
    'Content-Type': 'application/json',  // Tipo de contenido por defecto
  },
});

export default axiosInstance;