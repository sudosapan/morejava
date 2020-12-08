import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import java.util.Optional;

public class MyInjector {

    private Optional<Injector> injector;

    public <T extends AbstractModule> MyInjector(Class<T> module) {
        try {
            injector = Optional.of(Guice.createInjector(module.newInstance()));
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public Optional<Injector> getInjector() {
        return injector;
    }


}
