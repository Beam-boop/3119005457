package run;

/**
 * the main progress, the entrance
 * @author : [86135]
 * @version : [v1.0]
 * @createTime : [2021/9/7 19:46]
 */

public class MyApplication {
    public static void main(String[] args) throws InterruptedException {
        String  inputPath1= args[0];
        String  inputPath2= args[1];
        String  outputPath= args[2];

        String str1 = IOProcess.inputTxt(inputPath1);
        String str2 = IOProcess.inputTxt(inputPath2);

        if(str1.length() != 0 && str2.length() != 0) {
            MySimHash simHash0 = new MySimHash(str1, 256, 10);
            MySimHash simHash1 = new MySimHash(str2, 256, 10);
            double similarity = simHash0.getSemblance(simHash1.getSimHash());
            IOProcess.outputTxt(similarity, outputPath, inputPath1, inputPath2);
            System.out.println(similarity);
        } else{

                System.out.println("该文本不正常！");
            }
        }

    /**
     * Perform operations
     * @param input1 the origin text
     * @param input2 the modify text
     * @param output the result
     * @throws InterruptedException the empty text
     */
        public static void process(String input1, String input2, String output) throws InterruptedException {
            String inputPath1 = input1;
            String inputPath2 = input2;
            String outputPath = output;

            String str1 = IOProcess.inputTxt(inputPath1);
            String str2 = IOProcess.inputTxt(inputPath2);

            MySimHash simHash0 = new MySimHash(str1, 256, 10);
            MySimHash simHash1 = new MySimHash(str2, 256, 10);
            double similarity = simHash0.getSemblance(simHash1.getSimHash());
            IOProcess.outputTxt(similarity, outputPath, inputPath1, inputPath2);
            System.out.println("Rate of rechecking:  " + similarity + "\n");
        }
}
