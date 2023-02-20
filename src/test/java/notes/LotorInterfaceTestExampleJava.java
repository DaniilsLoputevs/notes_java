package notes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// https://stackoverflow.com/questions/55437810/how-to-test-different-implementations-for-an-interface-in-junit5-without-duplica/75509872#75509872
@Deprecated // hide from eyes
public class LotorInterfaceTestExampleJava {
    
    // ======================
    
    public interface StringDiagnose {
        /**
         * Contract: a string is blank iff it consists of whitespace chars only
         */
        boolean isTheStringBlank(String string);
    }
    
    public static class DefaultDiagnose implements StringDiagnose {
        
        @Override
        public boolean isTheStringBlank(String string) {
            return string.trim().length() == 0;
        }
    }
    
    public static class StreamBasedDiagnose implements StringDiagnose {
        
        @Override
        public boolean isTheStringBlank(String string) {
            return string.chars().allMatch(Character::isWhitespace);
        }
    }
    
    // ======================
    public interface StringDiagnoseTest<T extends StringDiagnose> {
        
        T createDiagnose();
        
        @Test
        default void blankCheckFollowsContract() {
            assertTrue(createDiagnose().isTheStringBlank("\t\n "));
            assertFalse(createDiagnose().isTheStringBlank("\t\n !  \r\n"));
        }
        
        class DefaultDiagnoseTest implements StringDiagnoseTest<DefaultDiagnose> {
            
            @Override
            public DefaultDiagnose createDiagnose() {
                return new DefaultDiagnose();
            }
        }
        
        class StreamBasedDiagnoseTest implements StringDiagnoseTest<StreamBasedDiagnose> {
            
            @Override
            public StreamBasedDiagnose createDiagnose() {
                return new StreamBasedDiagnose();
            }
        }
    }
    
}
