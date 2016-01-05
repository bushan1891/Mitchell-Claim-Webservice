package com.mitchell.Utils;

import java.io.File;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import com.mitchell.JXAB.model.MitchellClaim;

public class ValidatorJAXB {

	public static MitchellClaim Validatoor(JAXBElement<MitchellClaim> claim) throws JAXBException{
		
		
		

		StringWriter writer = new StringWriter();
		File file = new File("unvalidated.xml");
		JAXBContext context = JAXBContext.newInstance(MitchellClaim.class);
		Marshaller m = context.createMarshaller();
		m.marshal(claim, file);
		m.marshal(claim, writer);

		String theXML = writer.toString();
		System.out.println(theXML);

		// VALIDATING XML AGAIST XSD
		try {
			String schemaLang = "http://www.w3.org/2001/XMLSchema";
			SchemaFactory factory = SchemaFactory.newInstance(schemaLang);
			Schema schema = factory.newSchema(
					new StreamSource("C://Users/Bushan/Desktop/Mitchell/Coding Challenge/MitchellClaim.xsd"));
			Validator validator = schema.newValidator();

			validator.validate(new StreamSource("C://Users/Bushan/Desktop/unvalidated.xml"));
			System.out.println("Validate successfull");

		} catch (SAXException e) {
			System.out.println(" sax exception :" + e.getMessage());
		} catch (Exception ex) {
			System.out.println("excep :" + ex.getMessage());
		}

		JAXBContext jc = JAXBContext.newInstance(MitchellClaim.class);
		Unmarshaller unmarshaller = jc.createUnmarshaller();
		File xml = new File("C://Users/Bushan/Desktop/unvalidated.xml");

		MitchellClaim mc = (MitchellClaim) unmarshaller.unmarshal(xml);
		System.out.println(mc.getClaimNumber());
		
		return mc;
		
	}
	
	
}
