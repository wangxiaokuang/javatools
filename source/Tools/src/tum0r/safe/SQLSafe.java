package tum0r.safe;

import java.io.IOException;
import java.io.StringReader;
import java.util.Iterator;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import net.sf.json.JSONObject;
import tum0r.error.FileTypeException;
import tum0r.file.TextFile;
import tum0r.misc.ToolsConfig;

public class SQLSafe {
	public static boolean SQLInjection(String command) {
		command = command.toLowerCase();

		if (command.contains("#") || command.contains("*") || command.contains("'") || command.contains("\"")
				|| command.contains("and") || command.contains("or") || command.contains("--")) {
			return true;
		}
		return false;
	}

	public static boolean SQLInjection(String path, String encode, String command) throws FileTypeException {
		String text = TextFile.charRead(path, encode, ToolsConfig.NULL);
		command = command.toLowerCase();
		String[] content = null;
		if (path.endsWith("json") || path.endsWith("xml")) {
			if (path.endsWith("json")) {
				JSONObject jsonObject = JSONObject.fromObject(text);
				Iterator iterator = jsonObject.keys();
				content = new String[jsonObject.values().size()];
				int count = 0;
				while (iterator.hasNext()) {
					content[count++] = jsonObject.getString(iterator.next().toString());
				}
			} else {
				try {
					DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
					DocumentBuilder builder = factory.newDocumentBuilder();
					Document document = builder.parse(new InputSource(new StringReader(text)));
					Element root = document.getDocumentElement();
					NodeList children = root.getChildNodes();
					if (children != null) {
						int length = children.getLength();
						content = new String[length];
						for (int count = 0; count < length; count++) {
							content[count] = children.item(count).getTextContent();
						}
					}
				} catch (ParserConfigurationException e) {
					e.printStackTrace();
				} catch (SAXException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			for(int count = 0;count<content.length;count++) {
				if(content[count].equals("")||content[count]==null) {
					continue;
				}
				if(command.contains(content[count])) {
					return true;
				}
			}
			return false;
		} else {
			throw new FileTypeException("the file type error, must be json or xml");
		}
	}
}
