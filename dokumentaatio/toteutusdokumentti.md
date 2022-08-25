# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelmakoodi jakautuu pakkauksiin:

### tiralabra 

Sisältää Main luokan, joka vastaa käyttöliittymän ominaisuuksista

### tiralabra.domain

Sisältää Labyrinth ja Cell -luokat, joista Cell vastaa labyrinttien yksittäisten ruutujen
sisältämistä tiedoista (koordinaatit, seinät) ja Labyrinth labyrinttien generoimisesta ja muokkaamisesta

### tiralabra.util

Sisältää apuluokan CellDir, jota hyödynnetään Wilsonin algoritmissa, sekä List -tietorakenteen, 
joka korvaa ArrayListin käytön

### tiralabra.testing

Sisältää testausluokan Tester, joka avustaa tehokkuustestien kirjaamisessa

Käytännössä käyttöliittymän jatkofunktio, joka myös vastaa käyttöliittymän tietojen
kirjoittamisesta

### Algoritmien suoritusvertailu

Algoritmien tehokkuus- ja generointivertailun löydät [erillisestä dokumentista](https://github.com/leopekkas/LabyrinthTest/blob/main/dokumentaatio/algoritmienvertailu.md)
