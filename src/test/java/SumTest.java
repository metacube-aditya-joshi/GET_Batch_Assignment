package test.java;

import org.junit.jupiter.api.Test;

import main.java.App;

public class SumTest {
   @Test
   void test(){
    App app = new App();
    assertEquals(10,app.sum(9,10));
   }
}
