package run;
import java.io.*;

/**
 * Input and Output process
 * @author : [86135]
 * @version : [v1.0]
 * @createTime : [2021/9/7 20:07]
 */

public class IoProcess {
    /**
     * read txt folder, and change them into String
     * @param txtPath The absolute path to the folder
     * @return str String, the content of folder
     */
    public static String inputTxt(String txtPath){
        String str = "";
        String strLine;
        File file = new File(txtPath);
        if(!file.exists()){
            System.out.println(txtPath + "  This file does not exist !");
            return "";
        }
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            //join str together
            while((strLine = bufferedReader.readLine())!=null){
                str +=strLine;
            }
            if(str.length() == 0){
                System.out.println(txtPath+" 为空文本");
            }
            inputStreamReader.close();
            bufferedReader.close();
            fileInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    /**
     * put the result to the appointed folder
     * @param result the similarity
     * @param txtPath the outputPath
     * @param inputPath1 the origin inputPath
     * @param inputPath2 the derivative inputPath
     */
    public static void outputTxt(double result, String txtPath, String inputPath1, String inputPath2){
        String str = Double.toString(result);
        File file = new File(txtPath);
        if(!file.exists()){
            System.out.println(txtPath + "该路径不存在，请检查参数！");
            return;
        }
        FileWriter fileWriter = null;
        String separator = "/|\\\\";
        String[] input1 = inputPath1.split(separator);
        String[] input2 = inputPath2.split(separator);
        try {
            fileWriter = new FileWriter(file, true);
            fileWriter.write("The origin paper: " + input1[input1.length-1]);
            fileWriter.write("\n");
            fileWriter.write("The derivative paper:  " + input2[input2.length-1]);
            fileWriter.write("\n");
            fileWriter.write("Rate of rechecking:  " + str);
            fileWriter.write("\n");
            fileWriter.write("\n");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
