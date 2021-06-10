export default {
    data() {
        let LocalDate;
        return {
            date: LocalDate,
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
            selectedImage: null,
            headline: '',
            text: '',
            emotion: [
                1,
                2,
                3,
                4,
                5
            ],
            note: []
        }
    },
    template:`
     <div>
     <p v-if="selectedImage"><img style="width:50%" :src="selectedImage" alt=""></p>
        <button type="button" @click="randomItem()">Change Picture</button>
     
     <input v-model="Headline" placeholder="Gib dem Tag einen Namen...">
     <input v-model="Text" placeholder="Beginne mit deinem Text..." @keyup.enter="save()">   
     <button type="button" @click="save()">Save</button>
     </div>
`,
    methods: {
        randomItem() {
            console.log('random item');
            return this.images[Math.floor(Math.random() * this.images.length)];
        },


        loadNote() {
            axios.get('/todaysNote')
                .then(response => (this.note = response.data))
        },
        save() {
            axios.post('/todaysNote', {
                date: this.date,
                images: this.randomItem(),
                selectedImage: this.selectedImage,
                headline: this.headline,
                text: this.text,
                emotion: this.emotion
            })
                .then((response) => {
                    this.loadNote();
                }, (error) => {
                    console.log('Der Eintrag konnte nicht gespeichert werden.');
                });
        }
    },

mounted: function() {
    this.loadNote();
}
}

