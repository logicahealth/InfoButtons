package edu.utah.openinfobutton.externalresource.implementation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import edu.duke.mc.cfm.dci.infobutton.schemas.kb.TerminologyInference.CodeInference.InferenceDefinition.LocalMappings.Mapping;

@Lazy
@Component
public class TerminologyMappings {

	String filename="validMappings.csv";
	List<Mapping> validMappings;
	public TerminologyMappings() {
		try {
			validMappings = new ArrayList<Mapping>();
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			InputStream mapInput = classLoader.getResourceAsStream(filename);
			BufferedReader br = new BufferedReader(new InputStreamReader(mapInput));
			String strLine = "";
			StringTokenizer st = null;
			while( (strLine = br.readLine()) != null)
			{
				try{
					Mapping mapping = new Mapping();
					st = new StringTokenizer(strLine,",");
					mapping.setSourceName(st.nextToken());
					mapping.setSourceValue(st.nextToken());
					mapping.setTargetName(st.nextToken());
//					st.nextToken();
					mapping.setTargetValue(st.nextToken());
//					mapping.setMapID(st.nextToken());
					validMappings.add(mapping);
				}
				catch (NoSuchElementException e) {
				}
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Mapping> getValidMappings() {
		return validMappings;
	}
	public void setValidMappings(List<Mapping> validMappings) {
		this.validMappings = validMappings;
	}
	
	
//	public static void main(String args[])
//	{
//		TerminologyMappings tm = new TerminologyMappings();
//		System.out.println(tm.validMappings);
//	}

	
}
