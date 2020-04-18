package com.apple.weblinks;


import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.NicelyResynchronizingAjaxController;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomNode;
import com.gargoylesoftware.htmlunit.html.DomNodeList;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;


public class AppleController {

	public static void main(String[] args) throws Exception {
		openAppleSite();
	}
	

	public static  void openAppleSite() throws Exception {
		WebClient webClient = getWebClient();
		HtmlPage page = webClient.getPage("https://www.apple.com/mac/");
		HtmlElement element = (HtmlElement) page.getByXPath("//*[@id=\"chapternav\"]/div").get(0);
		DomNodeList<DomNode> nodes = element.querySelectorAll("span");
	    for(DomNode a : nodes) {
	    	System.out.println(a.getFirstChild());
	    }
	}

	public static WebClient getWebClient() {
		WebClient webClient = new WebClient(BrowserVersion.CHROME);
		webClient.getOptions().setThrowExceptionOnFailingStatusCode(false);
		webClient.getOptions().setThrowExceptionOnScriptError(false);
		webClient.getOptions().setCssEnabled(false);
		webClient.getOptions().setUseInsecureSSL(true);
		webClient.getOptions().setJavaScriptEnabled(false);
		webClient.getOptions().setTimeout(150000);
		webClient.setAjaxController(new NicelyResynchronizingAjaxController());
		return webClient;
	}
}
