import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.exception.StepErrorException
import com.kms.katalon.core.exception.StepFailedException
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI

// 페이지 접근을 위한 기본 과정
WebUI.openBrowser('')

// login Process
try {
    WebUI.navigateToUrl('url in here')
	
	WebUI.setText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_userId (1)'), 'ID')
	
	WebUI.setEncryptedText(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_password (1)'), 'passwrd=')
	
	WebUI.click(findTestObject('Page_PC/input_Copyright  2020 All rights reserved_btnLogin (1)'))
}
catch (StepFailedException sfe) {
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)
	} 
catch(StepErrorException see){
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)}
catch(Exception e ){
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)
}

// Entering System Process
try{
	// EDR Click
	WebUI.click(findTestObject('Page_PC/a_EDR (1)'))
	
	WebUI.switchToWindowTitle('내부자 위협행위 분석시스템')
	
	// 사용자 대시보드
	WebUI.executeJavaScript('Master.gotoLayoutPage("BA7D49AA-9353-4A7C-9C9F-9681A43EA0C5","NONE")', null)
	
	WebUI.delay(2)
}
catch (StepFailedException sfe) {
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)
	} 
catch(StepErrorException see){
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)}
catch(Exception e ){
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)
}


//RED
String red = WebUI.executeJavaScript('return document.querySelector("#pcaErrCntViewzone3 > div > div.errCircle > ul > li:nth-child(1) > span").textContent', 
    null)

WebUI.executeJavaScript('document.querySelector("#pcaErrCntViewzone3 > div > div.errCircle > ul > li:nth-child(1) > span").click()', null);
//WebUI.click(findTestObject('Object Repository/Page_/span_50'))

String rTotal = WebUI.getText(findTestObject('Object Repository/Page_/div_1-50 of 50'))

//WebUI.executeJavaScript('return document.querySelector("#pagerpEvtStatusGrid > div > div:nth-child(6)").innerText', null);
WebUI.click(findTestObject('Object Repository/Page_/div_()   _jqx-window-close-button jqx-icon-close jqx-window-close-button-hover'))

WebUI.getText(findTestObject('Object Repository/Page_/div_1-50 of 50'))

String[] a = rTotal.split(' ')

if ((a[2]) != red) {
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)
}

// YELLOW
String yellow = WebUI.executeJavaScript('return document.querySelector("#pcaErrCntViewzone3 > div > div.errCircle > ul > li:nth-child(2) > span").textContent', 
    null)

WebUI.click(findTestObject('Object Repository/Page_/span_0'))

String yTotal = WebUI.getText(findTestObject('Object Repository/Page_/div_0-0 of 0'))

WebUI.click(findTestObject('Object Repository/Page_/div_()   _jqx-window-close-button jqx-icon-close jqx-window-close-button-hover'))

a = yTotal.split(' ')

if ((a[2]) != yellow) {
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)
}

// GREEN
String green = WebUI.executeJavaScript('return document.querySelector("#pcaErrCntViewzone3 > div > div.errCircle > ul > li:nth-child(3) > span").textContent', 
    null)

WebUI.click(findTestObject('Object Repository/Page_/span_48'))

String gTotal = WebUI.getText(findTestObject('Object Repository/Page_/div_1-48 of 48'))

WebUI.click(findTestObject('Object Repository/Page_/div_()   _jqx-window-close-button jqx-icon-close jqx-window-close-button-hover'))

a = rTotal.split(' ')

if ((a[2]) != green) {
    response = WS.sendRequest(findTestObject('Object Repository/SFR_EDR_002_ERR'))

    WS.verifyResponseStatusCode(response, 201)
}

WebUI.closeBrowser()

