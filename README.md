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

Programmet består av flere deler (pakker):

- Main - her startes programmet, initierer valgt spill og kjører startGame().


- Games - "kjernen" i spillet, og interaksjon med spillbrettet. Det er her hver runde i spillet blir gjennomført. 


 - Board - inneholder logikken og det fysiske bak hvert spill, arver fra griden
 
 
 - Grid - er generisk, og gir datastrukturen til spillene 
 
 
 - Markers - klasser for markører som benyttes i spillet, hver spiller har sin egen markør. 
 
 
 - Players - skiller menneskelig spiller fra AIspiller, og inneholder informasjon om disse spillerne
 
 
 - Tester - tester for hvert spill for å teste de viktigste metodene og finne eventuelle bugs

### Bruk
For å starte programmet kjør: GameMain(). Når du kjører denne vil du få spørsmål om hvilket spill du ønsker og spille, og hvorvidt du ønsker å spille mot en AI eller en annen menneskelig spiller. 

Når spillet kjører, vil du få spørsmål i terminalen om hvor du ønsker å legge brikken din. I connect4(fire på rad) skal du velge en kolonne mellom 1-7, mens i tictactoe(tripp trapp tresko) får du spørsmål om både kolonne og rad mellom 1-3. Dersom du i terminalen skriver et tall som vil være utenfor brettet eller som allerede er tatt, vil du få en melding om dette, og i tillegg spørsmål om å skrive inn på nytt. 

Når du vinner vil det komme opp en melding om at "Vinneren er: ...", og deretter vil du få spørsmål om du ønsker å spille på nytt eller avbryte. Det samme skjer dersom det blir uavgjort. 
   

## Designvalg
- Jeg har valgt å løse denne oppgaven ved hjelp av et tekst-basert grensesnitt. For å gjøre et tekst-basert design litt mer spennende har jeg valgt å bruke emojis (unicode) som markører i stedet for bokastaver. 


- I tillegg har jeg valgt å benytte meg av Grid og IGrid fra tidligere lab som var gitt fra begynnelsen. IGrid er generisk, og ved å benytte denne koden vil jeg få et grid av brikker eller marker. Griden ble en slags base for programmet, og har blitt brukt til å representere spillbrettene. 


- Board-klassen extender Grid-klassen, og inneholder logikken og det fysiske bak hvert spill. Her finnes funksjonalitet som å slippe markør, sjekke om en posisjon allerede er tatt, sjekke vinner og uavgjort, og initialisere nytt, tomt brett. Connect4Board og TicTacToeBoard arver disse egenskapene fra Board, i tillegg til å implementere funskjonalitet som er spesifikk for det enkelte spillet. 


- For spillere har jeg valgt å lage et interface IPlayer. Både HumanPlayer og AIPlayer implementerer denne.  Begge spillerne oppfører seg veldig likt, med unntak av at AIspilleren velger en tilfeldig kolonne og rad. HumanPlayer velger kolonne og rad ved input fra spilleren selv. For hvert spill har hver spiller en bestemt markør og et bestemt spillernavn. Her kunne jeg eventuelt latt spillerne selv bestemme hvilket navn og hvilken markør de ønsker, men dette ønsket jeg ikke å legge noe særlig vekt på.


- For markørene har jeg laget en enum GameMarkers som holder alle markørene til programmet, både CROSS, CIRCLE, YELLOW, RED og SPACE. Disse markørene skal ikke kunne endres, og derfor passer det bra med en enum her. 


- For game-klassene er det laget et interface IGame, som både Connect4Game og TicTacToeGame implementerer. Disse klassene inneholder funksjonalitet som gjør det mulig å benytte seg av spillbrettene i spillet. De holder oversikt over hva som skjer i spillet, og sørger for at ting skjer i henhold til hvordan spillet skal oppføre seg. Man kan kalle disse klassene "kjernen" i programmet fordi de knytter sammen de øvrige delene. Metoden doTurns() sørger for at spillerne utfører hver sin runde med å legge gyldige brikker, sjekker om man har vunnet eller om det er uavgjort. 


- GameMain er den "øverste" klassen som kjører programmet ved å hente input fra brukeren om hvilket spill som skal spilles, og antall spillere. 


### Bruk av abstraksjon
Programmet er separert i klasser som representerer forskjellige deler av spillene. 
 - Board er selve brettet og inneholder fysikken og logikken bak spillene, mens Connect4Board og TicTacToeBoard inneholder det som er særegent for hvert spillbrett. 
 - IPlayer representerer selve spilleren, og kan være en HumanPlayer eller en AIPlayer. Her bestemmes markør og navn til spilleren, i tillegg til informasjon om hvor man ønsker å legge brikken sin. 
 - Game-klassene styrer spillets gang. De holder orden på spillernes tur, og kjører spillet helt til noen har vunnet eller det er uavgjort. 
 - Markers-klassen representerer de ulike markørene som brukes i programmet.

Bruken av abstraksjon har blant annet vært veldig nyttig for å endre enkelte klasser uten å måtte endre hele programmet

### Erfaring – hvilke valg viste seg å være gode / dårlige?
I begynnelsen valgte jeg å ha et interface "IBoard", men oppdaget etterhvert at board-metodene til begge spillene var svært like. Jeg valgte derfor å lage en klasse "Board" i stedet som implementerer alle metodene som er like for begge spill og som arver egenskapene til Grid. Connect4Board og TicTacToeBoard arver igjen egenskapene til Board-klassen, i tillegg til å implementere metoder som er spesifikke for hvert enkelt spill. På denne måten ble det bedre oversikt, og mindre overflødig kode. Dette er et godt eksempel på gjenbruk av kode. 


## Testing
Utviklingen av programmet ble i begynnelsen hovedsakelig gjort ved å prøve og feile. Jeg kjørte spillet fra mian, og prøvde meg fram for å se i hvilke deler av spillet det lå feill  

I etterkant har jeg laget og utført tester ved hjelp av JUnit. Her blir de viktigste metodene i programmet testet for hvert spill. Disse testene sjekker at output samsvarer med input. Det var i løpet av denne testingen jeg oppdaget feil som kunne vært vanskelig å oppdage kun ved å kjøre programmet, så denne testingen har vært veldig nyttig. Jeg oppdaget blant annet at jeg hadde byttet om på horizontalWin og verticalWin, noe som ikke ble oppdaget da koden bare skulle sjekke vinner (altså enten horisontal, vertikal eller diagonal). 

Jeg har blant annet testet at brikkene havner der de skal når de slippes, at det er en vinner dersom det er 3/4 brikker på rad, om et trekk er gyldig, og om brettet fungerer slik det skal. 

## Funksjonalitet, bugs
Spillet fungerer bra. Det eneste jeg kjenner til er at du ikke får noen feilmelding dersom du skriver feil input i GameMain() eller når du får spørsmål om å starte spillet på nytt. 

## Evt. erfaring fra code review


## Annet
Jeg er litt usikker på om jeg kanskje ville laget en ekstra klasse for spillregler. Her ville jeg eventuelt satt metodene for å sjekke vinner, og for å sjekke uavgjort. Disse metodene ligger nå i Board. Fordelen med å lage en slik klasse er at den vil være adskilt slik at det blir lettere å gjenbruke koden i resten av spillet selv om man ønsker å endre på reglene. For eksempel kunne man spilt fem på rad. I dette programmet har jeg laget metoden for å sjekke vinner slik at du kan endre på winConditions i game-klassene, og du vil derfor kunne endre spillreglene med begrensninger til antall brikker på rad. 
 
Noe som kunne spart meg litt tid er å skrive mer kommentarer til metodene underveis.

Ellers synes jeg designet til brettene ble litt så som så. Jeg hadde en plan om å printe brett med box-drawing unicode, men dette ble dessverre nedprioritert da det tok litt for lang tid. Spesielt designet til fire på rad blir litt skeivt når disse emojiene slippes. 
