import java.util.ArrayList;

public class Patient implements Comparable<Patient>{
	private String name = "";
	private int age;
	private String gender = "";
	private String complaint = "";
	private String alertnessLevel;
	private int heartRate;
	private int bloodPressure1;
	private int bloodPressure2;
	private int respirationRate;
	private double temperature;
	private int oxygenSaturation;
	private String heartRateAssessment = "";
	private String bloodPressureAssessment = "";
	private String respirationRateAssessment = "";
	private String fever = "";
	private String oxygenSaturationAssessment = "";
	private int painLevel;
	private int triageLevel = 0;
	private double timeWaited = 0;
	private double startTime;
	private double endTime;
	private String doctor = "";
	private ArrayList<String> medications = new ArrayList<String>();
	public Patient() {
		name ="";
		age = 0;
		complaint = "";
		alertnessLevel = "";
		heartRate = 0;
		bloodPressure1 = 0;
		bloodPressure2 = 0;
		respirationRate = 0;
		temperature = 0;
		oxygenSaturation = 0;
		painLevel = 0;
	}
	public Patient(String name1, int age1, String complaint1, String alertnessLevel1, int heartRate1, int bloodPressure1a, int bloodPressure2a, int respirationRate1, double temp1, int oxygenSaturation1, int painLevel1, ArrayList<String> medications1) {
		name = name1;
		age = age1;
		complaint = complaint1;
		alertnessLevel = alertnessLevel1;
		heartRate = heartRate1;
		bloodPressure1 = bloodPressure1a;
		bloodPressure2 = bloodPressure2a;
		respirationRate = respirationRate1;
		temperature = temp1;
		oxygenSaturation = oxygenSaturation1;
		painLevel = painLevel1;
		medications = medications1;
	}
	public void setName(String a) {
		name  = a;
	}
	public void setAge(int a) {
		age = a;
	}
	public void setGender(String a) {
		gender = a;
	}
	public void addMedicationList(String a) {
		this.medications.add(a);
	}
	public void setComplaint(String a) {
		complaint = a;
	}
	public void setAlertnessLevel(String a) {
		alertnessLevel = a;
	}
	public void setBloodPressure1(int a) {
		bloodPressure1 = a;
	}
	public void setBloodPressure2(int a) {
		bloodPressure2 = a;
	}
	public void setRespirationRate(int a) {
		respirationRate = a;
	}
	public void setTemp(double a) {
		temperature = a;
	}
	public void setOxygenSaturation(int a) {
		oxygenSaturation = a;
	}
	public void setPainLevel(int a) {
		painLevel = a;
	}
	public void setHeartRate(int a) {
		heartRate = a;
	}
	public void setDoctorNeeded(String a) {
		doctor = a;
	}
	public void setTimeWaited() {
		timeWaited = endTime - startTime;
	}
	public void setStartTime(double a) {
		startTime = a;
	}
	public void setEndTime(double a) {
		endTime = a;
	}
	public double getTimeWaited() {
		return timeWaited;
	}
	public String getName() {
		return name;
	}
	public int getAge() {
		return age;
	}
	public String getGender() {
		return gender;
	}
	public String getComplaint() {
		return complaint;
	}
	public String getAlertness() {
		return alertnessLevel;
	}
	public int getHeartRate() {
		return heartRate;
	}
	public int getRespirationRate() {
		return respirationRate;
	}
	public double getTemp() {
		return temperature;
	}
	public int getOxygenSaturation() {
		return oxygenSaturation;
	}
	public int getPainLevel() {
		return painLevel;
	}
	public int getBloodPressure1() {
		return bloodPressure1;
	}
	public int getBloodPressure2() {
		return bloodPressure2;
	}
	public int getTriageLevel() {
		return triageLevel;
	}
	public int compareTo(Patient a) {
		if (this.getTriageLevel() > a.getTriageLevel()) {
			return 1;
		}
		else if (this.getTriageLevel() < a.getTriageLevel()) {
			return -1;
		}
		else {
			return 0;
		}
	}
	public String doctorNeeded(String[] cancer, String[] neuro, String[] cardiac) {
		for (int i = 0; i < cardiac.length; i++) {
			for (int j = 0; j < medications.size(); j++) {
				if (cancer.length <= cardiac.length) {
					if(medications.get(j).equals(cancer[i])) {
					return "Oncologist";
					}
				}
				if (neuro.length <= cardiac.length) {
					if(medications.get(j).equals(neuro[i])) {
					return "Neurologist";
					}
				}
				if(medications.get(j).equals(cardiac[i])) {
					return "Cardiologist";
				}
			}
		}
	
		return "N/A";	
	}
	public void setTriageLevel() {
		if (heartRateAssessment.equals("Cardiac Arrest") || temperature > 105 || oxygenSaturation < 90 || respirationRate < 6 || bloodPressureAssessment.equals("diastolic")  || alertnessLevel.equals("U")) {
			 triageLevel = 1;
		}
		else if(alertnessLevel.equals("P")  || alertnessLevel.equals("V") || oxygenSaturation < 95 && oxygenSaturation > 90 || (bloodPressure1 >140 && bloodPressure2 > 90)) {
			 triageLevel = 2;
		}
		else {
		 triageLevel = 3;
		}
	}
	public void vitalAssessment() {
		//Checking Heart Rate
		if(heartRate <= 100 && heartRate >= 60) {
			heartRateAssessment = "Normal";
		}
		else if (heartRate > 100) {
			heartRateAssessment = "Tachycardia";
		}
		else if (heartRate > 150 || heartRate < 30) {
			heartRateAssessment = "Cardiac Arrest";
		}
		else {
			heartRateAssessment = "Bradycardia";
		}
		//Checking Blood Pressure
		if(bloodPressure1 >= 90 && bloodPressure1 <= 140 && bloodPressure2 <= 90 && bloodPressure2 >= 60) {
			bloodPressureAssessment = "Normal";
		}
		else if (bloodPressure1 > 140 && bloodPressure2 > 90) {
			bloodPressureAssessment = "Systolic";
		}
		else {
			bloodPressureAssessment = "disatolic";
		}
		//Checking Respiration Rate
		if(respirationRate >= 16 && respirationRate <= 20) {
			respirationRateAssessment = "Normal";
		}
		else if (respirationRate > 20) {
			respirationRateAssessment = "Tachypnea";
		}
		else {
			respirationRateAssessment = "Bradypnea";
		}
		//Checking for fever
		if (temperature < 100) {
			fever = "No";
		}
		else {
			fever = "Yes";
		}
		//Checking Oxygen Saturation
		if (oxygenSaturation >= 95 && oxygenSaturation <= 100) {
			oxygenSaturationAssessment = "Normal";
		}
		else if (oxygenSaturation < 95 && oxygenSaturation > 90) {
			oxygenSaturationAssessment = "Low";
		}
		else {
			oxygenSaturationAssessment = "Danger";
		}
		
	}
	public String toString() {
		String temp = "";
		temp += "Name : " + name + 
			 "\r\nAge : " + age + 
			 "\r\nGender : " + gender + 
			 "\r\nComplaint : " + complaint + 
			 "\r\nTriage Level :" + " " + triageLevel +
			 "\r\nAlertness Level : " + alertnessLevel + 
			 "\r\nDoctor Needed : " + doctor + 
			 "\r\nHeartrate : " + heartRate + " " + heartRateAssessment +
			 "\r\nBlood Pressure : " + bloodPressure1 + "/" + bloodPressure2 + " " + bloodPressureAssessment + 
			 "\r\nRespiration Rate : " + respirationRate + " " + respirationRateAssessment + 
			 "\r\nTemperature : " + temperature + " " + fever +
			 "\r\nOxygen Saturation : " + oxygenSaturation + "% " + oxygenSaturationAssessment +
			 "\r\nPain Level : " + painLevel +
			 "\r\nTime before being seen : " + timeWaited + "ms" +
			 "\r\nMedications : ";
		for (int i = 0; i < medications.size(); i++) {
				temp += medications.get(i) + ", ";
			}
		return temp;
	}
}