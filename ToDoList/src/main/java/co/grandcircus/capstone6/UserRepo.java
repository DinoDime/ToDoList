package co.grandcircus.capstone6;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<Users, Long> {

	public Users findByEmail(String email);
	
}
