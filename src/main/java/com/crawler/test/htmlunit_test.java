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
        
	private static void write (String Publisher, String Product, String Version, String Build) throws IOException {
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, Publisher.getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, ",".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, Product.getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, ",".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, Version.getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, ",".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, Build.getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\n".getBytes(), StandardOpenOption.APPEND);
	};
	
	private static void go (String url, String Publisher, String xPath) {
        HtmlPage EntrancePage = CrawlerUtils.getPage(url);
		List <HtmlElement> infoListEle = (List <HtmlElement>)  EntrancePage.getByXPath(xPath);
		for (int i = 0; i < infoListEle.size(); i++) {
			String Product = infoListEle.get(i).getTextContent();
			System.out.println("Publisher: "+ Publisher + " | " + "Product: " + Product);
			try {
				write (Publisher, Product, "", "");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private static Path product_result_data = Paths.get("product_result_data.csv");
	
	public static void main(String[] args) throws IOException {
		String url = "";
		String Publisher = "";
		String Product = "";
		String Version = "";
		String Build = "";
		String xPath = "";
		
        if (Files.exists(product_result_data)) {
        	Files.delete (product_result_data);
            Files.createFile(product_result_data);
        }
        
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "Publisher".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, ",".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "Product".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, ",".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "Version".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, ",".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "Build".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\"".getBytes(), StandardOpenOption.APPEND);
        Files.write(product_result_data, "\n".getBytes(), StandardOpenOption.APPEND);
        
        //1, Thomson Software Solutions
        Publisher = "Thomson Software Solutions";
        url = "http://www.thomson-software-solutions.com/software-list/";
        xPath = "//div[@class='fl-rich-text']/h2";
        go (url, Publisher, xPath);
        
		//2, SBK Softwareb¨¹ro Kasparek
        Publisher = "SBK Softwareb¨¹ro Kasparek";
        url = "http://www.sbk-software.de/";
        xPath = "//table[@id='menu']/tbody/tr/td/a";
        go (url, Publisher, xPath);
        
	}//main end

}
