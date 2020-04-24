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
* Levert av:   Eirin Opland (eop004)
* [X] hele semesteroppgaven er ferdig og klar til retting!
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
   * [X] Forklart designvalg, hvordan koden er organisert, abstraksjon, og andre ting 
   * [X] Tester
   * [X] Dokumentasjon (JavaDoc, kommentarer, diagrammer, README, etc.)
   * [X] Fornuftige navn på klasser, interfaces, metoder og variabler
   * [X] Fornuftige abstraksjoner og innkapsling (bruk av klasser, interface, metoder, etc.)

## Oversikt
Dette programmet representerer to spill, tic tac toe og connect 4. 

I denne oppgaven har jeg valgt å benytte meg av Grid-klassen og IGrid-klassen som ble gitt fra lab 4, i tillegg til tilhørende tester. Ellers er programmet laget fra bunnen av. 

Programmet består av flere deler (pakker):
 - Board - inneholder logikken og det fysiske bak hvert spill, arver fra griden
 - Games - inneholder oversikten over hva som skjer i spillet, og sørger for at ting skjer i henhold til hvordan spillet skal oppføre seg
 - Grid - gir datastrukturen til spillene 
 - Main - her startes programmet 
 - Markers - klasser for markører som benyttes i spillet, hver spiller har sin egen markør
 - Players - skiller menneskelig spiller fra AIspiller, og inneholder informasjon om disse spillerne
 - Tester - tester for hvert spill for å teste de viktigste metodene og finne eventuelle bugs


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

Når du vinner vil det komme opp en melding om at "Vinneren er: ...", og deretter vil du få spørsmål om du ønsker å spille på nytt eller avbryte. Det samme skjer dersom det blir uavgjort. 
   

## Designvalg
 - Datatrukturen kommer fra tidligere lab, og er brukt som en base for programmet, og til å representere spillbrettet. 
 - Jeg har valgt å løse denne oppgaven ved hjelp av tekst-basert grensesnitt. For å gjøre et tekst-basert design litt mer spennende, har jeg valgt å bruke unicode til emojis for markørene. Dette gjør at det ser litt mer ekte ut. 
 - For hvert spill har hver spiller en bestemt markør og et bestemt spillernavn. Her kunne jeg eventuelt latt spillerne selv bestemme hvilket navn og hvilken markør de ønsker, men dette ønsket jeg ikke å legge noe særlig vekt på. 


### Bruk av abstraksjon
Programmet er separert i klasser som representerer forskjellige deler av spillene. 
 - Board er selve brettet og inneholder fysikken og logikken bak spillene, mens Connect4Board og TicTacToeBoard inneholder det som er særegent for hvert spillbrett. 
 - IPlayer representerer selve spilleren, og kan være en HumanPlayer eller en AIPlayer. Her bestemmes markør og navn til spilleren, i tillegg til informasjon om hvor man ønsker å legge brikken sin. 
 - Game-klassene styrer spillets gang. De holder orden på spillernes tur, og kjører spillet helt til noen har vunnet eller det er uavgjort. 

Bruken av abstraksjon har blant annet vært veldig nyttig for å endre enkelte klasser uten å måtte endre hele programmet

### Erfaring – hvilke valg viste seg å være gode / dårlige?
I begynnelsen valgte jeg å ha et interface "IBoard", men oppdget etterhvert at board-metodene til begge spillene var svært like. Jeg valgte derfor å lage en klasse "Board" i stedet som implementerer alle metodene som er like for begge spill og som arver egenskapene til Grid. Connect4Board og TicTacToeBoard arver igjen egenskapene til Board-klassen, i tillegg til å implementere metoder som er spesifikke for hvert enkelt spill. På denne måten ble det bedre oversikt, og mindre overflødig kode. Dette er et godt eksempel på gjenbruk av kode. 


## Testing
Utviklingen av programmet ble i begynnelsen hovedsakelig gjort ved å prøve og feile. Her kjørte jeg spillet fra main, og prøvde ulike deler av spillet for å se hvor det lå feil. 

I etterkant har jeg laget og utført tester ved hjelp av JUnit. Her blir de viktigste metodene i programmet testet for hvert spill. Disse testene sjekker at output samsvarer med input. Det var i løpet av denne testingen jeg oppdaget feil som kunne vært vanskelig å oppdage kun ved å kjøre programmet, så denne testingen har vært veldig nyttig. Jeg oppdaget blant annet at jeg hadde byttet om på horizontalWin og verticalWin, noe som ikke ble oppdaget da koden bare skulle sjekke vinner (altså enten horisontal, vertikal eller diagonal). 

Jeg har blant annet testet at brikkene havner der de skal når de slippes, at det er en vinner dersom det er 3/4 brikker på rad, om et trekk er gyldig, og om brettet fungerer slik det skal. 

## Funksjonalitet, bugs
Spillet fungerer bra. Det eneste jeg kjenner til er at du ikke får noen feilmelding dersom du skriver feil input i GameMain() eller når du får spørsmål om å starte spillet på nytt. 

## Evt. erfaring fra code review
Denne oppgaven har jeg stort sett løst alene, kun med litt hjelp til å finne ut av eventuelle feil. 

## Annet
Jeg er litt usikker på om jeg kanskje ville laget en ekstra klasse for spillregler. Her ville jeg eventuelt satt metodene for å sjekke vinner, og for å sjekke uavgjort som nå ligger i klassen Board. Fordelen med å lage en slik klasse hadde vært at spillreglene hadde vært helt adskilt slik at det kunne vært lettere å endre på reglene. 

Noe som kunne spart meg litt tid er å skrive mer kommentarer til metodene underveis.

Ellers synes jeg designet til brettene ble litt så som så. Jeg hadde en plan om å printe brett med box-drawing unicode, men dette ble dessverre nedprioritert da det tok litt for lang tid. Spesielt designet til fire på rad blir litt skeivt når disse emojiene slippes. 
