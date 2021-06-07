new Vue({
    el: "dynamic-pic",
    data: {
        images: [
            'alaska.png',
            'asia.png',
            'birds.png',
            'cave.png',
            'city.png',
            'forest.png',
            'fox.png',
            'mountain.png',
            'river.png',
            'saturn.png',
            'skye.png',
            'sunrise.png',
            'tree.png',
            'wulf.png'
            // 'https://picsum.photos/600/200',
            // 'https://picsum.photos/600/200',
            // 'https://picsum.photos/600/200'
        ],
        selectedImage: null
    },
    methods: {
        randomItem (items) {
            return items[Math.floor(Math.random()*items.length)];
        }
    },
    created() {
        this.selectedImage = this.randomItem(this.images)
    }

})


/*
const app = Vue.createApp({})

app.component('dynamic-pic', {
   template:`
    <div class="container ms-5 mt-5 mb-5">

    <div v-each="note: ${note}" class="row">
        <div class="col-sm-2">
            <div class="card">
                <div class="card-body">
                    <p class="card-title fw-light" v-text="${note.date}"></p>
                    <svg xmlns="http://www.w3.org/2000/svg" width="20" height="20" fill="lightgrey" class="bi bi-emoji-heart-eyes mx-2" viewBox="0 0 16 16">
                        <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z"/>
                        <path d="M11.315 10.014a.5.5 0 0 1 .548.736A4.498 4.498 0 0 1 7.965 13a4.498 4.498 0 0 1-3.898-2.25.5.5 0 0 1 .548-.736h.005l.017.005.067.015.252.055c.215.046.515.108.857.169.693.124 1.522.242 2.152.242.63 0 1.46-.118 2.152-.242a26.58 26.58 0 0 0 1.109-.224l.067-.015.017-.004.005-.002zM4.756 4.566c.763-1.424 4.02-.12.952 3.434-4.496-1.596-2.35-4.298-.952-3.434zm6.488 0c1.398-.864 3.544 1.838-.952 3.434-3.067-3.554.19-4.858.952-3.434z"/>
                    </svg>
                </div>
            </div>
        </div>

        <div class="col-sm-9">
            <div class="card">

                    <script language="JavaScript" type="text/javascript">
                        var image = new Array();

                        image[1] = 'alaska.png';
                        image[2] = 'asia.png';
                        image[3] = 'birds.png';
                        image[4] = 'cave.png';
                        image[5] = 'city.png';
                        image[6] = 'forest.png';
                        image[7] = 'fox.png';
                        image[8] = 'mountain.png';
                        image[9] = 'river.png';
                        image[10] = 'saturn.png';
                        image[11] = 'skye.png';
                        image[12] = 'sunrise.png';
                        image[13] = 'tree.png';
                        image[14] = 'wulf.png';

                        var num = Math.random();
                        var ran = Math.floor((image.length - 1) * num) + 1;

                        document.write('<a href="' + link[ran] + '"><img src="' + image[ran] + '" border="0" /></a>');
                    </script>

                <img v-bind:src="'/images/city.png'" class="card-img-top" alt="...">-->
                <div class="card-body">
                    <h5 class="card-title mt-3" v-text="${note.headline}"></h5>
                    <p class="card-text mt-3" v-text="${note.text}"></p>
                    <a v-ref="@{/editNote(id=${note.id})}" class="btn btn-outline-secondary mt-4">edit</a>
                    <!--          <button type="button" class="btn btn-outline-secondary mt-4">edit</button>-->
                    <!--          <button type="button" class="btn btn-outline-danger ms-2 mt-4">delete</button>-->
                </div>
            </div>
        </div>
        <div class="container ms-5 mt-5 mb-5"></div>
    </div>
</div>
</div>
`,
 methods: {
        getNote() {
           axios.get('/editNote')
               .then(response => (this.notes = response.data))
        }
    },

mounted: function() {
       this.getNote();
}

});*/
