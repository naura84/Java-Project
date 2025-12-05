package models;

import java.time.LocalDateTime;

public class HealthRecord {
    private Integer id;
    private Integer userId;
    private String bloodType;
    private String allergies;
    private String chronicConditions;
    private String medications;
    private String emergencyInstructions;
    private LocalDateTime lastUpdate;

    public HealthRecord() {}
    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public Integer getUserId() { return userId; }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getBloodType() { return bloodType; }

    public void setBloodType(String bloodType) { this.bloodType = bloodType; }

    public String getAllergies() { return allergies; }

    public void setAllergies(String allergies) { this.allergies = allergies; }

    public String getChronicConditions() { return chronicConditions; }

    public void setChronicConditions(String chronicConditions) { this.chronicConditions = chronicConditions; }

    public String getMedications() { return medications; }

    public void setMedications(String medications) { this.medications = medications; }

    public String getEmergencyInstructions() { return emergencyInstructions; }

    public void setEmergencyInstructions(String emergencyInstructions) { this.emergencyInstructions = emergencyInstructions; }

    public LocalDateTime getLastUpdate() { return lastUpdate; }

    public void setLastUpdate(LocalDateTime lastUpdate) { this.lastUpdate = lastUpdate; }
}
