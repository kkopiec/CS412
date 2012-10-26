import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.zip.GZIPInputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class GZReader extends DefaultHandler {
	private PDocument curentWorkDocumentData;
	private SAXParserFactory spf = SAXParserFactory.newInstance();
	private String currentString;
	private String currentGzFileName = "";
	private int readed=0;
	private int articles=0;
	
	/**
	 * Lists of allready processed files
	 */
	private ArrayList<PDocument> results = new ArrayList<PDocument>();

	/**
	 * parse all files in directory and sub-directories
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public ArrayList<PDocument> parse(String path) throws IOException {
		parseGzFile(path);
		return results;
	}

	

	/**
	 * 
	 * @param fname
	 * @throws IOException
	 */
	private void parseGzFile(String fname) throws IOException {
		

		File f = new File(fname);

		if (!f.exists())
			throw new IOException("File: " + fname + " do not exist!");

		// if f is directory
		if (f.isDirectory()) {
			// parse all files in it excluding . and ..
			for (File tf : f.listFiles()) {
				if (tf.getName().equalsIgnoreCase(".")
						|| tf.getName().equalsIgnoreCase(".."))
					continue;
				parseGzFile(tf.getAbsolutePath());
				
			}

		} else
		// if we found file to parse
		if (f.getName().endsWith(".gz")) {
			FileInputStream infile = new FileInputStream(fname);
			GZIPInputStream gzstream = new GZIPInputStream(infile);
			StringBuffer strbuf = new StringBuffer();
			strbuf.append("<a>");
			BufferedReader br = new  BufferedReader(new InputStreamReader(gzstream));
			String s;
			while((s = br.readLine())!=null)
			{
				strbuf.append(s);
			}
			strbuf.append("</a>");
			
			currentGzFileName = fname;
			try {
				SAXParser sp = spf.newSAXParser();
				sp.parse(new ByteArrayInputStream(strbuf.toString().getBytes()), this);
				readed++;
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {
		currentString = "";
		// when i see open
		if (qName.equalsIgnoreCase("doc")) {
			articles++;
			curentWorkDocumentData = new PDocument(currentGzFileName);
		}
	}

	public void characters(char[] ch, int start, int length)
			throws SAXException {
		currentString = new String(ch, start, length);
	}

	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		if (qName.equalsIgnoreCase("doc")) {
			results.add(curentWorkDocumentData);

		}
		if (qName.equalsIgnoreCase("DOCNO")) {
			curentWorkDocumentData.setDocNo(currentString);

		} else if (qName.equalsIgnoreCase("PROFILE")) {
			curentWorkDocumentData.setProfile(currentString);
		} else if (qName.equalsIgnoreCase("DATE")) {
			curentWorkDocumentData.setDate(currentString);
		} else if (qName.equalsIgnoreCase("headline")) {
			curentWorkDocumentData.setHeadline(currentString);
		} else if (qName.equalsIgnoreCase("TEXT")) {
			curentWorkDocumentData.setText(currentString);
		} else if (qName.equalsIgnoreCase("PUB")) {
			curentWorkDocumentData.setPub(currentString);
		} else if (qName.equalsIgnoreCase("Page")) {
			curentWorkDocumentData.setPage(currentString);
		} else if (qName.equalsIgnoreCase("BYLINE")) {
			curentWorkDocumentData.setByline(currentString);
		} else if (qName.equalsIgnoreCase("DATELINE")) {
			curentWorkDocumentData.setDateline(currentString);
		}
	}
	public void printStats()
	{
		System.out.println("Readed: "+ readed + " Files, "+ articles + " articles.");
	}
}
