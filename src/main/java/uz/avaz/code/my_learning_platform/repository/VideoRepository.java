package uz.avaz.code.my_learning_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.avaz.code.my_learning_platform.entitiy.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
