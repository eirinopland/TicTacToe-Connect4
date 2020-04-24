# [Semesteroppgave 2: Fire på rad og Tripp-trapp-tresko]


* **README**
* [Oppgavetekst](SEM-2.md)
* [Tips for å komme i gang](Tips.md)
* [Advanced](Advanced.md)

**Innleveringsfrist:** Hele oppgaven skal være ferdig og levert via din private gitlab-repositorie til **Fredag 24. april kl. 2359** ([AoE](https://www.timeanddate.com/worldclock/fixedtime.html?msg=4&iso=20180427T2359&p1=3399)).  

### Innlevering 
 Du finner koden din i repositoriet med URIen:

    https://retting.ii.uib.no/<brukernavn>/inf101.v20.sem2.git

Oppgaven leveres inn ved å pushe til retting.ii.uib.no, [slik du har gjort med alle tidligere INF101-oppgaver](https://retting.ii.uib.no/inf101/inf101.v20/wikis/hente-levere-oppgaver). Husk å få med eventuelle nye filer du har opprettet.

**VIKTIG:** *Sjekk kvitteringssiden som kommer opp når du pusher, i tilfelle det skjer feil!* 

Vi anbefaler at du gjør commit hver dag, eller hver gang du er ferdig med en
deloppgave, i tilfelle du mister det du jobber med på din egen maskin. Du kan levere inn så mye og ofte du vil. Versjonen som teller er den **siste du pushet før innleveringsfristen**.

Denne oppgaven teller på din endelige vurdering i faget. Maks poeng er 100. Du kan få opp til 120 totalt, inkludert ekstrapoeng. 

# Fyll inn egne svar/beskrivelse/kommentarer til prosjektet under
* Levert av:   *NAVN* (*BRUKERNAVN*)
* [ ] hele semesteroppgaven er ferdig og klar til retting!
* Code review:
   * [ ] jeg har fått tilbakemelding underveis fra @brukernavn, ...
   * [ ] jeg har gitt tilbakemelding underveis til @brukernavn, ...
* Sjekkliste:
   * [X] Kjørbart Fire på Rad-spill
	   * [X] Funksjonelt spill 
	   * [X] Fungerende user interface
	   * [X] Støtter AI 
   * [X] Kjørbart Tripp-trapp-tresko-spill
	   * [X] Funksjonelt spill 
	   * [X] Fungerende user interface
	   * [X] Støtter AI 
   * [ ] Forklart designvalg, hvordan koden er organisert, abstraksjon, og andre ting 
   * [ ] Tester
   * [ ] Dokumentasjon (JavaDoc, kommentarer, diagrammer, README, etc.)
   * [ ] Fornuftige navn på klasser, interfaces, metoder og variabler
   * [ ] Fornuftige abstraksjoner og innkapsling (bruk av klasser, interface, metoder, etc.)

## Oversikt
I denne oppgaven har jeg valgt å benytte meg av grid-klassen som ble gitt fra lab4. I tillegg til denne har jeg laget disse pakkene med følgende klasser: 

Board
 - Board.java
 	- Arver fra Grid<T> og har funksjonalitet som å droppe markør, sjekke om en posisjon allerede er tatt, sjekke vinner, sjekke uavgjort, og initialisere et nytt tomt brett. 
 - Connect4Board.java
 	- Arver fra klassen Board, i tillegg til implementasjon av metode som printer spesifikt brett for dette spillett. 
 - TicTacToeBoard.java
 	- extender Board().
 
Games
 - Connect4Game.java
 - IGame
 - TicTacToeGame.java
 	- Game-klassene skal i utgangspunktet ha oversikten over hva som skjer i spillet, og sørger for at ting skjer i henhold til hvordan spillet skal oppføre seg. Her er det metoden doTurns() som tar inn metoder fra andre klasser, og kjører spillet helt til noen har vunnet eller det er uavgjort. Denne metoden sørger for at spillerne utfører hver sin tur, tar inn input for hvor man ønsker å legge brikker, sjekker om man har vunnet eller om det er uavgjort. Sørger også for at det er lov å legge brikker der. 

Main
 - GameMain.java
	- Det er her spillet kjøres fra. 

Markers
 - GameMarkers.java
 	- Enum som inneholder alle de ulike markørene man kan ha i spillene. Hver spiller har sin egen GameMarker, enten CROSS, CIRCLE, YELLOW eller RED. Har også laget en markør SPACE som alle celler i brettet inneholder fra start av. 
 - Markers.java

Players
 - HumanPlayer.java
 - AIPlayer.java
 	- Her har jeg bare implementert en "dum" AIPlayer, som bare velger et random tall som er mindre enn max. Max bestemmes i spillets duTurns(), og vil da være høyden og/eller bredden på brettet. 
 - Iplayer.java 
 	- Felles interface for HumanPlayer og AIPlayer. Inneholder metodene getMarker(), getName(), pickColumn() og pickRow(), som henholdsvis skal returnere markøren til spilleren, navnet til spilleren, og hvilken rad/kolonne spilleren ønsker å sette brukken sin. 
 
I tillegg til testklassen for grid som allerede var implementert, har jeg laget en testklasse for tictactoe, og en testklasse for connect4.

Rules
 - Rules.java
 	- Klasse for regler som passer begge spill. Sjekker om en spiller har vunnet, eller om det er uavgjort. Metoden for å sjekke vinner sjekker alle retningen fra den sist plasserte brikken, altså både horisontalt, vertikalt og diagonalt.  

Funksjonalitet: 


*(oversikt over koden din og det du har gjort)*


### Bruk
For å starte programmet kjør: GameMain(). Når du kjører denne vil du få spørsmål om hvilket spill du ønsker og spille, og hvorvidt du ønsker å spille mot en AI eller en annen menneskelig spiller. 

Når spillet kjører, vil du få spørsmål i terminalen om hvor du ønsker å legge brikken din. I connect4(fire på rad) skal du velge en kolonne mellom 1-7, mens i tictactoe(tripp trapp tresko) får du spørsmål om både kolonne og rad mellom 1-3. Dersom du i terminalen skriver et tall som vil være utenfor brettet eller som allerede er tatt, vil du få en melding om dette, og i tillegg spørsmål om å skrive inn på nytt. 

Når du vinner vil det komme opp en melding om at "spiller x" har vunnet, og deretter vil du få spørsmål om du ønsker å spille på nytt eller avbryte. Det samme skjer dersom det blir uavgjort. 
   

## Designvalg
Jeg har valgt å løse denne oppgaven ved hjelp av tekst-basert grensesnitt. For å gjøre et tekst-basert design litt mer spennende, har jeg valgt å bruke unicode til emojis for markørene. Dette gjør at det ser litt mer ekte ut. 


### Bruk av abstraksjon
- Connect4Board og TicTacToeBoard inneholder.
- IPlayer er selve spilleren, og her velges det hvor man ønsker å legge neste brikke. 
- Game-klassene til tictactoe og connect4 er klassene som styrer spillets gang. Ut i fra hva du har valgt i main, legger disse klassene til spillere til spillet. De holder orden på spillernes tur, og kjører spillet helt til noen har vunnet eller det er uavgjort. 

*(hvordan du har valgt objekter/klasser for å representere ting i spillet)*

### Erfaring – hvilke valg viste seg å være gode / dårlige?
I begynnelsen valgte jeg å ha et interface "IBoard", men oppdaget etterhvert at board-metodene til begge spillene var svært like. Jeg valgte derfor å heller lage en klasse Board som implementerer alle metoder som er like for begge spill og som arver egneskapene til Grid., og deretter lage klassene Connect4Board og TicTacToeBoard som da arver alle egenskapene til Board, i tillegg til egne spesialiserte egenskaper som passer til hvert spill. På denne måten ble det mindre kode, og mindre overflødig kode. 

*(designerfaringer – er det noe du ville gjort annerledes?)*

## Testing
Underveis i utviklingen av programmet har jeg testet mye manuelt ved å kjøre spillet.

I etterkant har jeg laget tester til mange av metodene, da særlig fra klassene til Board og Games, da jeg mener disse inneholder de viktigste metodene. I testene har jeg brukt asserts, slik at jeg sjekker at output samsvarer med input. 

*(hvordan du har testet ting)*

## Funksjonalitet, bugs
Spillet fungerer bra. Det eneste jeg kjenner til er at du ikke får noen feilmelding dersom du skriver feil input i GameMain() eller når du får spørsmål om å starte spillet på nytt. 
*(hva virker / virker ikke)*

## Evt. erfaring fra code review
*(lærte du noe av å gå gjennom din eller andres kode?)*

## Annet
Jeg er litt usikker på om jeg kanskje ville laget en ekstra klasse for spillregler. Her ville jeg eventuelt satt metodene for å sjekke vinner, og for å sjekke uavgjort som nå ligger i klassen Board. 

Noe som kunne spart meg litt tid er å skrive mer kommentarer til metodene underveis.

I begynnelsen var planen å lage en tekstbasert versjon først, og deretter lage en gui-versjon. Dette ble det dessverre ikke tid til. Jeg ønsket også å gjøre designet litt bedre ved å bruke unicode for box-drawing til å printe et "finere" brett, men dette ble det heller ikke tid til. 
*(er det noe du ville gjort annerledes?)*
