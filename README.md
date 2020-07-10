# Progetto MAP 19-20
### di Visci Nicola
**matricola 700797**

### Gruppo BJ e squillo di lusso

La repository del progetto è strutturata nel seguente modo:
```
|–– README.md
|-- .setting
|-- src/main/java
|              |-- core
|              |-- gui
|              |-- scenario_villa
|–– target
|      |-- classes
|      |-- maven-archiver
|      |-- maven-status/maven-compiler-plugin
|      |-- MAP_1920_Visci_Nicola-0.0.1-SNAPSHOT.jar
|–– src
|    |–– Documentazione.md
|    |–– images
|-- .classpath
|-- .project
|-- pom.xml
```

Di seguito una breve spiegazione del contenuto e scopo delle varie directory e sottodirectory:

- Nella directory **src/main/java** è presente il **codice sorgente** dell'applicazione suddiviso in 3 packages: **core,  gui,    scenario_villa**.

- Nella directory **target** sono presenti i file del software di gestione di progetti software **Maven**, compreso il plugin di Maven compiler. All'interno di target c'è anche la build dello snapshot dell'applicazioni in formato package .jar.

- Nella directory **src** è presente il file di documentazione del software **Documentazione.md** in linguaggio di markup Markdown.
In **src/images** invece ci sono i sorgenti delle immagini presenti nel file di documentazione.

- I successivi file sono file di configurazione di Maven, compreso il relativo Project Object Model di Maven **POM.xml** 
