const app = Vue.createApp({});
app.component('dynamic-pic', {
    template: `
        <p v-if="selectedImage"><img style="width:50%" :src="selectedImage" alt=""></p>
        <button type="button" @click="randomItem()">Change Picture</button>
    `,
    data() {
        return {
            images: [
                '/images/alaska.png',
                '/images/asia.png',
                '/images/birds.png',
                '/images/cave.png',
                '/images/city.png',
                '/images/forest.png',
                '/images/fox.png',
                '/images/mountain.png',
                '/images/river.png',
                '/images/saturn.png',
                '/images/skye.png',
                '/images/sunrise.png',
                '/images/tree.png',
                '/images/wulf.png'
            ],
            selectedImage: null
        };
    },
    methods: {
        randomItem() {
            console.log('random item');
            return this.images[Math.floor(Math.random()*this.images.length)];
        }
    },
    mounted: function() {
        this.selectedImage = this.randomItem();
        console.log('mounted');
        console.log(this.selectedImage);
    }
});
app.mount('#app');
