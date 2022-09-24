package QALesson;
import org.junit.jupiter.api.*;


public class OneTest {

    // запускается 1 раз перед всеми тестами в данном классе (должен быть статический)
    @BeforeAll
    public static void beForeAll() {
        System.out.println("BeforeAll");
    }

    //запускается перед каждым тестом в данном классе
    @BeforeEach
    public void beforeEach() {
        System.out.println("beforeEach");
    }

    //запускается после каждого теста в данном классе
    @AfterEach
    public void afterEach() {
        System.out.println("afterEach");
    }

    // запускается 1 раз после всех тестоы в данном классе (должен быть статический)
    @AfterAll
    public static void afterAll() {
        System.out.println("afterAll");
    }

    @Test
    public void testOne() {
        Assertions.assertTrue(3 > 2);
    }
}
