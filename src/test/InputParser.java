package test;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.AutoDetectParser;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;

public class InputParser {

	public static void main(String[] args) {
		InputStream is = null;

		try {
			is = new BufferedInputStream(new FileInputStream(new File(
					"texts/washington.odt")));

			Parser parser = new AutoDetectParser();
			ContentHandler handler = new BodyContentHandler(System.out);

			Metadata metadata = new Metadata();

			parser.parse(is, handler, metadata, new ParseContext());
			
			handler.toString();
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TikaException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} finally {
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}