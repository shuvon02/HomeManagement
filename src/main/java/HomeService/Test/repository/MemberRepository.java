package HomeService.Test.repository;

import HomeService.Test.bean.MemberBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface MemberRepository extends JpaRepository<MemberBean,Integer> {
}
