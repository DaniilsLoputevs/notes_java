package patterns.factory.gui;

import patterns.factory.gui.interfaces.GUIButton;
import patterns.factory.gui.interfaces.GUICheckbox;
import patterns.factory.gui.interfaces.GUIFactory;

import java.util.concurrent.atomic.AtomicLong;
import java.util.function.Consumer;

public class MacGUIFactory implements GUIFactory {
    private final AtomicLong serialUIId = new AtomicLong(0);
    private final Statistics statistics = new Statistics();
    
    @Override public GUIButton createButton() {
        var rsl = new MacButton(this.generatedUIElementId());
        rsl.setLabel("new Mac Button");
        statistics.buttonCreatedIncrement();
        return rsl;
    }
    
    @Override public GUICheckbox createCheckbox() {
        var rsl = new MacCheckbox();
        rsl.setLabel("new Mac Checkbox");
        statistics.checkboxCreatedIncrement();
        return rsl;
    }
    
    @Override public String generatedUIElementId() {
        return "" + serialUIId.getAndIncrement();
    }
    
    @Override public Statistics getStatistics() {
        return this.statistics.copy();
    }
}

class MacButton implements GUIButton {
    private final String UIElementId;
    private String label;
    private Consumer<GUIButton> onClick;
    
    MacButton(String UIElementId) {this.UIElementId = UIElementId;}
    
    @Override public String getUIElementId() {
        return UIElementId;
    }
    
    @Override public void setLabel(String label) {
        this.label = label;
    }
    
    @Override public String getLabel() {
        return this.label;
    }
    
    @Override public void setOnClick(Consumer<GUIButton> onClick) {
        this.onClick = onClick;
    }
    
    @Override public void click() {
        onClick.accept(this);
    }
}

class MacCheckbox implements GUICheckbox {
    private String label;
    private boolean checked;
    
    @Override public void setLabel(String label) {
        this.label = label;
    }
    
    @Override public String getLabel() {
        return this.label;
    }
    
    @Override public void setChecked(boolean checked) {
        this.checked = checked;
    }
    
    @Override public boolean isChecked() {
        return checked;
    }
}