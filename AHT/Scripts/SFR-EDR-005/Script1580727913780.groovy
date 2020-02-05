import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

//FIXME have to add number demand number 3

// 페이지 접근을 위한 기본 과정 
try{
WebUI.openBrowser('')

WebUI.navigateToUrl('url in here')

WebUI.setText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_userId (1)'), 'ID')

WebUI.setEncryptedText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_password (1)'), 'passwrd=')

WebUI.click(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_btnLogin (1)'))
}catch(e){
	response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
	WS.verifyResponseStatusCode(response, 201);
	
}
// EDR Click 
WebUI.click(findTestObject('Page_PC/a_EDR (1)'))

WebUI.switchToWindowTitle('내부자 위협행위 분석시스템')


//WebUI.delay(6);
//WebUI.switchToWindowTitle('내부자 위협행위 분석시스템')

// 대응 
// 이벤트 분석 
WebUI.executeJavaScript('window.location = "/main/rpt/groupRpt.do"', null)
// 사용자 설정 
WebUI.click(findTestObject('Object Repository/Page_/div_24_jqx-icon-arrow-down jqx-icon-arrow-d_c060eb'))

WebUI.click(findTestObject('Object Repository/Page_/span_ (1)'))

// 사용자 조회를 위한 날짜 설정 
String date1 ='2020-01-20 00:00'
String date2 ='2020-01-20 23:59'

//completed date String
String cdate1 ='$("div[id=date1]").val("' + date1 +'")'
String cdate2 ='$("div[id=date2]").val("'+ date2 +'")'

//WebUI.mouseOver(findTestObject('Object Repository/Page_/rect'), 'font-size')
//WebUI.executeJavaScript("document.getElementsByClassName('class='jqx-chart-tooltip-text'')",null)


// 날짜 입력창 1 ,입력창2
WebUI.executeJavaScript(cdate1,null)
WebUI.executeJavaScript(cdate2,null)
// 조회
WebUI.click(findTestObject('Object Repository/Page_/button__btnSearch (1)'));

WebUI.delay(3);

// 전체 이벤트 건수 this case :438275
int total1 = (WebUI.executeJavaScript("return document.querySelector('#row0groupPolicyGrid > div:nth-child(2)').getAttribute('title')",null) as int);
WebUI.click(findTestObject('Object Repository/Page_/div_ (3)'))
WebUI.delay(3);

// amount of total events : result "1-55 of 55"
String totalevnt = WebUI.executeJavaScript('return document.querySelector("#pagerdevPolicyGrid > div > div:nth-child(6)").innerText',null)
int length = (totalevnt.split(' ')[2]) as int;

int total2=0;
//String pp = WebUI.executeJavaScript("return document.querySelector('#row14devPolicyGrid > div:nth-child(5)').title",null)
//print(pp);

for(int i =0;i<=10;i++){
	String exc1 = "return document.querySelector('#row"+ i +"devPolicyGrid > div:nth-child(5)').title"
	String a = WebUI.executeJavaScript(exc1,null)
	if(a =="") 
		break;
	else{
		int b = (a) as int
		total2 += b;
	}
}

if (total1 != total2){
	response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
	
	WS.verifyResponseStatusCode(response, 201);
}


WebUI.delay(20)

WebUI.closeBrowser();
// document.getElementsByClassName('jqx-chart-tooltip-text')[1].innerText >> 꼭지점의 상중하 값 
// WS.verifyResponseStatusCode(response, 201);
