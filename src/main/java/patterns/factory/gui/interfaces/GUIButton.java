package patterns.factory.gui.interfaces;

import java.util.function.Consumer;

public interface GUIButton {
    String getUIElementId();
    void setLabel(String label);
    String getLabel();
    void setOnClick(Consumer<GUIButton> onClick);
    
    void click();
}
