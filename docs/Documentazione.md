# Progetto MAP 19-20
### di Visci Nicola
**matricola 700797**

### Gruppo BJ e squillo di lusso

# Relazione tecnica
### Introduzione
Il progetto di Metodi Avanzati di Programmazione dell'anno accademico 19/20 prevede la realizzazione di un' Avventura Testuale in linguaggio Java.

Le avventure testuali sono applicazioni che simulano un ambiente nel quale i giocatori usano comandi testuali per istruire il personaggio della storia ad interagire con l'ambiente in cui si trova. Il giocatore usa una interfaccia a riga di comando per controllare il gioco, e anche la situazione di gioco � descritta al giocatore tramite frasi di testo.

Il modello di dominio dell'applicazione sar� quindi 
![Modello di dominio](./docs/Model Domain.jpg)

### Design
L'idea di base dell'applicazione prevede la realizzazione di un'interfaccia utente che possa ricevere gli input da una riga di comando, mostrare gli output sempre in forma testuale ed implementare alcuni shortcuts sotto forma di un pannello per le opzioni in modo da semplificare all'utente le istruzioni pi� importanti quali Nuova Partita, Salva Partita o Visualizza Regole.
Il diagramma delle classi per l'interfaccia utente � il seguente:
![Diagram class per l'interfaccia utente](./docs/User Interface Class Diagram.jpg)

L'interfaccia utente deve inviare i comandi testuali inseriti dall'utente all'unit� di controllo dell'input, che non � altro che il primo anello di una Chain-of-Responsibility pattern che processa il comando fornito, ed in base al responso modifica lo stato della partita oppure passa il comando all'anello della catena successivo. Successivamente sar� presentato il sequence diagram della catena di controllo input.

La classe partita � composta da due entit� ben definite: un'istanza di classe giocatore e un'istanza di classe scenario. La classe scenario a sua volta conterr� al suo interno molte istanze di classe ambiente, andando cos� a definire la mappa di gioco.

Per il salvataggio e il caricamento della partita, vengono salvati su file locale l'istanza corrente di giocatore e un'istanza di status di scenario, costruita secondo le caratteristiche dello scenario attuale.

Per il salvataggio dei dati, vengono utilizzate, tra le altre cose, le liste.
Ecco la **specifica algebrica** della lista:

**Specifica Sintattica**
Sort: list, item, position, boolean

- newList() -> list
- emptyList(list) -> boolean
- add(item , position, list) -> list
- remove(item, position, list) -> list
- getSpecifiedItem(position, list) -> item
- isIn(item, list) -> boolean
- getTop(list) -> position
- getPosition(item, list) -> position
- endOfList(position, list) -> boolean
- nextPos(position, list) -> position
- prevPos(position, list) -> position

**Specifica Semantica**
Declare l, l': list, i: item, pos: position

- add(i, pos, l) = l'
- remove(i, pos, add(i, pos, l)) = l
- emptyList(newList()) = true
- remove(pos, add(i, pos, l)) = l
- isIn(i, remove(i, pos, l)) = false
- endOfList(getTop(l), l) = true

**Specifica di restrinzione**
Restriction
    
- remove(pos, newList()) = error
- getTop(newList()) = error
- getPosition(i, remove(i, pos, l)) = error
- getSpecifiedItem(pos, newList()) = error
- endOfList(pos, newList()) = error

### Implementazione
Il codice sorgente dell'applicazione � diviso in 3 packages, ognuno con uno scope ben definito, per rispettare i principi di:
- Information Hiding
- Basso accoppiamento
- Alta coesione

I tre package sono in rispettivamente:
il **core package**, che contiene le pi� importanti classi di controllo dell'applicazione oltre alle classi contenitore per le entit� e le classi astratte ed interfacce che dovranno essere usati come template per lo sviluppo degli scenari compatibili. Le classi di controllo sono definite come Singleton e poste nella sequenza di una Chain-of-Responsibility;
il **gui package**, che contiene le classi di entit� dell'interfaccia utente: ogni componente dell'interfaccia � gestito come un Singleton, avendo delle specifiche di costruzione molto rigide. Tra questi componenti c'� anche una console creata appositamente per mostrare l'output dell'applicazione ed un campo di testo per l'inserimento dei comandi, che andranno poi inviati al core package;
lo **scenario_villa package**, che � l'unico scenario disponibile e giocabile in questa release: � composto da una classe di controllo dell'input specifico, una classe entit� per racchiuderne gli attributi e la lunga serie di ambienti presenti nello scenario e gestiti dalla classe entit� come una matrice di ambienti a 3 dimensioni (Circa 70 ambienti unici);


Per comprendere meglio il flusso di controllo della Chain of Responsibility, ecco il sequence diagram descrittivo
![Sequence Diagram Flusso di Controllo](./docs/Input Control - Sequence Diagram.jpg)
Il controllo dell'interfaccia utente invia il comando alla prima classe della catena: di l� ogni classe processa il comando ed in base al responso compie le proprie routine e restituisce il controllo all'interfaccia utente, altrimenti passa il comando in input alla classe successiva.

In generale, il flusso dell'applicazione segue un modello Event Driven.