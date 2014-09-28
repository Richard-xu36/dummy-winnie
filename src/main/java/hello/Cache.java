package hello;
import java.util.*;

class Cache{
	private HashMap<String, User> map;
	private HashMap<String, String> lastmodified_map ;
	
	public Cache(){
		map = new HashMap<String, User>();
		lastmodified_map = new HashMap<String, String>();
	}

        // Return type indicates whether the user has changed since last_modified.
	public User getUser(final String user_id,
			    Boolean[] is_deleted, // Simulate pass by refence..
                            final String last_modified){
		is_deleted[0] = false;
		if (last_modified == null || 
		    !lastmodified_map.get(user_id).equals( last_modified)) {
			User user = map.get(user_id);
			if (user == null) {
			   is_deleted[0] = true;
			}
			return user;
		}
		return null;
	}

        public User getUser(String user_id) {
	     return map.get(user_id);
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

