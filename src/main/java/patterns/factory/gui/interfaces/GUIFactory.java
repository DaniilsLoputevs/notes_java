package patterns.factory.gui.interfaces;

import lombok.Getter;

public interface GUIFactory {
    GUIButton createButton();
    
    GUICheckbox createCheckbox();
    
    /* Factory part */
    String generatedUIElementId();
    
    Statistics getStatistics();
    
//    List<Class<?>> supportComponents();
    
    class Statistics {
        @Getter private long buttonCreated;
        @Getter private long checkboxCreated;
        
        public void buttonCreatedIncrement() {
            this.buttonCreated++;
        }
        
        public void checkboxCreatedIncrement() {
            this.checkboxCreated++;
        }
        
        public Statistics copy() {
            var rsl = new Statistics();
            rsl.buttonCreated = this.buttonCreated;
            rsl.checkboxCreated = this.checkboxCreated;
            return rsl;
        }
    }
}




