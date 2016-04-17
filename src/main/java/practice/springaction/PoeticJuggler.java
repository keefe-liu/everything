package practice.springaction;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by tingfang.liu on 2016/4/1.
 */
@Component
public class PoeticJuggler extends Juggler {

    @Autowired
    @Qualifier("haha")
    private Poem poem;

    public PoeticJuggler() {
    }

    public PoeticJuggler(Poem poem) {
        this.poem = poem;
    }

    public Poem getPoem() {
        return poem;
    }

    public void setPoem(Poem poem) {
        this.poem = poem;
    }
}
