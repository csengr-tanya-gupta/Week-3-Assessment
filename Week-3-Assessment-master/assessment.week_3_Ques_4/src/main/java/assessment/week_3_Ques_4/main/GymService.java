package assessment.week_3_Ques_4.main;

import assessment.week_3_Ques_4.entity.Member;
import assessment.week_3_Ques_4.entity.Workout;

import jakarta.persistence.*;
import java.time.LocalDate;

public class GymService {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("gymPU");

    public void addMember(String name, String membership,
                          String exercise, int duration, String date) {

        if (duration <= 0) {
            System.out.println("Error: Duration must be positive.");
            return;
        }

        try {

            LocalDate workoutDate = LocalDate.parse(date);

            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            tx.begin();

            Member member = new Member(name, membership);

            Workout workout = new Workout(exercise, duration, workoutDate);

            member.addWorkout(workout);

            em.persist(member);

            tx.commit();

            em.close();

            System.out.println("Member added successfully");

        } catch (Exception e) {
            System.out.println("Invalid date format. Use yyyy-MM-dd");
        }
    }

    public void searchMember(int id) {

        EntityManager em = emf.createEntityManager();

        try {

            TypedQuery<Member> query =
                    em.createQuery("SELECT m FROM Member m WHERE m.id = :id", Member.class);

            query.setParameter("id", id);

            Member m = query.getSingleResult();

            System.out.println("\nID: " + m.getId());
            System.out.println("Name: " + m.getName());
            System.out.println("Membership: " + m.getMembershipType());
            System.out.println("Workouts:");

            for (Workout w : m.getWorkouts()) {

                System.out.println("  Exercise: " + w.getExerciseName());
                System.out.println("  Duration: " + w.getDuration());
                System.out.println("  Date: " + w.getWorkoutDate());
            }

        } catch (Exception e) {
            System.out.println("Member not found.");
        } finally {
            em.close();
        }
    }

    public void updateWorkout(int memberId, int workoutId, int newDuration) {

        if (newDuration <= 0) {
            System.out.println("Error: Duration must be positive.");
            return;
        }

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Member member = em.find(Member.class, memberId);

            if (member == null) {
                System.out.println("Member not found.");
                return;
            }

            boolean found = false;

            for (Workout w : member.getWorkouts()) {

                if (w.getId() == workoutId) {

                    w.setDuration(newDuration);
                    em.merge(member);

                    System.out.println("Workout updated successfully");
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Workout ID not found.");
            }

            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }

    public void deleteMember(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {

            tx.begin();

            Member member = em.find(Member.class, id);

            if (member == null) {
                System.out.println("Member not found.");
                return;
            }

            em.remove(member);

            tx.commit();

            System.out.println("Member deleted successfully");

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
    }
}