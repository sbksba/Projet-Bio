CC=javac
OPTION=-Xlint:unchecked

all: LectureDtrain Statistiques Test Projet_Main

LectureDtrain : LectureDtrain.java
	$(CC) $(OPTION) $<

Test: Test.java
	$(CC) $(OPTION) $< 

Statistiques: Statistiques.java
	$(CC) $(OPTION) $< 

Projet_Main: Projet_Main.java
	$(CC) $(OPTION) $< 

.PHONY: all clean proper

proper:
	rm -f *~

clean: proper
	rm -f *.class
