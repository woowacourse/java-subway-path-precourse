package subway.controller;

import java.util.function.BiConsumer;
import subway.Scene;
import subway.view.View;

public abstract class ViewController {
    protected View view;
    
    public ViewController() {
    }
    
    abstract public BiConsumer<Scene, View> selectMenu();
    
    public void run (Scene scene) {
        BiConsumer<Scene, View> action = selectMenu();
        if (action != null) {
            action.accept(scene, view);;
        }
    }
}
