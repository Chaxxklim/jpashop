package jpabook.jpashop;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
//       엔티티 매니저 팩토리는 하나만 생성해서 애플리케이션 전체에 공유
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpabook");
//      엔티티 매니저는 사용하고 버리는 형식(쓰레드간에 공유 X)
//       JPA 모든 데이터 변경은 트랜잭션 안에서 실행
        EntityManager em = emf.createEntityManager();
        EntityTransaction ts = em.getTransaction(); // 트랜잭션 시작 선언해야함
        ts.begin();

        try {



            ts.commit();
        } catch (Exception e){
            ts.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}