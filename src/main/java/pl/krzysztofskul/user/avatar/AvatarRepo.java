package pl.krzysztofskul.user.avatar;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AvatarRepo extends JpaRepository<Avatar, Long> {

    Avatar findByUserId(Long id);

}
