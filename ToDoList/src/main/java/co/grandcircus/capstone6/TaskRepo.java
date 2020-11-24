package co.grandcircus.capstone6;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Tasks, Long> {
		
}
