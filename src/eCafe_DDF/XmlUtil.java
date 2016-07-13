package eCafe_DDF;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.TestNG;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlUtil {
	
				public static void createXml() throws Exception{
					int elementcounter;
					try{
						// Create Object for Utility Class
						String xlFilePath="Switches\\Flags.xls";
						ExcelLib excel =new ExcelLib(xlFilePath);
						
						// initialization of Drivers
						DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
						DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
						Document document= documentBuilder.newDocument();
			
						// Get the Flagged Cells with value = "EXECUTE" & "On" from Excel file
						excel.getFlaggedMethods("Switch");
						excel.getFlaggedclass("Switch");
						excel.getFlaggedparameter("Switch");
						
						// Get the number of parameter to be created in XML
						int flaggedMethodCount = excel.flaggedMethod.size();
						int excelBrowserCount = excel.flaggedparameter.size();
						int flaggedClassCount = excel.flaggedClass.size();
						// Type the suite Tag Element in the XML file
						Element rootElementSuite=document.createElement("suite");
						document.appendChild(rootElementSuite);
						rootElementSuite.setAttribute("name", "SeleniumJavaFramework");
						
						// Type the parameter set of lines in the XML file
					for(int browserCounter=1; browserCounter<= excelBrowserCount; browserCounter++){
						// Type the root elements in the XML file
						Element rootElementTest=document.createElement("test");
						Element rootElementClass=document.createElement("classes");	
						Element rootElementParameter=document.createElement("parameter");		
						
						// Append values to the root elements
						rootElementSuite.appendChild(rootElementTest);		
						
						String[] browserflagElement=excel.flaggedparameter.get(browserCounter).toString().split("=");
						rootElementParameter.setAttribute("name", "browser");
						rootElementParameter.setAttribute("value", browserflagElement[0]);
						rootElementTest.setAttribute("name", browserflagElement[0]);
						rootElementTest.appendChild(rootElementParameter);
						rootElementParameter.appendChild(rootElementClass);	
						String element="include";			
						Element childElementClass=document.createElement("class");	
						Element rootElementgroups= document.createElement("methods");
						Element include = document.createElement(element);
						
						for(int elementclasscounter=1; elementclasscounter<= flaggedClassCount; elementclasscounter++){
							childElementClass=document.createElement("class");
							String flagclsElement=excel.flaggedClass.get(elementclasscounter).toString();
							childElementClass.setAttribute("name", flagclsElement);
							rootElementgroups= document.createElement("methods");
						
							for(elementcounter = 1; elementcounter <= flaggedMethodCount; elementcounter++){								
								String[] flagElement=excel.flaggedMethod.get(elementcounter).toString().split(":");
								include = document.createElement(element);					
								if(flagElement[0].toString().equals(flagclsElement))
								{
									include.setAttribute("name", flagElement[1]);
									rootElementgroups.appendChild(include);
								}
							}
							childElementClass.appendChild(rootElementgroups);
							rootElementClass.appendChild(childElementClass);
						}
					}
						// Generate the file.
						FileWriter fstream = new FileWriter("Switches\\testng.xml");
						BufferedWriter out = new BufferedWriter(fstream);
						
						// Generate the requried XML output file
						TransformerFactory transformerFactory = TransformerFactory.newInstance();
						Transformer transformer= transformerFactory.newTransformer();
						DOMSource source=new DOMSource(document);
						
						// Print all the Generated XML in the File Object
						StreamResult result=new StreamResult(fstream);
						transformer.transform(source, result);
						// Close the Generated file
						out.close();
					}catch(DOMException e){
						e.printStackTrace();
					}
				}
						public static void autoRunXml(){
							// Create a list
							List<String> files = new ArrayList<String>();
							// Add the required xml files to the list
							files.add("Switches\\testng.xml");
							// Create object for TestNG
							TestNG tng=new TestNG();
							// Add the list of the file to create a suite
							tng.setTestSuites(files);
							// Run the Suite
							tng.run();
						}
}