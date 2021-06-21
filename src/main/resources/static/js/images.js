export default {
    template: `
<div class="card">
  <div class="card-body">
    <h3 class="card-title">Hier geht es nur um DICH <br />
      </h3>
    <p class="card-text">Diaryt ermöglicht es dir, jeden Tag virtuell festzuhalten.<br />
    Gib deinem Tag einen Namen, schreib auf was dich bewegt und bewerte deine Gefühlslage mit einem passenden Emoji. </p>
    <p class="card-text"><small class="text-muted">Los geht's!</small></p>
  </div>
    <p v-if="selectedImage"><img style="width:100%" :src="selectedImage" alt=""></p>
</div>

        
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
        randomItem () {
            console.log('random item');
            return this.images[Math.floor(Math.random()*this.images.length)];
        }
    },
    mounted: function() {
        this.selectedImage = this.randomItem();
        console.log('mounted');
        console.log(this.selectedImage);
    }
}