public class Client {

 private String name;
 private Survey survey;

 public Client(String name) {
  this.name = name;
 }

 public String getName() {
  return name;
 }

 public Survey getSurvey() {
  return survey;
 }

 public void createSurvey() {
  this.survey = new Survey();
 }

 public void displaySurvey() {
  this.survey.open();
  this.survey.close();
 }

 public void showResults() {
  this.survey.showResults();
 }
}
