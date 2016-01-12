package tw.homework;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;

/**
 * Created by Leeya on 15/12/26.
 */
public class MainTest {

    private NumberGenerator numberGenerator;

    @Before
    public void setUp() throws Exception {
        numberGenerator = new NumberGenerator();
    }

    @Test
    public  void shou_have_four(){
        String number = numberGenerator.generate();
        assertEquals(number.length(),4);
    }

    @Test
    public void should_be_digital(){
        String numbers = numberGenerator.generate();
        assertEquals(numbers.matches("\\d+"),true);
    }

    @Test
    public void should_be_unReapt(){
        String numbers = numberGenerator.generate();
        assertEquals(isRepeat(numbers),true);

    }
    private boolean isRepeat(String numbers){
        for(int i = 0;i < numbers.length();i++){
            if (numbers.substring(i +1 ,numbers.length()).indexOf(numbers.charAt(i))>-1){
                return false;
            }
        }
        return  true;
    }

    @Test
    public  void  is_random(){
        assertEquals(isRandom(),true);
    }

    private  boolean isRandom(){
        String number1 = numberGenerator.generate();
        String number2 = numberGenerator.generate();
        if (number1 == number2){
            return false;
        }
        return true;

    }

    @Test
    public void input_9876_expect_9876_is_4A0B(){
       assertEquals("4A0B",numberGenerator.compare("9876","9876"));
    }

    @Test
    public  void input_9876_except_6789_is_0A4B(){
        assertEquals("0A4B",numberGenerator.compare("9876","6789"));
    }

    @Test
    public  void input_9876_except_9274_is_2A0B(){
        assertEquals("2A0B",numberGenerator.compare("9876","9274"));
    }

    @Test
    public  void input_9876_except_2497_is_0A2B(){
        assertEquals("0A2B",numberGenerator.compare("9876","2497"));
    }

    @Test
    public  void input_9876_except_1234_is_0A0B(){
        assertEquals("0A0B",numberGenerator.compare("9876","1234"));
    }

    @Test
    public  void input_9876_except_9867_is_2A2B(){
        assertEquals("2A2B",numberGenerator.compare("9876","9867"));
    }





}
