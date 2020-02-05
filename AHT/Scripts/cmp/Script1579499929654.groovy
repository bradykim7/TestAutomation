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

// 페이지 접근을 위한 기본 과정 
WebUI.openBrowser('')

WebUI.navigateToUrl('url in here/')

WebUI.setText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_userId (1)'), 'ID')

WebUI.setEncryptedText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_password (1)'), 'passwd=')

WebUI.click(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_btnLogin (1)'))

// EDR Click 
WebUI.click(findTestObject('Page_PC/a_EDR (1)'))

//WebUI.switchToWindowTitle('내부자 위협행위 분석시스템')

// 대응 
WebUI.click(findTestObject('Object Repository/Page_/a_ (1)'))
// 이벤트 분석 
WebUI.click(findTestObject('Object Repository/Page_/a__1 (1)'))
// 사용자 설정 
WebUI.click(findTestObject('Object Repository/Page_/div_24_jqx-icon-arrow-down jqx-icon-arrow-d_c060eb'))

WebUI.click(findTestObject('Object Repository/Page_/span_ (1)'))

// 사용자 조회를 위한 날짜 설정 
String date1 ='2020-01-01 12:00'
String date2 ='2020-01-02 12:00'

//completed date String
String cdate1 ='$("div[id=date1]").val("' + date1 +'")'
String cdate2 ='$("div[id=date2]").val("'+ date2 +'")'

// 날짜 입력창 1
WebUI.executeJavaScript(cdate1,null)
// 날짜 입력창 2
WebUI.executeJavaScript(cdate2,null)

WebUI.click(findTestObject('Object Repository/Page_/button__btnSearch (1)'))

// 원하는 데이터의 날짜. 
String cmpdata = '2020-01-01 13:00'
WebUI.delay(2)
// 전체 데이터 시트 가져오기 
int dataArrayLength1 = WebUI.executeJavaScript('return unitData.length',null)

// 특정 날짜의 데이터 가져오기 
int evtLevel1, evtLevel2, evtLevel3, k ;
for(int i = 0; i< dataArrayLength1-1;i++){
	String datac = WebUI.executeJavaScript('return (unitData)['+i+']',null)
	if(datac.contains(cmpdata)){
		k=i;
		println(datac)
		break;
	}
}
// 하 
evtLevel1 = WebUI.executeJavaScript('return (unitData)['+k+'].evtLevel1',null)
// 중 
evtLevel2 = WebUI.executeJavaScript('return (unitData)['+k+'].evtLevel2',null)
// 상 
evtLevel3 = WebUI.executeJavaScript('return (unitData)['+k+'].evtLevel3',null)

WebUI.delay(10)


// 새로운 임의의 날짜 설정. 아래의 날짜를 Excel data로 입력하여 반복 수행 
// 사용자 조회를 위한 날짜 설정
String date3 ='2020-01-01 12:00'
String date4 ='2020-01-04 12:00'

//completed date String
String cdate3 ='$("div[id=date1]").val("'+ date3 +'")'
String cdate4 ='$("div[id=date2]").val("'+ date4 +'")'

// 날짜 입력창 3
WebUI.executeJavaScript(cdate3,null)
// 날짜 입력창 4
WebUI.executeJavaScript(cdate4,null)

WebUI.click(findTestObject('Object Repository/Page_/button__btnSearch (1)'))
WebUI.delay(2)

int dataArrayLength2 = WebUI.executeJavaScript('return unitData.length',null)

// 특정 날짜의 데이터 가져오기
int evtLevel11, evtLevel22, evtLevel33, kk ;
for(int i = 0; i< dataArrayLength2-1;i++){
	String datac = WebUI.executeJavaScript('return (unitData)['+i+']',null)
	if(datac.contains(cmpdata)){
		kk=i;
		println(datac)
		break;
	}
}
// 하
evtLevel11 = WebUI.executeJavaScript('return (unitData)['+kk+'].evtLevel1',null)
println(evtLevel11)
// 중
evtLevel22 = WebUI.executeJavaScript('return (unitData)['+kk+'].evtLevel2',null)
// 상
evtLevel33 = WebUI.executeJavaScript('return (unitData)['+kk+'].evtLevel3',null)

if(evtLevel1 != evtLevel11){
	KeywordUtil.markError("EvtLeve1 data Mismatching Err")
	response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
	
	WS.verifyResponseStatusCode(response, 201);
}
if(evtLevel2 != evtLevel22){
	KeywordUtil.markError("EvtLeve2 data Mismatching Err")
	response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
	
	WS.verifyResponseStatusCode(response, 201);
}
if(evtLevel3 != evtLevel33){
	KeywordUtil.markError("EvtLeve3 data Mismatching Err")
	response = WS.sendRequest(findTestObject('Object Repository/createIssue'))
	
	WS.verifyResponseStatusCode(response, 201);
}

WebUI.closeBrowser();