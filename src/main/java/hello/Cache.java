package hello;
import java.util.*;

class Cache{
	private HashMap<String, User> map;
	private HashMap<String, Long> lastmodified_map;
	
	public Cache(){
		map = new HashMap<String, User>();
		lastmodified_map = new HashMap<String, Long>();
	}

	public User getUser(String user_id){
		if (this.map.containsKey(user_id))
			return this.map.get(user_id);
		else
			return new User("","");
	}

	public void addUser(User user){
		this.map.put(user.getUserId(),user);
		this.lastmodified_map.put(user.getUserId(), user.getLastModified());
    }

	public void updateUser(String user_id, String password,String email){
		this.getUser(user_id).setPassword(password);
		this.getUser(user_id).setEmail(email);
		this.lastmodified_map.put(user_id, this.getUser(user_id).getLastModified());
    }	
	
	public String toString() {
		String output = "";
		for (User value:this.map.values()){
			output += value + "\n";
		}
		return output;
		
	}
   
}

