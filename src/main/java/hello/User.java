package hello;

import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import com.fasterxml.jackson.annotation.JsonCreator;

public class User
{
  private String email, password;
  private String user_id = "u-";
  private String name;
  private String created_at, updated_at;
  private Long last_modified; 
  static int count = 100; 
  static DateFormat dateFormat = new SimpleDateFormat("yyyy/mm/dd hh:mm:ss");
  static Date date;
  
  @JsonCreator
  public User(Map<String,Object> props)
  {
    this.password = (String) props.get("password");
    this.email = (String) props.get("email");
    if (this.email == null || this.password == null) {
      // Invalid object.
      return;
    }
    this.name = (String) props.get("name");
    this.user_id += Integer.toString(++count);
    date = new Date();
    this.created_at = dateFormat.format(date);
    this.updated_at = created_at;
    this.last_modified = System.currentTimeMillis(); 
  }
  
  public User(String email, String password){
	  this.email = email;
	  this.password = password;
	  this.user_id = Integer.toString(++count);
	  date = new Date();
	  created_at = dateFormat.format(date);
	  updated_at = created_at;
  }
  
  public String getUserId(){
	  return this.user_id;
  }
  
  public String getName(){
	  return this.name;
  }
  
  public String getEmail(){
	  return this.email;
  }
  
  public String getPassword() {
	  return this.password;
  }
  
  public String getCreated_at(){
	  return this.created_at;
  }
 
  public String getUpdated_at(){
	  return this.updated_at;
  }

  public Long getLastModified() {
	  return this.last_modified;
  }

  public void setUserName(String _name){
	  this.name = _name;
	  date = new Date();
	  this.updated_at = dateFormat.format(date);
	  this.last_modified = System.currentTimeMillis(); 
  }
  
  public void setPassword(String password){
	  this.password = password;
	  date = new Date();
	  this.updated_at = dateFormat.format(date);
	  this.last_modified = System.currentTimeMillis(); 
  }
  
  public void setEmail(String email){
	  this.email = email;
	  date = new Date();
	  this.updated_at = dateFormat.format(date);
	  this.last_modified = System.currentTimeMillis(); 
  }
  
 
  public String toString(){
	  return "{\nuser_id: " + this.user_id + 
   		   "\nemail: "+ this.email+ 
   		   "\npassword: "+ this.password + 
   		   "\ncreated_at:"+ this.created_at +
   		   "\nupdated_at:"+ this.updated_at + "\n}\n\n";
  }
}

