package example;

import org.apache.commons.collections.CollectionUtils;

import java.io.PrintStream;
import java.util.Collection;


public class Greeter {

    private PhraseBuilder phraseBuilder;



    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        //Collection emptyCollection = CollectionUtils.EMPTY_COLLECTION;
       // emptyCollection.add(name);
        return phraseBuilder.buildPhrase("hello", name);
    }

    public void setPhraseBuilder(PhraseBuilder phraseBuilder) {
        this.phraseBuilder = phraseBuilder;
    }
}

