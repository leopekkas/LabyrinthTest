# LabyrinthTest
Helsingin Yliopiston "Tietorakenteet ja Algoritmit -labratyö" kurssin projektikansio

[Määrittelydokumentti](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/maarittelydokumentti.md)  
[Testikattavuusraportti](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/testikattavuus.md)  
[Toteutusdokumentti](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/toteutusdokumentti.md)  
[Tehokkuus- ja generointitapojen vertailu](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/algoritmienvertailu.md)

## Asentaminen

Release [v0.5.0](https://github.com/leopekkas/LabyrinthTest/releases/tag/v0.5.0) on helpoin tapa ajaa ohjelma.
Ohjelman voi ajaa lataamalla ja suorittamalla tiedoston `Labyrinths.jar`.

Ohjelman voi myös rakentaa, ajaa ja testauttaa gradlen komennoilla:

    gradle build
    gradle run  
    gradle test


## Käyttöohje

Ohjelma kysyy Menuruudussa syötteen käyttäjältä (case insensitive):


              S : Run the sidewinder algorithm
              W : Run Wilson's algorithm
        SW | WS : Run both algorithms
              T : Run performance tests for both algorithms
             TL : Run limited performance tests
    <empty> | q : Quit the program


Valitun jälkeen ohjelma pyytää käyttäjältä generoitavan labyrintin kokoa (NxN) kokonaislukuna.
Tehokkuustesteissä labyrintin kokoa ei erikseen pyydetä.


## Koodin katselmointi ja vertaisarviointi

Projekti luo `gradle build` komennon yhteydessä olennaiset dokumentit seuraaville poluille: 

Javadoc:  
`LabyrinthTest/Labyrinths/build/docs/javadoc/index.html`  

Testikattavuusraportti:  
`LabyrinthTest/Labyrinths/build/reports/jacoco/test/html/index.html` 

Testien tulokset:  
`LabyrinthTest/Labyrinths/build/reports/tests/test/index.html`


## Viikkoraportit

[Viikkoraportti 1](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/viikkoraportti_1.md)  
[Viikkoraportti 2](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/viikkoraportti_2.md)  
[Viikkoraportti 3](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/viikkoraportti_3.md)  
[Viikkoraportti 4](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/viikkoraportti_4.md)  
[Viikkoraportti 5](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/viikkoraportti_5.md)
