# PiInitializer

Der Pi Initializer ist ein Karaf Bundle, das Initialisierungen 
am Raspberry Pi GPIO System vornimmt.

Konfigurierbare GPIO Pins werden von diesem Bundle auf Output Pins gesetzt.
Weitere Bundles (GPIOActor, RemoteActor) sind von der 
Ausführung dieses Bundles abhängig.

Die Konfiguration wird über das File PiInitializer.cfg aus dem etc Verzeichnis der
KARAF Instanz vorgenommen.
