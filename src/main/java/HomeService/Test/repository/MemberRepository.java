package HomeService.Test.repository;

import HomeService.Test.bean.memberBean;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<memberBean,Integer> {
}
