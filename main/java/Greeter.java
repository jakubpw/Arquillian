import java.io.PrintStream;

public class Greeter {

    private PhraseBuilder phraseBuilder;



    public void greet(PrintStream to, String name) {
        to.println(createGreeting(name));
    }

    public String createGreeting(String name) {
        return phraseBuilder.buildPhrase("hello", name);
    }

    public void setPhraseBuilder(PhraseBuilder phraseBuilder) {
        this.phraseBuilder = phraseBuilder;
    }
}
