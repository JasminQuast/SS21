import Note from './note.js';
import Images from './images.js';

const app = Vue.createApp({})
app.component('note', Note)
app.component('images', Images)
app.mount('#app')