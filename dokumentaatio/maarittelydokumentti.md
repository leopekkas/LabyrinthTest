# Määrittelydokumentti

Projektini aiheena on kahden labyrintingenerointi-algoritmin vertaaminen keskenään.
Vertaan sidewinder- ja Wilsonin algoritmeja keskenään, kiinnittäen huomiota skaalautuvuuteen ja generointimetodeihin.

Opinto-ohjelma: Tietojenkäsittelytieteen kandidaatti

Dokumentaation kieli: Suomi

Ohjelmointikieli: Java

Voin vertaisarvioida myös Python/Fortran/C/C++:lla kirjoitettuja projekteja

### Toteutettavat algoritmit ja tietorakenteet

Sidewinder (algoritmi)  
Wilsonin algoritmi  
Lista (Javan ArrayListin vastine)  


### Syötteet: 

Ohjelma kysyy Menuruudussa syötteen käyttäjältä (case insensitive):


              S : Run the sidewinder algorithm
              W : Run Wilson's algorithm
         SW | WS: Run both algorithms
              T : Run performance tests for both algorithms
             TL : Run limited performance tests    
    <empty> | q : Quit the program


Valitun jälkeen ohjelma pyytää käyttäjältä generoitavan labyrintin kokoa (NxN) kokonaislukuna. 
Tehokkuustesteissä labyrintin kokoa ei erikseen pyydetä.


### Aika- ja tilavaativuus

Aika- ja tilavaativuudet käydään tarkemmin läpi toteutusdokumentaatiossa ja algoritmien tehokkuustestauksessa  

Sidewinder algoritmi on aikavaativuudeltaan $O(n^2)$
Wilsonin algoritmin aikavaativuus $O(n^n)$

### Lähteet:

[Maze Generation Algorithm (Wikipedia)](https://en.wikipedia.org/wiki/Maze_generation_algorithm)  
[Wilsonin algoritmi](https://weblog.jamisbuck.org/2011/1/20/maze-generation-wilson-s-algorithm)  
[Sidewinder](https://weblog.jamisbuck.org/2011/2/3/maze-generation-sidewinder-algorithm.html)  

