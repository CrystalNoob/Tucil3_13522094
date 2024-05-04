JC = javac
JX = java
SHELL = bash

BIN = bin
SRC = src

JCFLAG = --source-path $(SRC) -d $(BIN)

SRC_MAIN = $(SRC)/Main.java
CLS_MAIN = $(SRC_MAIN:.java=.class)

.PHONY: all clean

all: dictionary build run

%.class: %.java
	$(JC) $< $(JCFLAG)

dictionary:
	# $(SHELL) $(SRC)/Dictionary/sanitizer.sh
	@curl https://docs.oracle.com/javase/tutorial/collections/interfaces/examples/dictionary.txt > $(BIN)/dictionary.txt

build: $(CLS_MAIN)

run: $(BIN)/dictionary.txt
	@cd $(BIN); $(JX) Main astar dictionary.txt tea top
	@cd $(BIN); $(JX) Main ucs dictionary.txt tea top
	@cd $(BIN); $(JX) Main gbfs dictionary.txt tea top

clean:
	rm -rf $(BIN)/*
