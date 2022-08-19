# Toteutusdokumentti

## Ohjelman yleisrakenne

Ohjelmakoodi jakautuu pakkauksiin:

### tiralabra 

Sisältää Main luokan, joka vastaa käyttöliittymän ominaisuuksista

### tiralabra.domain

Sisältää Labyrinth ja Cell -luokat, joista Cell vastaa labyrinttien yksittäisten ruutujen
sisältämistä tiedoista (koordinaatit, seinät) ja Labyrinth labyrinttien generoimisesta ja muokkaamisesta.

### tiralabra.util

Sisältää apuluokan CellDir, jota hyödynnetään Wilsonin algoritmissa, sekä List -tietorakenteen, joka korvaa ArrayListin käytön.

### tiralabra.testing

Sisältää testausluokan Tester, joka avustaa tehokkuustestien kirjaamisessa. 
Käytännössä käyttöliittymän jatkofunktio, joka myös vastaa käyttöliittymän tietojen
kirjoittamisesta.

## Tehokkuustestit

Ohjelman käyttöliittymä mahdollistaa tehokkuustestien suorittamisen ohjelman suorituksen aikana.
Tehokkuustestauksesta vastaava luokka luo normaalitapauksessa 15 erisuuruista labyrinttia,
testaa algoritmien suorituksen jokaisella 5 kertaa ja laskee keskiarvon suoritusajoista 
jokaiselle erisuuruiselle labyrintille

Tester-luokka luo labyrinttien seinien pituudet (NxN) kaavalla 
$$2(i + 1)^2 \text{ , jossa  } 1 \le i \le N$$ ja $$10 \le N \le 20$$ riippuen testitapauksen laajuudesta 


    Sidewinder on teoreettiselta aikavaativuudeltaan O(n²)
    Wilsonin algoritmi on teoreettiselta aikavaativuudeltaan O(n^n)


## Labyrinttien vertailu

### Samankaltaisuudet labyrinteissa

Wilsonin ja Sidewinderin luomat labyrintit luovat labyrintteja, joissa jokaiseen ruutuun labyrintin sisällä pystyy kulkemaan, eikä "suljettuja alueita" synny labyrintin alueen sisälle.

### Erot labyrinteissa

#### Sidewinder

Sidewinderin ensimmäinen rivi on aina suora käytävä, sillä algoritmi liikkuu rivi kerrallaan käyden jokaisen ruudun läpi ja liikkuu aina "oikealle tai ylöspäin", joista jälkimmäiseen liikkuminen ensimmäisellä rivillä on mahdotonta.

Sidewinderin luoma labyrintti luo polkuja vain ylöspäin, joten se ei pysty luomaan ylöspäin suuntaavaa umpikujaa, eli esim. alla olevan esimerkin tyyppistä polkua:

       _
      | |
    _ | |
    _ _ |
    
    
Tästä syystä luodun labyrintin ratkaisu on erityisen helppoa kuljettaessa labyrinttia "väärinpäin", eli uloskäynnistä lähtöruutuun, jos kuljetaan aina ylöspäin kun mahdollista. 

#### Wilson's Algorithm

Wilsonin algoritmin luoma labyrintti on monimutkaisempi ja perustuu satunnaisista ruuduista johdettuihin polkuihin. 
Wilsonin algoritmi on suoritustehokkuudeltaan hyvin paljon hitaampi, mutta voi luoda hyvinkin monimutkaisia labyrinttirakenteita. 
