import note from './note.js';

const app = Vue.createApp({})
app.component('note', note)
app.mount('#app')