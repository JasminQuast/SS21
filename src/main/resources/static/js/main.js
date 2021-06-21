import note from './note.js';
import images from './images.js';

const app = Vue.createApp({})
app.component('note', note)
app.component('images', images)
app.mount('#app')