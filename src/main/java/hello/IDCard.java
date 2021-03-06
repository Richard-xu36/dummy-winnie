package hello;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonCreator;

public class IDCard{
  private String card_id = "c-";
  private String card_name, card_number;
  private String expiration_date;
  static int count = 100;
  
  @JsonCreator
  public IDCard(Map<String,Object> props) {
    this.card_name = (String) props.get("card_name");
    this.card_number = (String) props.get("card_number");
    SimpleDateFormat df = new SimpleDateFormat("MM-dd-yyyy");
    this.expiration_date = (String) props.get("expiration_date");

    this.card_id += Integer.toString(++count);
  }
  
  public String getCardId(){
	  return this.card_id;
  }
  
  public String getCardName(){
	  return this.card_name;
  }
  
  public String getCardNumber(){
	  return this.card_number;
  }
  
  public String getExpirationDate() {
	  return this.expiration_date;
  }
  
 
  public String toString(){
	  return "{\ncard_id: " + this.card_id +
			 "\ncard_name: " + this.card_name +
			 "\ncard_number: " + this.card_number +
			 "\nexpiration_date: " + this.expiration_date +"\n}\n";
  }
}

