package run;

import org.junit.jupiter.api.Test;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * test the application
 * @author : [86135]
 * @version : [v1.0]
 * @createTime : [2021/9/12 0:24]
 */

public class MyApplicationTest {
    @BeforeClass
    public static void beforeTest(){
        System.out.println("测试即将开始");
    }

    @AfterClass
    public static void afterTest(){
        System.out.println("测试结束");
    }

    /**
     * Test 1:test the empty txtFile
     */
    @Test
    public void testForEmpty(){
        try {
            MyApplication.process("test/orig.txt", "test/empty.txt", "test/ansAll.txt");

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * Test 2:The case where the entered comparison text path parameter is an incorrect parameter
     */
    @Test
    public void testForWrongOriginArgument(){
        try {
        MyApplication.process("test/123.txt","test/orig_0.8_add.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 3:Test 20% text addition: orig_0.8_add.txt
     */
    @Test
    public void testForAdd(){
    try {
            MyApplication.process("test/orig.txt","test/orig_0.8_add.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }
    }

    /**
     * Test 4:Test 20% text deletion: orig_0.8_del.txt
     */
    @Test
    public void testForDel(){
        try {
            MyApplication.process("test/orig.txt","test/orig_0.8_del.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 5:Test 20% out-of-order text: orig_0.8_dis_1.txt
     */
    @Test
    public void testForDis1(){
        try {
            MyApplication.process("test/orig.txt","test/orig_0.8_dis_1.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 6:Test 20% out-of-order text: orig_0.8_dis_10.txt
     */
    @Test
    public void testForDis10(){
        try {
            MyApplication.process("test/orig.txt","test/orig_0.8_dis_10.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 7:Test 20% out-of-order text: orig_0.8_dis_15.txt
     */

    @Test
    public void testForDis15(){
        try {
            MyApplication.process("test/orig.txt","test/orig_0.8_dis_15.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 8:Test the same text: orig.txt
     */
    @Test
    public void testForSame(){
        try {
            MyApplication.process("test/orig.txt","test/orig.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 9:Test 20% out-of-order text: orig_0.8_dis_3.txt
     */
    @Test
    public void testForDis3(){
        try {
            MyApplication.process("test/orig.txt","test/orig_0.8_dis_3.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 10:Test 20% out-of-order text: orig_0.8_dis_7.txt
     */
    @Test
    public void testForDis7(){
        try {
            MyApplication.process("test/orig.txt","test/orig_0.8_dis_7.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 11:Test 20% formatting disorder text: orig_0.8_mix.txt
     */
    @Test
    public void testForMix(){
        try {
            MyApplication.process("test/orig.txt","test/orig_0.8_mix.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 12 : Test delete the first paragraph  text: orig_del.txt
     */
    @Test
    public void testForDelTheFP(){
        try {
            MyApplication.process("test/orig.txt","test/orig_del.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test 13 : Test wrong character  text: orig_wrong_character.txt
     */
    @Test
    public void testForWrongCharacter(){
        try {
            MyApplication.process("test/orig.txt","test/orig_wrong_character.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *Test14: Test if the output file path parameter is an error parameter
     */
    @Test
    public void testForWrongOutputArgument(){
        try {
            MyApplication.process("test/orig.txt","test/orig.txt","test/testAWrongArgumentResult.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test15: A subset of test text text: orig_sub.txt
     */
    @Test
    public void testForSub1(){
        try {
            MyApplication.process("test/orig.txt","test/orig_sub_1.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Test16: Select the second and third paragraphs as tests
     */
    @Test
    public void testForSub2(){
        try {
            MyApplication.process("test/orig.txt","test/orig_sub_2.txt","test/ansAll.txt");
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


}

