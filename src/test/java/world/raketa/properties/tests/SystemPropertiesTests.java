package world.raketa.properties.tests;


import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;



public class SystemPropertiesTests {
    @Test
    @Tag("properties")
    void systemPropertiesTest() {
       // System.setProperty("browser","chrome");
        String browser = System.getProperty("browser","mozilla");
        System.out.println("jhgjhgjhgjgjhgjgjhgjhg ==="+browser);
    }
}
// gradle clean property_test
//gradle property_test --info
//gradle clean property_test -Dbrowser=opera
