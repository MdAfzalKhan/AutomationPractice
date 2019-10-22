package com.ap.ui.util;

import java.util.ArrayList;
import java.util.List;

import com.ap.datamodel.ProductData;

public class DataBuilder {
	
	public List<ProductData> prepareProductData(){
		List<ProductData> productsData = new ArrayList<ProductData>();
		Read_XLS read = new Read_XLS("ProductData.xlsx","/src/main/java/com/ap/ui/testdata");
		Object [][] objs = new Object[read.retrieveNoOfRows("Sheet1") -1][read.retrieveNoOfCol("Sheet1")];
		objs = read.retrieveTestData1("Sheet1");
		for (Object [] obj : objs) {
			ProductData productData = new ProductData();
			productData.setProductName(obj[0].toString());
			productData.setQuantity(obj[1].toString());
			productData.setSize(obj[2].toString());
			productData.setColor(obj[3].toString());
			
		}
		return productsData;
	}
	

}
