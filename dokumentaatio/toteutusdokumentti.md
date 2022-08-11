# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelmakoodi jakautuu pakkauksiin:

### tiralabra 

Sisältää Main luokan, joka vastaa käyttöliittymän ominaisuuksista

### tiralabra.domain

Sisältää Labyrinth ja Cell -luokat, joista Cell vastaa labyrinttien yksittäisten ruutujen
sisältämistä tiedoista (koordinaatit, seinät) ja Labyrinth labyrinttien generoimisesta ja muokkaamisesta.

### tiralabra.util

Sisältää apuluokan CellDir, jota hyödynnetään Wilsonin algoritmissa.
