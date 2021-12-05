import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.*;
public class Z23022383 {
	public static void main(String[] args) throws IOException {
		try {
		FileReader cardiacFile = new FileReader(args[0]);
		FileReader cancerFile = new FileReader(args[1]);
		FileReader neuroFile = new FileReader(args[2]);
		FileReader patientFile = new FileReader(args[3]);
		BufferedReader cancerReader = new BufferedReader(cancerFile);
		BufferedReader cardiacReader = new BufferedReader(cardiacFile);
		BufferedReader neuroReader = new BufferedReader(neuroFile);
		BufferedReader patientReader = new BufferedReader(patientFile);
		String cancer = "", cardiac = "", neuro = "", patient = "";
		String cancerLine = cancerReader.readLine();
		String cardiacLine = cardiacReader.readLine();
		String neuroLine = neuroReader.readLine();
		String patientLine = patientReader.readLine();
		ArrayList<String> patientList = new ArrayList<String>();
		PriorityQueue<Patient> pq = new PriorityQueue<Patient>();
		int startTime, endTime;
		int fileCount = 1;
		while (cancerLine != null) {	
			cancer += cancerLine + "\n";
			cancerLine = cancerReader.readLine();
		}
		while (cardiacLine != null ) {	
			cardiac += cardiacLine + "\n";
			cardiacLine = cardiacReader.readLine();
		}
		while (neuroLine != null) {
			neuro += neuroLine + "\n";
			neuroLine = neuroReader.readLine();
		}
		while (patientLine != null) {
			patient += patientLine + "\n";
			patientLine = patientReader.readLine();
		}
		cancerReader.close();
		cardiacReader.close();
		neuroReader.close();
		patientReader.close();
		patient = patient.replace(" ", "");
		patient = patient.replaceAll("-", "");
		String can[] = cancer.split("\n");
		String card[] = cardiac.split("\n");
		String neur[] = neuro.split("\n");
		String pat[] = patient.split("\n");
		for (String temp : pat) {
			patientList.add(temp);
		}
		for (int i = 0; i < patientList.size(); i++) {
			int count = 1;
			Patient a = new Patient();
			String split[] = patientList.get(i).split(",");
			for (String temp : split) {
				if (count == 1) {
					a.setName(temp);
				}
				else if (count == 2) {
					a.setAge(Integer.parseInt(temp));
				}
				else if (count == 3) {
					a.setGender(temp);
				}
				else if (count == 4) {
					a.setComplaint(temp);
				}
				else if(count == 5) {
					a.setAlertnessLevel(temp);
				}
				else if (count == 6) {
					a.setHeartRate(Integer.parseInt(temp));
				}
				else if(count == 7) {
					a.setBloodPressure1(Integer.parseInt(temp.substring(0, temp.indexOf("/"))));
					a.setBloodPressure2(Integer.parseInt(temp.substring(temp.indexOf("/") + 1, temp.length())));
				}
				else if(count == 8) {					
					a.setRespirationRate(Integer.parseInt(temp));
				}
				else if (count == 9) {
					a.setTemp(Double.parseDouble(temp));
				}
				else if (count == 10) {
					a.setOxygenSaturation(Integer.parseInt(temp.substring(0, temp.indexOf("%"))));
				}
				else if (count == 11) {
					a.setPainLevel(Integer.parseInt(temp));
				}
				else {
					if (temp != null) {
					a.addMedicationList(temp);
					}
				}
				count++;
			}
			
			a.setDoctorNeeded(a.doctorNeeded(can, neur, card));
			a.vitalAssessment();  
			a.setTriageLevel();
			//System.out.println(a.toString() + "\n ---------------------------------------");
			a.setStartTime(System.currentTimeMillis());
			pq.add(a);
		
		}
		while(!pq.isEmpty()) {
			FileWriter fileWriter = new FileWriter(Integer.toString(fileCount)+".txt");
			PrintWriter printWriter = new PrintWriter(fileWriter);
			pq.peek().setEndTime(System.currentTimeMillis());
			pq.peek().setTimeWaited();
			printWriter.print(pq.remove());
			printWriter.close();
			fileCount++;
		}

		}
		catch(IOException e) {
			System.out.println(e);
		}
		
		
	}

}
z