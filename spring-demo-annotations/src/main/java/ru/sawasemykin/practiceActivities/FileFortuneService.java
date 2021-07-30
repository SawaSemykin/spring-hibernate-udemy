package ru.sawasemykin.practiceActivities;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import com.luv2code.springdemo.FortuneService;

@Component
public class FileFortuneService implements FortuneService {

	private List<String> fortunes;
	
	@Override
	public String getFortune() {
		Random randomator = new Random();
		int index = randomator.nextInt(fortunes.size());
		String theFortune = fortunes.get(index);
		return theFortune;
	}
	
	@PostConstruct
	private void readFromFile() {
		System.out.println(">> FileFortuneService: inside of readFromFile()");
		try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("fortunes.txt");
			 InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
			 BufferedReader reader = new BufferedReader(streamReader)
		) {
			fortunes = reader.lines().collect(Collectors.toList());
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
	/*
	@PostConstruct 
	private void readFromFile() {
		fortunes = new ArrayList<>();
		try( FileInputStream inFile = new FileInputStream("/home/sawa/spring/spring-hibernate-udemy-repo/spring-demo-annotations/src/fortunes.txt");
				InputStreamReader inputStreamReader = new InputStreamReader(inFile, "UTF8");				
				Reader reader = new BufferedReader(inputStreamReader);)
		{
			StringBuilder currentQuote = new StringBuilder();
			int intValue;			
			while((intValue = reader.read()) != -1) {
				char charValue = (char) intValue;
				if(charValue != '\n') {
					currentQuote.append(charValue);
				} else {
				fortunes.add(currentQuote.toString());
				currentQuote = new StringBuilder();
				}
			}
			fortunes.add(currentQuote.toString());
		} catch(IOException e){
			e.printStackTrace();
		}		
	}
	*/
}
