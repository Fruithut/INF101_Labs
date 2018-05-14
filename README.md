#### *NB: This repository has been cloned from a GitLab server that was used for assignment delivery*

# Lab 4 – Testing og generatorer

## Læringsmål

Når du er ferdig med oppgaven, skal du kunne (på egenhånd, med dokumentasjon tilgjengelig):

* Skrive testmetoder sjekker en gitt egenskap med tilfeldige data
* Skrive en egenskapsmetode som sjekker enkle egenskaper (f.eks. egenskaper til `equals`)
* Lage en generator som lager objekter av en klasse ved hjelp av generatorer for feltvariablene

## Innhold

Prosjektet inneholder følgende Java-pakker:

* [inf101.v16.datastructures] – inneholder klasser og grensesnitt for 2D-grid og liste – samme som i [lab-2](Lab2).
* [inf101.v16.tests] – pakke for diverse tester av innholdet i de andre pakkene
* [inf101.v16.util] – inneholder klasser og grensesnitt for 2D-grid og for datagenerering
* [inf101.v16.util.generators] – klasser for generering av spesifikke typer data

# IGenerator

[IGenerator] et et grensesnitt for å generere tilfeldige data. Gitt en objekt av typen `IGenerator<T>` og et `Random`-objekt, kan du få produsert et tilfeldig objekt av typen `T` (eller eventuelt en serie objekter som er garantert å være `equals` – dette er nyttig i noen sammenhenger).

I `inf101.v16.util.generators`-pakken ligger det to klasser for å lage tilfeldige heltall og strenger.

For eksempel:

```
Random r = new Random();
IGenerator<String> strGen = new StringGenerator(5,15);
System.out.println("Tilfeldig streng: " + strGen.generate(r));
IGenerator<Integer> intGen = new IntGenerator(0, 1000);
System.out.println("Tilfeldig heltall mellom 0 og 1000: " + intGen.generate(r));
```

* Egenskaper ved objektene som genereres kan justeres når du kalle konstruktøren til generatoren. F.eks. kan du oppgi ønsket lengde på strengene, og ønsket størrelse på tallene.
* I praksis kan du også bruke generatorene uten å oppgi et `Random`-objekt – da får du et automatisk. Men når du selv skal implementere generatorer, må du gi `Random`-objektet hvis du skal kalle andre generatorer, ellers vil `generateEquals`-metoden ikke virke.

# Oppgave 1: Prøv IGenerator.

* Lag en klasse med en `main`-metode som:
   * Genererer 10 tilfeldige strenger og skriver de ut.
   * Genererer en `List` av 5 like strenger (med `generateEquals`), og skriver de ut.
   * Genererer 1000000 heltall mellom 0 og 1000, og skriver ut gjennomsnittet. (Sjekk at snittet ligger rundt 500.)

(Hvis du vil sjekke heltallsgeneratoren med flere heltall, eller med større heltall, bør du bruke en `long` og ikke en `int` til å lagre mellomsummen før du regner ut snittet, ellers går du utenfor kapasiteten til 32-bits heltall og resultatet vil bli helt rart.)

# Oppgave 2: Testing med genererte strenger.

Kikk på klassen [inf101.v16.tests.StringTest].

* Skriv en metode `transitiveProperty` som tar tre strenger og sjekker at `equals` for strenger er *transitiv*, dvs. at:

```
public void transitiveProperty(String s1, String s2, String s3) {
  if(s1.equals(s2) && s2.equals(s3))
    assertEquals(s1, s3); // transitivitet
}
```

* Lag en `@Test`-metode som kaller `transitiveProperty` `N` ganger, med tre nye strenger hver gang.
* Lag enda en test-metode, som `N` ganger bruker `generateEquals` til å lage en liste av tre strenger, og kaller `transitiveProperty` med de tre strengene.
* Lag tilsvarende tester for de to andre egenskapene til `equals` (og andre [ekvivalensrelasjoner](http://en.wikipedia.org/wiki/Equivalence_relation)):

```
assertEquals(s, s);  // refleksivitet

if(s1.equals(s2))
  assertEquals(s2, s1); // symmetri
```

* Lag også tester for sammenhengen mellom `hashCode` og `equals` (to like objekter skal ha samme hashCoe, dvs. at `if(s1.equals(s2)) assertEquals(s1.hashCode(), s2.hashCode())`). (`hashCode` metoden brukes blant annet av [HashMap](http://docs.oracle.com/javase/8/docs/api/java/util/HashMap.html) for å raskt slå opp nøkler i en tabell. `HashMap` er avhengig av sammenhengen mellom `hashCode` og `equals` for å virke.)

(Alle testene bør være grønne når de kjøres.)

# Oppgave 3: Generator for 2D-Grid.

Grensesnittet [IGrid] er det samme som fra [Lab 2](lab-2). Det følger med en implementasjon, 
[MyGrid] som er tilsvarende den du skal ha laget på Lab 2.

Det er *minst én* feil i `MyGrid`. Feil(ene) skal vi nå finne ved hjelp av testing.

Først må vi ha en generator for tilfeldige grid. Merk at `IGrid` og `MyGrid` er *generiske* – dvs at vi ikke vet hva elementtypen er. Vi kan lage generatoren generisk også:

```
public class MyGridGenerator<T> implements IGenerator<IGrid<T>> {
```

Dvs. at når vi lager en ny grid-generator, må vi si hvilken elementtype gridet skal ha. For å få laget selve elementtypene, trenger vi bare å sørge for at den har en generator for elementtypen:

```
IGenerator<IGrid<String>> gridGen = new MyGridGenerator<String>(new StringGenerator());
```
 
* Fullfør implementeringen av `generate(Random r)` i [inf101.v16.util.generators.MyGridGenerator](https://inf101.ii.uib.no/inf101.v16.oppgaver/inf101.v16.lab3/tree/master/src/inf101/v16/util/generators/MyGridGenerator.java). De andre metodene er allerede ferdig laget.

# Oppgave 4: Testing av MyGrid2D.

Se på test-klassen [inf101.tests.MyGridTest]. Den inneholder noen få tester, og noen property-metoder for å sjekke egenskaper ved metodene til grid-klassen.

* `setGetTest` sjekker skal sjekke at `get` etter `set` på samme posisjon gir samme verdi tilbake. Skriv ferdig metoden `setGetProperty` som sjekker dette for et gitt `grid`, `x`, `y` og `val`. *(Merk deg at metoden `setGetProperty` er generisk; den har en `<T>` før returtypen. Det vil si at den kan brukes på alle grid, uansett elementtype, selv om vi bare tester med strenger.)*

* Metoden `setGetIndependentProperty` sjekker om en `set` på en gitt posisjon ser ut til å påvirke verdien på en annen gitt posisjon. Skriv en tilhørende testmetode (etter modell av `setGetTest`), som lager tilfeldige data og kaller `setGetIndependentProperty` `N` ganger.

* To andre metoder mangler tester: `getWidth` og `getHeight`. Lag tester for disse også. Her kan du f.eks. bruke `intGen` til å lage vilkårlig bredde og høyde, så opprette et `MyGrid`-objekt og sjekke at høyde/bredde er som ønsket.

* Kjør alle testene, og fiks eventuelle problemer du finner i `MyGrid`-klassen. Husk at om en test feiler, kan det også tenkes at du har gjort en feil i testen (eller i generatoren) – feilen trenger ikke nødvendigvis være i implementasjonen.

*Noen av testene tar kanskje veldig lang tid med `N = 1000000`. Du kan evt. bruke `N/1000` eller `N/100` i løkkene som tar veldig lang tid.*

# Oppgave 5: Equals.

* Implementer `hashCode` og `equals` for `MyGrid`. (Du kan bruke *Source → Generate hashcode and equals* i Eclipse – de er litt for komplisert til at det er lett å gjøre det selv)
* Test equals-metoden til MyGrid etter samme mønster som i Oppgave 2.




