<div align="center">
    <script language="JavaScript" type="text/javascript">

        var image = new Array();

        /** Hier die (Zufalls)-Bilder eintragen. **/

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

        /** Ab hier nichts mehr ändern! **/

        var num = Math.random();
        var ran = Math.floor((image.length - 1) * num) + 1;

        document.write('<a href="' + link[ran] + '"><img src="' + image[ran] + '" border="0" /></a>');

    </script>
</div>