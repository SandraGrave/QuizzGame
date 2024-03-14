DROP DATABASE IF EXISTS lf8quizz;
CREATE DATABASE lf8quizz;
CREATE USER 'lf8' IDENTIFIED BY 'password';
GRANT ALL PRIVILEGES ON lf8quizz.* TO 'lf8';
FLUSH PRIVILEGES;

USE lf8quizz;

CREATE TABLE Player (
    PlayerID INT AUTO_INCREMENT PRIMARY KEY,
    PlayerName VARCHAR(100),
    PlayerPassword VARCHAR(100),
    RankingPoints INT,
    RankingTitle VARCHAR(100)
);


CREATE TABLE Category (
    CategoryID INT AUTO_INCREMENT PRIMARY KEY,
    CategoryName VARCHAR(50)
);


create table Question (
    QuestionID INT AUTO_INCREMENT,
    CategoryID INT,
    difficulty VARCHAR(50),
    questionStatement VARCHAR (100),
    answerOptionA VARCHAR(50),
    answerOptionB VARCHAR(50),
    answerOptionC VARCHAR(50),
    answerOptionD VARCHAR(50),
    rightAnswer VARCHAR(1),

    primary key (QuestionID)
)AUTO_INCREMENT=1000;




INSERT INTO Player (PlayerName, PlayerPassword, RankingPoints, RankingTitle)
VALUES
    ('Anonymous', 'Pass!2341', 1500, 'Gold'),
    ('John', 'kfeF314!', 1200, 'Silver'),
    ('Casper', 'utTE783?', 1800, 'Gold'),
    ('Marvin', 'Mor&Gen421', 1100, 'Iron');


INSERT INTO Category (CategoryName)
VALUES
    ('ProjectManagement'),
    ('Network'),
    ('QualityManagement'),
    ('ITSecurity'),
    ('ITSystems'),
    ('Business'),
    ('Software');


-- Einfügen von Fragen für die Kategorie "Projektmanagement"
INSERT INTO Question (CategoryID, Difficulty, QuestionStatement, AnswerOptionA, AnswerOptionB, AnswerOptionC, AnswerOptionD, RightAnswer)
VALUES
    (1, 'Einfach', 'Was ist das Hauptziel des Projektmanagements?', 'A. Projekte rechtzeitig abschließen', 'B. Gewinn maximieren', 'C. Kundenzufriedenheit steigern', 'D. Risiken minimieren', 'C'),
    (1, 'Mittel', 'Wofür steht WBS im Projektmanagement?', 'A. Arbeitsstrukturplan', 'B. Arbeitsbilanz', 'C. Arbeits-Backup-System', 'D. Arbeitsfluss-Geschäftssystem', 'A'),
    (1, 'Schwer', 'Was ist der kritische Pfad im Projektmanagement?', 'A. Der längste Pfad durch das Netzwerkdiagramm', 'B. Der kürzeste Pfad durch das Netzwerkdiagramm', 'C. Der Pfad mit maximaler Fließzeit', 'D. Der Pfad mit minimaler Dauer', 'A'),
    (1, 'Einfach', 'Was ist der Zweck eines Gantt-Diagramms im Projektmanagement?', 'A. Projektbudget verwalten', 'B. Projektaktivitäten planen', 'C. Projektrisiken analysieren', 'D. Projektqualität überwachen', 'B'),
    (1, 'Mittel', 'Was ist der Unterschied zwischen PERT und CPM?', 'A. PERT ist ereignisorientiert, während CPM aktivitätsorientiert ist', 'B. PERT verwendet probabilistische Zeitabschätzungen, während CPM deterministische Zeitabschätzungen verwendet', 'C. PERT wird in Fertigungsprojekten verwendet, während CPM in Bauvorhaben verwendet wird', 'D. PERT ist für kleine Projekte, während CPM für große Projekte ist', 'A');


-- Einfügen von Fragen für die Kategorie "Netzwerk"
INSERT INTO Question (CategoryID, Difficulty, QuestionStatement, AnswerOptionA, AnswerOptionB, AnswerOptionC, AnswerOptionD, RightAnswer)
VALUES
    (2, 'Einfach', 'Was ist der Zweck eines Routers?', 'A. Mehrere Geräte innerhalb eines LAN verbinden', 'B. LANs verbinden', 'C. Ein LAN mit dem Internet verbinden', 'D. Netzwerksignale verstärken', 'B'),
    (2, 'Mittel', 'Was ist DNS?', 'A. Domain Name System', 'B. Dynamischer Netzwerkserver', 'C. Daten-Netzwerk-System', 'D. Digitale Netzwerksicherheit', 'A'),
    (2, 'Schwer', 'Was ist das OSI-Modell?', 'A. Ein Modell für TCP/IP-Kommunikation', 'B. Ein Modell für Netzwerksicherheit', 'C. Ein konzeptuelles Modell zum Verständnis der Netzwerkkommunikation', 'D. Ein Modell für die Softwareentwicklung', 'C'),
    (2, 'Einfach', 'Was ist DHCP?', 'A. Dynamisches Hostkonfigurationsprotokoll', 'B. Domain-Host-Konfigurationsprotokoll', 'C. Direktes Host-Konfigurationsprotokoll', 'D. Verteiltes Host-Konfigurationsprotokoll', 'A'),
    (2, 'Mittel', 'Was ist der Zweck von Subnetting?', 'A. Netzwerksicherheit verringern', 'B. IP-Adressen sparen', 'C. Netzwerkperformance verbessern', 'D. Netzwerkkomplexität reduzieren', 'B');


-- Einfügen von Fragen für die Kategorie "Qualitätsmanagement"
INSERT INTO Question (CategoryID, Difficulty, QuestionStatement, AnswerOptionA, AnswerOptionB, AnswerOptionC, AnswerOptionD, RightAnswer)
VALUES
    (3, 'Einfach', 'Was ist Qualitätskontrolle?', 'A. Der Prozess, Mängel nach der Produktion zu identifizieren', 'B. Der Prozess, Mängel vor der Produktion zu verhindern', 'C. Der Prozess, Mängel nach der Produktion zu verbessern', 'D. Der Prozess, Mängel während der Produktion zu dokumentieren', 'A'),
    (3, 'Mittel', 'Was ist Six Sigma?', 'A. Eine Qualitätsmanagementmethodik', 'B. Eine Projektmanagementmethodik', 'C. Eine Risikomanagementmethodik', 'D. Eine Finanzmanagementmethodik', 'A'),
    (3, 'Schwer', 'Was ist der Zweck von FMEA?', 'A. Fehlermodus- und -effektanalyse', 'B. Fehlermodus- und -fehleranalyse', 'C. Funktionsmodus- und -effizienzanalyse', 'D. Formulierungsmodus- und -effektivitätsanalyse', 'A'),
    (3, 'Einfach', 'Was ist der PDCA-Zyklus?', 'A. Planen-Durchführen-Überprüfen-Handeln', 'B. Produzieren-Liefern-Verbrauchen-Anpassen', 'C. Vorbereiten-Diskutieren-Koordinieren-Analysieren', 'D. Vorhersagen-Bestimmen-Ändern-Anpassen', 'A'),
    (3, 'Mittel', 'Was ist ISO 9001?', 'A. Ein Standard für Qualitätsmanagementsysteme', 'B. Ein Standard für Umweltmanagementsysteme', 'C. Ein Standard für Arbeitsschutzmanagementsysteme', 'D. Ein Standard für Informationssicherheitsmanagementsysteme', 'A');


-- Einfügen von Fragen für die Kategorie "IT-Sicherheit"
INSERT INTO Question (CategoryID, Difficulty, QuestionStatement, AnswerOptionA, AnswerOptionB, AnswerOptionC, AnswerOptionD, RightAnswer)
VALUES
    (4, 'Einfach', 'Was ist eine Firewall?', 'A. Ein Hardwaregerät zum Schutz eines Netzwerks vor unbefugtem Zugriff', 'B. Ein Softwareprogramm zum Scannen nach Viren', 'C. Ein kryptografisches Protokoll für sichere Kommunikation', 'D. Eine Datenbank zum Speichern von Benutzeranmeldeinformationen', 'A'),
    (4, 'Mittel', 'Was ist Phishing?', 'A. Eine Art von Malware', 'B. Eine Methode der sozialen Manipulation', 'C. Ein Protokoll für sichere Kommunikation', 'D. Ein Hardwaregerät für Netzwerksegmentierung', 'B'),
    (4, 'Schwer', 'Was ist Verschlüsselung?', 'A. Der Prozess, Daten in ein Format umzuwandeln, das nicht leicht verständlich ist', 'B. Der Prozess zur Authentifizierung eines Benutzers', 'C. Der Prozess zur Erkennung und Entfernung von Malware', 'D. Der Prozess zur Überwachung des Netzwerkverkehrs', 'A'),
    (4, 'Einfach', 'Was ist der Zweck von Antivirensoftware?', 'A. Um unbefugten Zugriff auf ein Netzwerk zu verhindern', 'B. Um den Netzwerkverkehr auf verdächtige Aktivitäten zu überwachen', 'C. Um Malware von einem Computersystem zu erkennen und zu entfernen', 'D. Um Daten während der Übertragung zu verschlüsseln', 'C'),
    (4, 'Mittel', 'Was ist ein VPN?', 'A. Virtuelles persönliches Netzwerk', 'B. Virtuelles privates Netzwerk', 'C. Virtuelles öffentliches Netzwerk', 'D. Virtuelles geschütztes Netzwerk', 'B');


-- Einfügen von Fragen für die Kategorie "ITSystems"
INSERT INTO Question (CategoryID, Difficulty, QuestionStatement, AnswerOptionA, AnswerOptionB, AnswerOptionC, AnswerOptionD, RightAnswer)
VALUES
    (5, 'Einfach', 'Was ist RAID?', 'A. Redundant Array of Independent Disks', 'B. Random Access Instruction Decoder', 'C. Rapid Access Integrated Drive', 'D. Remote Access Information Distribution', 'A'),
    (5, 'Mittel', 'Was ist ein SAN?', 'A. Storage Area Network', 'B. System Access Node', 'C. Structured Application Namespace', 'D. Secure Authorization Network', 'A'),
    (5, 'Schwer', 'Was ist Virtualisierung?', 'A. Der Prozess, physische Server in virtuelle Server umzuwandeln', 'B. Der Prozess, die Netzwerkleistung zu optimieren', 'C. Der Prozess, Daten für sichere Übertragung zu verschlüsseln', 'D. Der Prozess des Virtualisierens von Netzwerkschnittstellen', 'A'),
    (5, 'Einfach', 'Was ist DHCP?', 'A. Dynamic Host Configuration Protocol', 'B. Domain Host Configuration Protocol', 'C. Direct Host Configuration Protocol', 'D. Distributed Host Configuration Protocol', 'A'),
    (5, 'Mittel', 'Was ist Subnetting?', 'A. Eine große Netzwerk in kleinere Teilnetze aufteilen', 'B. IP-Adressen dynamisch zuweisen', 'C. Mehrere LANs zu einem einzigen Netzwerk verbinden', 'D. Die Netzwerksicherheit mithilfe von VPNs zu verbessern', 'A');


-- Einfügen von Fragen für die Kategorie "Business" mit IT-Bezug
INSERT INTO Question (CategoryID, Difficulty, QuestionStatement, AnswerOptionA, AnswerOptionB, AnswerOptionC, AnswerOptionD, RightAnswer)
VALUES
    (6, 'Einfach', 'Was ist ein Geschäftsmodell für Software as a Service (SaaS)?', 'A. Kunden zahlen einmalig für die Softwarelizenz', 'B. Kunden zahlen eine monatliche Gebühr für die Nutzung der Software über das Internet', 'C. Kunden zahlen für jedes Feature der Software', 'D. Kunden zahlen basierend auf der Anzahl der Benutzer der Software', 'B'),
    (6, 'Mittel', 'Was ist Outsourcing im IT-Bereich?', 'A. Die Nutzung von Cloud-Services für die Bereitstellung von IT-Diensten', 'B. Die Auslagerung von IT-Aufgaben und -Ressourcen an externe Dienstleister', 'C. Die interne Bereitstellung von IT-Infrastruktur und -Diensten', 'D. Die Nutzung von Open-Source-Software für Unternehmensanwendungen', 'B'),
    (6, 'Schwer', 'Was versteht man unter IT-Risikomanagement?', 'A. Die Identifizierung, Bewertung und Überwachung von Risiken im Zusammenhang mit IT-Systemen und -Prozessen', 'B. Die Verwendung von Verschlüsselungstechnologien zum Schutz von Daten', 'C. Die Implementierung von Firewalls und Intrusion Detection Systems zum Schutz vor Cyberangriffen', 'D. Die Analyse von Netzwerkprotokollen zur Erkennung von Sicherheitsverletzungen', 'A'),
    (6, 'Einfach', 'Was ist ein IT-Service-Level-Agreement (SLA)?', 'A. Ein vertragliches Dokument, das die vereinbarten Leistungsziele für IT-Dienste zwischen einem Dienstleister und einem Kunden festlegt', 'B. Ein Bericht, der die Service-Verfügbarkeit für IT-Dienste überwacht', 'C. Ein Plan zur Wiederherstellung von IT-Diensten nach einem Ausfall', 'D. Ein Prozess zur Beurteilung der Benutzerzufriedenheit mit IT-Diensten', 'A'),
    (6, 'Mittel', 'Was sind die Vorteile von Cloud-Computing für Unternehmen?', 'A. Skalierbarkeit, Kosteneffizienz und verbesserte Flexibilität bei der Bereitstellung von IT-Ressourcen', 'B. Höhere Sicherheit, bessere Leistung und geringere Ausfallzeiten im Vergleich zu lokalen Rechenzentren', 'C. Vollständige Kontrolle über Daten und Anwendungen, die in der Cloud gehostet werden', 'D. Geringere Abhängigkeit von Internetverbindungen und verbesserte Datenschutzbestimmungen', 'A');


-- Einfügen von Fragen für die Kategorie "Software"
INSERT INTO Question (CategoryID, Difficulty, QuestionStatement, AnswerOptionA, AnswerOptionB, AnswerOptionC, AnswerOptionD, RightAnswer)
VALUES
    (7, 'Einfach', 'Was ist der Softwareentwicklungs-Lebenszyklus (SDLC)?', 'A. Ein Prozess, um Hardwareprodukte zu entwickeln', 'B. Ein Prozess, um Softwareprodukte zu entwickeln', 'C. Ein Prozess, um Softwareprodukte zu vermarkten', 'D. Ein Prozess, um Softwareprodukte zu testen', 'B'),
    (7, 'Mittel', 'Was ist Versionskontrolle?', 'A. Eine Methode, um den Zugriff auf Software zu kontrollieren', 'B. Eine Methode, um verschiedene Versionen von Software zu verwalten', 'C. Eine Methode, um Änderungen in der Software zu verfolgen', 'D. Eine Methode, um die Leistung von Software zu überwachen', 'B'),
    (7, 'Schwer', 'Was ist agile Methodik?', 'A. Ein Softwareentwicklungsansatz, der auf iterativer Entwicklung basiert', 'B. Ein Softwareentwicklungsansatz, der auf linearer Entwicklung basiert', 'C. Ein Softwareentwicklungsansatz, der auf Dokumentation basiert', 'D. Ein Softwareentwicklungsansatz, der auf formalen Prozessen basiert', 'A'),
    (7, 'Einfach', 'Was ist objektorientierte Programmierung (OOP)?', 'A. Ein Programmieransatz basierend auf Objekten und Klassen', 'B. Ein Programmieransatz basierend auf Prozeduren und Funktionen', 'C. Ein Programmieransatz basierend auf Datenstrukturen', 'D. Ein Programmieransatz basierend auf Algorithmen', 'A'),
    (7, 'Mittel', 'Was ist der Unterschied zwischen Compiler und Interpreter?', 'A. Ein Compiler übersetzt Quellcode in Maschinencode, während ein Interpreter Quellcode direkt ausführt', 'B. Ein Interpreter übersetzt Quellcode in Maschinencode, während ein Compiler Quellcode direkt ausführt', 'C. Ein Compiler führt Quellcode direkt aus, während ein Interpreter Quellcode in Maschinencode übersetzt', 'D. Ein Interpreter optimiert Quellcode, während ein Compiler Quellcode kompiliert', 'A');