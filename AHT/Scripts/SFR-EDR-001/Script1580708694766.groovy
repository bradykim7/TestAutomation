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


WebUI.setText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_userId (4)'), 'ID')

WebUI.setEncryptedText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_password (4)'), 'passwrd=')

WebUI.click(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_btnLogin (4)'))

WebUI.click(findTestObject('Object Repository/Page_PC/a_EDR (1)'))

WebUI.switchToWindowTitle('내부자 위협행위 분석시스템')
WebUI.executeJavaScript('Master.gotoLayoutPage("BA7D49AA-9353-4A7C-9C9F-9681A43EA0C5","NONE")',null)



WebUI.click(findTestObject('Object Repository/Page_/rect_Created with Highcharts 602_highcharts-point highcharts-color-0 highcharts-point-hover'))
// *[contains(@id,"highcharts")]/svg/g[6]/g[1]/rect[1]


String date1 ='2020-01-20 00:00'
String date2 ='2020-01-20 23:59'

//completed date String
String cdate1 ='$("div[id=date1]").val("' + date1 +'")'
String cdate2 ='$("div[id=date2]").val("'+ date2 +'")'

// 날짜 입력창 1
WebUI.executeJavaScript(cdate1,null)
// 날짜 입력창 2
WebUI.executeJavaScript(cdate2,null)


WebUI.click(findTestObject('Object Repository/Page_/input_ _inputp_date1'))

WebUI.click(findTestObject('Object Repository/Page_/input__inputp_date2'))

WebUI.click(findTestObject('Object Repository/Page_/button__p_btnSearch'))

WebUI.click(findTestObject('Object Repository/Page_/rect_Created with Highcharts 602_highcharts_220f1f_1'))

WebUI.click(findTestObject('Object Repository/Page_/div_36800'))

