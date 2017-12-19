//package WDFactory;
//
//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.testng.ITestResult;
//import org.testng.Reporter;
//import org.testng.TestListenerAdapter;
//
//import java.io.File;
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//
///**Confirurations in POM file under surefire plugin
// *  <configuration>
//        <properties>
//            <property>
//                <name>listener</name>
//                <value>net.cloudapp.automation.utils.ScreenshotMaker</value>
//            </property>
//        </properties>
//    </configuration>
// */
//
///**
// * Created by pavlo.balyuk on 12/19/2017.
// */
//public class ScreenshotMaker extends TestListenerAdapter {
//    @Override
//    public void onTestFailure(ITestResult result){
//        super.onTestFailure(result);
//
//        Calendar calendar = Calendar.getInstance();
//        SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
//        String methodName = result.getName();
//        if (!result.isSuccess()){
//            File scrFile = null;
////                scrFile = ((TakesScreenshot) Browser.getDriver()).getScreenshotAs(OutputType.FILE);
//            try {
//                String scrPath = "/failure_screenshots/"+methodName+" "+formater.format(calendar.getTime())+".png";
//                File fileOutput = new File("target"+scrPath);
//                FileUtils.copyFile(scrFile, fileOutput);
//                Reporter.log("< a href='.."+scrPath+"'"+"> <img scr='.."+scrPath +"'"+ " height='100' width='100' />screenshot </a>");
//            } catch (IOException e1){
//                e1.printStackTrace();
//            }
//        }
//    }
//}
