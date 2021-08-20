package com.crawler.test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class htmlunit_test {
	//for github actions testing
	private static Path readmePath = Paths.get("README.md");
	
	
	public static void main(String[] args) throws IOException {
		String url = "https://www.magicaudiotools.com/";
		String product_name = "";
		HtmlPage EntrancePage = CrawlerUtils.getPage(url);
		//the hierarchy is //div/h3, then do filters on the div part, here the class within the div must contain the string 't_'
		List <HtmlElement> infoListEle = (List <HtmlElement>)  EntrancePage.getByXPath("//ul[@class='menu']/li/a");
		for (int i = 0; i < infoListEle.size(); i++) {
			product_name = infoListEle.get(i).getTextContent().trim();
			if (product_name.length()!= 0) {
				System.out.println("Product:" + product_name);
		        if (!Files.exists(readmePath)) {
		            Files.createFile(readmePath);
		        }
		        Files.write(readmePath, product_name.getBytes(), StandardOpenOption.APPEND);
			}
		}
	}
	

}