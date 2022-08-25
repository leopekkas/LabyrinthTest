# Testikattavuusraportti

Testikattavuusraportin voi luoda jacocon avulla ohjelman rakentamisen yhteydessä.
Raportti ilmestyy polulle: `LabyrinthTest/Labyrinths/build/reports/jacoco/test/html/index.html`

Testikattavus valittaa etenkin `printCell()` ja `printLabyrinth()` funktioista, jotka jätin 
tarkoituksella testaamatta. Funktiot vastaavat käyttöliittymästä.

Main-luokkaa ei ole testattu, mikä on suurin testikattavuudesta valittava osa-alue. Jätin Main 
luokan testaamatta, sillä se vastaa käyttöliittymästä

Sidewinderin ja Wilsonin algoritmin testaus perustuu siihen, että luodun labyrintin jokaisessa ruudussa on mahdollista
käydä

## Koko ohjelma-alueen testikattavuus
![Ohjelma-alueen testikattavuus](img/labyrinths_kattavuus.png)


## Labyrinths.domain

### Labyrinths.domain.Labyrinth
![Labyrinth-luokan testikattavuus](img/Labyrinth_luokka_kattavuus.png)

### Labyrinths.domain.Cell
![Cell-luokan testikattavuus](img/Cell_luokka_kattavuus.png)


## Labyrinths.util

### Labyrinths.util.Cell
![CellDir-luokan testikattavuus](img/CellDir_luokka_kattavuus.png)

### Labyrinths.domain.List
![List-luokan testikattavuus](img/List_luokka_kattavuus.png)

