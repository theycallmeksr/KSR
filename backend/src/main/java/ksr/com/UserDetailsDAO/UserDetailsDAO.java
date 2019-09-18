package ksr.com.UserDetailsDAO;
import java.util.List;
import ksr.com.UserDetails.userDetails;
public interface UserDetailsDAO {
	public boolean registerUser(userDetails UserDetails);
	public boolean deleteUser(userDetails UserDetails);
	public boolean updateUser(userDetails UserDetails);
	public userDetails getUser(String username);
}