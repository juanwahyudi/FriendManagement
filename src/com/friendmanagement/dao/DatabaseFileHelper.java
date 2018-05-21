package com.friendmanagement.dao;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class DatabaseFileHelper {
	public DatabaseConfigModel ReadDatabaseConfigFile(String dbName) throws Exception {
		DatabaseConfigModel databaseConfigModel = new DatabaseConfigModel();
		InputStream inputStream = this.getClass().getClassLoader()
				.getResourceAsStream("/com/friendmanagement/dao/databaseconfig.xml");
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.parse(inputStream);

			NodeList nodeList = document.getDocumentElement().getChildNodes();
			for (int i = 0; i < nodeList.getLength(); i++) {
				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {
					org.w3c.dom.Element element = (org.w3c.dom.Element) node;

					String databaseId = node.getAttributes().getNamedItem("id").getNodeValue();
					if (databaseId.equals(dbName)) {
						databaseConfigModel.setDatabaseConnectionUrl(
								element.getElementsByTagName("url").item(0).getChildNodes().item(0).getNodeValue());
						databaseConfigModel.setDatabaseDriverName(
								element.getElementsByTagName("driver").item(0).getChildNodes().item(0).getNodeValue());
						databaseConfigModel.setDatabaseUser(
								element.getElementsByTagName("user").item(0).getChildNodes().item(0).getNodeValue());
						databaseConfigModel.setDatabasePassword(element.getElementsByTagName("password").item(0)
								.getChildNodes().item(0).getNodeValue());
					}
				}
			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage());
		} catch (SAXException | IOException e) {
			// TODO Auto-generated catch block
			throw new Exception(e.getMessage());
		}
		return databaseConfigModel;
	}
}
