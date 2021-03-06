package example;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import javax.inject.Inject;

import static org.mockito.Mockito.when;


@RunWith(Arquillian.class)
public class GreeterTest {
    @Rule public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Before
    public  void setUp()
    {
        greeter.setPhraseBuilder(phraseBuilder);
    }
    @Deployment
    public static WebArchive deploy()
    {
        WebArchive war = ShrinkWrap.create(WebArchive.class)
                .addClass(Greeter.class)
                .addClass(PhraseBuilder.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
        return war;
    }

    @Mock
    private PhraseBuilder phraseBuilder;

    @Inject
    Greeter greeter;

    @Test
    public void should_create_greeting() {

        when(phraseBuilder.buildPhrase("hello","1")).thenReturn("Hello2, 1!");

        Assert.assertEquals("Hello, 1!",
                greeter.createGreeting("1"));
        greeter.greet(System.out, "1");
    }
}