JAVASRC = Autocomplete.java
SOURCES = README Makefile $(JAVASRC)
MAINCLASS = Autocomplete
CLASSES = Autocomplete.class
JARFILE = Autocomplete
SUBMIT = submit cmps012b-pt.s16 pa2

all: $(JARFILE)
$(JARFILE): $(CLASSES)
	echo Main-class: $(MAINCLASS) > Autocomplete
	jar cvfm $(JARFILE) Autocomplete $(CLASSES)
	rm Autocomplete
	chmod +x $(JARFILE)
$(CLASSES): $(JAVASRC)
	javac -Xlint $(JAVASRC)
clean:
	  rm $(CLASSES) $(JARFILE)
submit: $(SOURCES)
	$(SUBMIT) $(SOURCES)
check:
	$(CHECK)
