#### *NB: This repository has been cloned from a GitLab server that was used for assignment delivery*

[Lab 5: Andedam](lab-5)
===

## Læringsmål

* Bli kjent med bruk av arv og abstrakte klasser
* Kjenne til effekten av private og protected

## Om oppgaven

I lab-oppgaven denne uken skal vi forbedre andedammen fra [forelesningene i januar](https://retting.ii.uib.no/inf101/inf101v17/wikis/forelesninger/0203-Objekter), slik at vi kan ha ender med litt forskjellig oppførsel.

Vi skal bruke arv, slik at felles oppførsel havner i superklassen, mens spesiell oppførsel havner i subklassene.


# Steg 0: Gjør ferdig tidligere oppgaver

Laboppgavene bør gjøres i rekkefølge, som om du ikke er helt ferdig med den forrige, gjør den ferdig først. (Det er helt normalt å bruke mer enn en uke på en oppgave).

# Steg 1: Hent Oppgaven fra git

Som før skal du ha et repository for oppgaven på retting.ii.uib.no. Se [Lab
1](lab-1) og [Lab-2](lab-2) for mer informasjon og instrukser. Oppgaven skal dere kunne finne i
repositoriet med den følgende urien:

    https://retting.ii.uib.no/<brukernavn>/inf101.v17.lab5.git

## Oversikt over koden

* inf101.v17.pond – kode for andedam 
* **inf101.v17.pond.Duck** – kode for ender 
* inf101.v17.pond.Pond – kode for andedam 
* inf101.v17.pond.IPondObject – grensesnitt for ting som kan være i andedammen 
* **inf101.v17.pond.Fish** – ikke-fungerende kode for fisker 
* inf101.v17.pond.Gender – enum med `MALE` og `FEMALE` 
* **inf101.v17.pond.PondDemo** – kjørbart program
* inf101.v17.pond.Position – klasse for (x,y)-posisjoner
* inf101.v17.pond.Direction – klasse for retninger 
 
## Steg 2: Kjøre programmet

* Kjør programmet i `inf101.v17.pond.PondDemo`. Du skal se noen ender som svømmer rundt i en andedam.
* Les gjennom kode og [notatene fra forelesningen](https://retting.ii.uib.no/inf101/inf101v17/wikis/forelesninger/0203-Objekter)

## Steg 3: Forskjellige ender

Vi har tre typer ender på skjermen:

* Brune hunn-ender
* Grå/grønne hann-ender
* Små gule andunger

I tillegg har vi også fisker, som er grå og ikke gjør noe fornuftig i det hele tatt (vi ser på disse senere i oppgaven).

Vi vil nå at endene skal oppføre seg litt forskjellig, basert på om de er hann, hunn eller unge. Vi kan gjøre dette på to måter:

1. Bruke `if`-setninger til å gjøre forskjell på dem, f.eks. i `step()`-metoden.
2. Lage forskjellige klasser for hver form for and, med forskjellig implementasjon av `step()`-metoden.

Det første valget er greit hvis vi har få forskjeller i oppførsel. Det andre er å foretrekke om vi har mange forskjellige varianter eller store forskjeller i oppførsel.

Vi skal bruke den andre teknikken til å lage forskjellig ande-oppførsel. Siden en god del ting er likt mellom forskjellige varianter av ender, vil vi bruke *arv*, slik at vi unngår å duplisere kode. Vi skal begynne med å lage en egen klasse `Duckling`, med oppførselen til andunger. Gjør følgende:

* Behold klassen `Duck`
* Lag en ny klasse `Duckling extends Duck`, og overstyrer `step`-metoden med ønsket oppførsel (du kan velge oppførsel selv)
```
     public class Duckling extends Duck {

    	public Duckling(Gender gender, Position pos, Direction dir, Pond pond) {
    		super(gender, true, pos, dir, pond);
    	}
    
    	@Override
    	public void step() {
    	}
	
    	// ...
    }
```
* Merk at `Duckling`-klassen ikke har egne feltvariabler; alle feltvariablene er arvet fra superklassen `Duck`.
* Hva skjer når du bruker feltvariablene i Ducklings step-metode? (F.eks. hvis du kopier inn koden fra `Duck`)
    * Feltvariabler og metoder som er merket `private` er ikke direkte tilgjengelig i subklasser. For å bruke de må du enten kalle `public`-metoder, eller du må merke feltvariablene som `protected`.
    * `protected` betyr at feltvariabelen/metoden er tilgjengelig for klassen selv, og alle subklasser. De er fremdeles beskyttet (innkapslet) om utenforstående klasser. Endre relevante feltvariabler i Duck slik at de er `protected`. De er nå tilgjengelig i Duckling-klassen, men ikke i andre klasser, som f.eks. `Pond`.
    * Generelt vil vi helst at objektene våre er best mulig innkapslet; jo færre steder i programmet en feltvariabel kan leses/skrives, jo færre steder trenger vi å forholde oss til hvis vi skal endre noe eller fikse et problem. Så hvis mulig vil vi helst unngå å bruker `protected 
* Overstyr også `isAdult`-metoden i Duckling så den alltid returnerer `false`.
* Du må lage en konstruktør for `Duckling` som kaller konstruktøren til super-klassen. Super-konstruktøren kaller du med `super(gender, ....)`
* Endre koden for `setup()` i `DuckDemo` slik at den andungen blir et `Duckling`-objekt i stedet for `Duck`.
* Kjør programmet og se at det virker.


### Forslag til andunge-oppførsel

En grei oppførsel er å få andungene til å følge etter nærmeste hunn-and. Du kan finne andre pond-objekter i nærheten med `pond.nearbyObjects()`. F.eks. noe slikt som:
```
			List<IPondObject> nearbyObjects = pond.nearbyObjects(this, 400);
			for (IPondObject o : nearbyObjects) {
				if (o instanceof Duck) {
					Duck d = (Duck) o;

					if (d.age >= ADULT && d.gender == Gender.FEMALE) {
						direction.turnTowards(pos.directionTo(d.getPosition()), 5);
						break;
					}
				}
			}
```
Du kan også la andungen ha en egen "mamma"-feltvariabel, med en `Duck` som den skal følge etter.   


### Litt repetisjon om typer, klasser, grensesnitt og arv

Hvis vi husker tilbake til hva vi har lært om typer og klasser, vet vi at:

* Typen bestemmer hvilke metoder vi har lov å kalle. Alle endene våre (og fiskene) implementerer `IPondObject`-grensesnittet, og vi kan derfor kalle metodene derfra (inkl., f.eks. `step()` som utfører et steg av oppførselen, og `draw()` som tegner på skjermen).
* Klassen gir koden for metodene og feltvariablene, og bestemmer hva som skjer når programmet kjører. For eksempel, hvis vi har to ender, den ene av klassen `MaleDuck` og de andre av klassen `FemaleDuck` (og begge implementerer IPondObject), så kan de gjerne ha forskjellig oppførsel for `step`-metoden, og forsåvidt også forskjellig datastruktur.

Arv gjør at vi kan bygge en ny klasse *B* på en eksisterende klasse *A*. Hvis `B extends A`, så vil det si at:

* Objekter av klassen B har alle metodene fra både A og B. Hvis det er metoder med samme navn og parameterliste (*signatur*), så er det metodeimplementasjonen fra B som blir foretrukket.
* Objekter av klassen B har alle feltvariablene fra både A og B. Hvis det er feltvariabler med samme navn, blir variablene fra B brukt i B og variablene fra A brukt i A.
* Klassen B implementerer alle grensesnitt som A implementerer. Den kan også implementere grensesnitt på egenhånd, f.eks. `B extends A implements I`.
* Konstruktøren til B må kalle konstruktøren til A aller først. Dette er nødvendig fordi alle B-objekter også har feltvariablene til A, og de må settes opp i henhold til A.
* Alle B-objekter er kompatible med typen A, dvs. at du kan bruke dem i variabler med typen A.

## Steg 2.5: Testing

Du bør lage litt tester underveis. Til denne typen oppgave passer det med eksempelbaserte tester, f.eks.:

* Lag en Pond med en and.
* Kjør Pond.step().
* Sjekk at andens posisjon har endret seg i tråd med hva du forventer. (F.eks. du kan ha en mor og en andunge i en dam,  la moren stå i ro (ikke kalle swim()), og sjekke at avstanden mellom dem minker)

## Steg 3: Fikse Duck

Koden i `Duck` er nå litt mer komplisert enn den trenger å være. Koden for ung/gammel kan fjernes, justeres eller flyttes til `Duckling`:

* Du kan fjerne feltvariabelen `age`. Stedene den er brukt erstatter du med kall til `isAdult()` eller med å ha forskjellig kode i Duck og Duckling.
* Parameteret `duckling` til konstruktøren kan du også fjerne. Justeringer av `size` og `speed` kan du i stedet gjøre basert på `isAdult()`, eller ved å la konstruktøren til Duckling sende dette til super-konstruktøren. 
* Du kan overstyre `getColor` i Duckling så den alltid gir samme farge.
* Du kan evt la Duckling ha sin egen variant av `draw`-metoden, uten `if`-setninger. 

Det er ingen fast oppskrift på nøyaktig hvordan `Duck` bør se ut når du har flyttet oppførselen for andunger ned i en subklasse – men du kan ha følgende i bakhodet:

* Se på hver `if`-setning, og se om den gjelder forskjeller på unge og voksne ender, og i såfall kanskje kan fjernes ved å ha forskjellig kode i superklassen Duck og subklassen Duckling.
* Er det noen feltvariabler som bare er relevante for subklassen? I såfall kan de flyttes til subklassen.
* Er det noe kode/feltvariabler som du har i *både* superklassen og subklassen? I såfall bør du vurdere å skrive om slik at felles kode bare er i superklassen.
    * Dette er særlig relevant for `step`-metoden. Her vil du antakelig at alle ender uansett skal ha koden som flytter anden i henhold til fart og retning. Dvs. at du gjerne er i situasjonen at `Duckling` sin `step()`-metode skal gjøre alt som `Duck` gjør + litt til. Dette fikser du ved å legge inne et super-kall til `step`-metoden i superklassen:
```
    @Override
	public void step() {
		super.step(); // kaller step() i superklassen
		// ....
	}
```
* Kjør programmet og se at det virker.
    
## Steg 4: Flere subklasser

* Lag to nye subklasser `MaleDuck` og `FemaleDuck`. Gjør slik du gjorde for Duckling, og flytt koden som skiller hann-ender og hunn-ender ned i subklassene.
* Du kan selv velge hvordan `step` skal være for `MaleDuck` og `FemaleDuck`. F.eks. kan hann-endene oppføre seg som før, mens du har litt ekstra kode for hunn-endene som gjør at de stopper om det ikke er andunger i nærheten (slik at andungene rekker å følge etter). Husk at du kan få en liste over andre objekter i nærheten i andedammen med `pond.nearbyObjects(this, avstand)` (gir alle objektene innenfor avstanden, f.eks. 400).
* Overstyr `isMale` og `isFemale` i subklassene så de alltid returnerer `true`/`false` direkte.
* Etter mønster fra steg 3 kan du nå fjerne feltvariabelen `gender` og kanskje noen if-setninger.
* Endre koden for `setup()` i `DuckDemo` slik at den bruker de nye subklassene.
* Kjør programmet og se at det virker.

## Steg 5: Tankearbeid

* En naturlig del av å være andunge er at man (så sant man overlever) etterhvert blir til en voksen and. I Java kan ikke objekter endre klasse underveis – hvordan bør vi håndtere at en andunge blir voksen? (Koden inneholder for øyeblikket ikke noen teller for alder og slikt, så det er i prinsippet ikke noe problem i dette programmet.)
* Vi *kan* løse dette ved å bytte ut andunge-objektene med voksen-and-objekter når de blir voksne – filosofisk sett er det litt uelegant; det er jo fremdeles samme anden, den har bare endret størrelse, utseende og oppførsel.
* En annen mulighet er å skille i flere klasser, en for selve individene (som har posisjon, retning osv), og en for utseende og oppførsel. Hvert individ kan så ha et utseende- og oppførsel-objekt som kan byttes ut senere.
* Dette kan også bety at vi det var en *dårlig* ide å skille ut `Duckling`-oppførselen i en subklasse. Ofte er det vanskelig å vurdere på forhånd hvilke ting som egner seg for arv. Det kan lønne seg å først skrive programmet uten arv, og så eventuelt innføre arv senere når man vet bedre hva man trenger.

## Steg 6: Abstrakt superklassee

En *abstrakt klasse* er en klasse hvor ikke alle metodene er implementert. Det er derfor ikke mulig å lage objekter av klassen (ellers kunne vi risikere at noen kalte en metode som ikke var implementert). Eneste måten å bruke abstrakte klasser på er å *arve* fra dem, og så lage objekter av subklassene. 

Abstrakte klasser er perfekte for situasjoner der du har en del felles oppførsel, men samtidig ikke nok felles oppførsel til at du kan lage fornuftige objekter med *bare* den felles oppførselen. For eksempel kan vi ha tilfellet at alle dyr har en posisjon og en størrelse og `step` og `draw` metoder, uten at det finnes et komplett sett oppførsel som er felles for alle dyr. Alle konkrete dyr vil tilhøre en subklasse som and, torsk eller kanin.

Du gjør en klasse abstrakt ved å putte `abstract` foran `class` i deklarasjonen: `public abstract class Duck`. I den abstrakte klassen kan du ha metoder som ikke er implementert, men som må implementeres i subklassene. Du kan også ha metoder og feltvariabler som er implementert, og som blir arvet til subklassene.

* Gjør klassen `Duck` abstrakt.
* La metodene `isAdult`, `isMale` og `isFemale` være abstrakte (e.g., `public abstract boolean isAdult();`.
* La `step`-metoden inneholde bare kode som er felles for alle subklassene (f.eks. koden for å oppdatere posisjon). Du kan la koden i subklassene bygge på dette ved å bruke `super.step();` i subklasse-metodene.
* Du kan gjerne endre navnet på `Duck` klassen (høyreklikk → Refactor →  Rename) til `AbstractDuck` for å indikere at den er abstrakt.
* Hvis du er språknerd, vil du kanskje også gjerne bruke *Refactor*-menyen og endre navn på klassene `FemaleDuck` og `MaleDuck` til det mer passende `Duck` og `Drake`.

## Steg 7: Enda mer abstrakt superklasse (ekstra / avansert)

* En del ting er felles for alle ting i andedammen; posisjon, retning, størrelse – kanskje andre ting.
* Lag en abstrakt superklasse `AbstractPondObject implements IPondObject`. (Du kan gjøre dette med *Extract Superclass* fra *Refactor*-menyen.)
    * Det er rimelig å ha med feltvariablene `size`, `speed`, `pos` og `direction`, 
    * Du kan antakelig implementerere metodene `getX()`, `getY()`, `getWidth()`, `getHeight()`, `getPosition()` og `getDirection()` i `AbstractPondObject` og la `step` og `draw` være abstrakte.
* La `AbstractDuck` arve fra `AbstractPondObject` Pass på at du ikke har overflødig kode igjen i `AbstractDuck`.
* Implementer `Fish extends AbstractPondObject`, med kode for fisker (du velger oppførsel selv).
