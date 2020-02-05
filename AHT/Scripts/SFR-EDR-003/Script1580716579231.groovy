import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.openBrowser('')

WebUI.navigateToUrl('url in here')

WebUI.setText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_userId (6)'), 'ID')

WebUI.setEncryptedText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_password (6)'), 'passwrd=')

WebUI.click(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_btnLogin (5)'))

WebUI.click(findTestObject('Page_PC/a_EDR (6)'))

WebUI.switchToWindowTitle('내부자 위협행위 분석시스템')

//분석 - 일사용자 분석  window.location = "/main/rpt/dailyUserAnalysis.do";
WebUI.executeJavaScript('window.location = "/main/rpt/dailyUserAnalysis.do"', null)

//FIXME if you want to search another date than change date1
String date1 = '2020-01-20'

String cdate1 = ('$("div[id=date1]").val("' + date1) + '")'

WebUI.executeJavaScript(cdate1, null)

WebUI.click(findTestObject('Object Repository/Page_/button_ _btnSearch'))
WebUI.delay(4);

//FIXME have to change the number below to excel data or sth;
for(int i =0 ; i<=2; i++){
	
	String snum =WebUI.executeJavaScript("return document.querySelector('#row"+ i +"grid > div:nth-child(3)').title", null)
	String tnum = WebUI.executeJavaScript('return document.querySelector("#row'+ i +'grid > div:nth-child(4)").title', null)
	String upcount = WebUI.executeJavaScript('return document.querySelector("#row'+ i +'grid > div:nth-child(5)").title', null)
	
	println(snum as int)
	println(tnum as int)
	println(upcount as int)
	

	if( (snum as int) == 23001 || (snum as int) == 41681 || (snum as int) == 52378 ){
		continue;
	}
	else{
		response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
		WS.verifyResponseStatusCode(response, 201)
	}
		
	if( (tnum as int) == 67709 || (tnum as int) == 51376 || (tnum as int) == 50905 ){
		continue;
	}
	else{
		response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
		WS.verifyResponseStatusCode(response, 201)	
	}
	if( (upcount as int) == 36204 || (upcount as int) == 8902 || (upcount as int) == 35301 ){
		continue
	}
	else{
		response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
		WS.verifyResponseStatusCode(response, 201)
	}

}


WebUI.closeBrowser();