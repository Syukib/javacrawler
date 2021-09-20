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
	
	//3, Red Oak Software
        Publisher = "Red Oak Software";
        url = "http://www.redoaksw.com/products/";
        xPath = "//table[@class='LayoutTable']/tbody/tr/td/h5";
        go (url, Publisher, xPath);
        
        //4, Recool Studio
        Publisher = "Recool Studio";
        url = "http://www.swf-video.com/download.htm";
        xPath = "//tr[@class='order_pad']/td[1]/a";
        go (url, Publisher, xPath);
        
        //5, Probit Software
        Publisher = "Probit Software";
        url = "http://www.probitsoftware.com/products.php";
        xPath = "//div[contains(@class,'t_')]/h3";
        go (url, Publisher, xPath);
        
        //6, Newera Software Technology
        Publisher = "Newera Software Technology";
        url = "http://www.iconcool.com/products.htm";
        xPath = "//div[@class='box_con arrow']/ul/li";
        go (url, Publisher, xPath);
        
        //7, Michael Bauer Software 
        Publisher = "Michael Bauer Software";
        url = "http://www.vboffice.net/en/products";
        xPath = "//div[@class='content']/table/tbody/tr/td[2]";
        go (url, Publisher, xPath);
        
        //8, Metaware
        Publisher = "Metaware";
        url = "http://www.metaware.fr/products.html";
        xPath = "//ul[@class='nav nav-list primary push-bottom active-class-nav']/li/a";
        go (url, Publisher, xPath);
        
        //9, PrivacyAnywhere Software
        Publisher = "PrivacyAnywhere Software";
        url = "http://www.privacyanywhere.com/downloads/";
        xPath = "//a[contains(@class,'Blue')]/b";
        go (url, Publisher, xPath);
        
        //10, Xilisoft Corporation
        Publisher = "Xilisoft Corporation";
        url = "http://www.xilisoft.com/products-all.html";
        xPath = "//div[@id='sub-product-all-wraper']/div/div/div/div/p/a";
        go (url, Publisher, xPath);

	}//main end

}
