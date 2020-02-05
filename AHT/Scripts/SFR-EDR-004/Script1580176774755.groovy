import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
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

//FIXME have to add number demand number 3

// 페이지 접근을 위한 기본 과정 
WebUI.openBrowser('')

WebUI.navigateToUrl('url in here')

WebUI.setText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_userId (1)'), 'ID')

WebUI.setEncryptedText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_password (1)'), 'passwrd=')

WebUI.click(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_btnLogin (1)'))

// EDR Click 
WebUI.click(findTestObject('Page_PC/a_EDR (1)'))
WebUI.switchToWindowTitle('내부자 위협행위 분석시스템')

// 대응 이벤트통계 /main/rpt/unitEventRpt.do
WebUI.executeJavaScript('window.location = "/main/rpt/unitEventRpt.do"', null)
// 사용자 설정 
WebUI.click(findTestObject('Object Repository/Page_/div_24_jqx-icon-arrow-down jqx-icon-arrow-d_c060eb'))

WebUI.click(findTestObject('Object Repository/Page_/span_ (1)'))

// 사용자 조회를 위한 날짜 설정 
String date1 ='2020-01-20 00:00'
String date2 ='2020-01-20 23:59'

//completed date String
String cdate1 ='$("div[id=date1]").val("' + date1 +'")'
String cdate2 ='$("div[id=date2]").val("'+ date2 +'")'

// 날짜 입력창 1
WebUI.executeJavaScript(cdate1,null)
// 날짜 입력창 2
WebUI.executeJavaScript(cdate2,null)

WebUI.click(findTestObject('Object Repository/Page_/button__btnSearch (1)'))


WebUI.delay(2)
// 전체 데이터 시트 가져오기 
int dataArrayLength1 = WebUI.executeJavaScript('return unitData.length',null)

// 특정 날짜의 데이터 가져오기 
int evtLevel1, evtLevel2, evtLevel3, unitCount ;
for(int i = 0; i< dataArrayLength1-1;i++){
	String datac = WebUI.executeJavaScript('return (unitData)['+i+']',null)
	
	evtLevel1 = WebUI.executeJavaScript('return (unitData)['+i+'].evtLevel1',null)
	evtLevel2 = WebUI.executeJavaScript('return (unitData)['+i+'].evtLevel2',null)
	evtLevel3 = WebUI.executeJavaScript('return (unitData)['+i+'].evtLevel3',null)
	unitCount = WebUI.executeJavaScript('return (unitData)['+i+'].unitCount',null)
	
	if(unitCount != evtLevel1+evtLevel2+evtLevel3 ){
		KeywordUtil.markError("UnitData data Mismatching evtLevel1+evtLevel2+evtLevel3 Err")
		response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
		
		WS.verifyResponseStatusCode(response, 201);
	}
	else
		continue;
		
}
WebUI.delay(20)

WebUI.closeBrowser();
//document.getElementsByClassName('jqx-chart-tooltip-text')[1].innerText >> 꼭지점의 상중하 값 

